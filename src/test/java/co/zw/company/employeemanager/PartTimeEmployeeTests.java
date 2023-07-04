package co.zw.company.employeemanager;

import co.zw.company.employeemanager.parttimeemployee.model.PartTimeEmployee;
import co.zw.company.employeemanager.parttimeemployee.repository.PartTimeEmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThrows;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PartTimeEmployeeTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PartTimeEmployeeRepository partTimeEmployeeRepository;

    private PartTimeEmployee partTimeEmployee;

   // @Before
        public void setUp(){
            partTimeEmployee = new PartTimeEmployee();
            partTimeEmployee.setName("Jon Doe");
            partTimeEmployee.setEmail("jondoe@weird.com");
            partTimeEmployee.setHourlyRate(1.1);
            partTimeEmployee.setContractedHours(5.0);

        }

        @Test
        public void givenPartTimeEmployeeId_whenFindById_shouldReturnPartTimeEmployee()throws Exception {
            entityManager.persist(partTimeEmployee);
            entityManager.flush();

            partTimeEmployeeRepository.getById(partTimeEmployee.getId());
            Assertions.assertThat(partTimeEmployee.getId()).isEqualTo(1L).isNotNull();
        }
        @Test
        public void givenPartTimeEmployee_whenSave_shouldReturnPartTimeEmployee() {

            entityManager.persist(partTimeEmployee);
            entityManager.flush();

            Assertions.assertThat(partTimeEmployee.getName()).isEqualTo("Jon Doe");
        }

        @Test
        public void givenPartTimeEmployee_whenDelete_thenRemove () throws Exception {

            entityManager.persist(partTimeEmployee);
            entityManager.flush();

            partTimeEmployeeRepository.deleteById(partTimeEmployee.getId());

            Assertions.assertThat(partTimeEmployeeRepository.findById(partTimeEmployee.getId()).orElse(null)).isNull();

        }

        @Test
        public void givenPartTimeEmployeeList_whenFindAll_shouldReturnPartTimeEmployeeList () {
            PartTimeEmployee partTimeEmployee1 = new PartTimeEmployee();
            partTimeEmployee.setName("Jon Doe");
            partTimeEmployee.setEmail("jondoe@weird.com");
            partTimeEmployee.setHourlyRate(1.1);
            partTimeEmployee.setContractedHours(5.0);

            entityManager.persist(partTimeEmployee);
            entityManager.persist(partTimeEmployee1);
            entityManager.flush();

            List<PartTimeEmployee> partTimeEmployeeList = partTimeEmployeeRepository.findAll();

            Assertions.assertThat(partTimeEmployeeList).isNotNull();
            Assertions.assertThat(partTimeEmployeeList.size()).isEqualTo(2);

        }

    @Test
    @Order(1)
    public void updatePartTimeEmployee1(){
        partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setName("Jon Doe");
        partTimeEmployee.setEmail("jondoe@weird.com");
        partTimeEmployee.setHourlyRate(1.1);
        partTimeEmployee.setContractedHours(5.1);
        partTimeEmployeeRepository.save(partTimeEmployee);

    }
    @Test
    @Order(2)
    public void updatePartTimeEmployee2(){
        partTimeEmployee = partTimeEmployeeRepository.findById(partTimeEmployee.getId()).get();
        partTimeEmployee.setName("Jon Doe");
        partTimeEmployee.setEmail("jondoe@weird.com");
        partTimeEmployee.setHourlyRate(1.2);
        partTimeEmployee.setContractedHours(5.2);
        partTimeEmployeeRepository.save(partTimeEmployee);

    }
    @Test
    @Order(3)
    public void updatePartTimeEmployee3(){
        partTimeEmployee = partTimeEmployeeRepository.findById(partTimeEmployee.getId()).get();
        partTimeEmployee.setName("Jon Doe");
        partTimeEmployee.setEmail("jondoe@weird.com");
        partTimeEmployee.setHourlyRate(1.3);
        partTimeEmployee.setContractedHours(5.3);
        partTimeEmployeeRepository.save(partTimeEmployee);

    }
    @Test
    @Order(4)
    public void givenPartTimeEmployee_whenUpdatingTwice_throwsException () {

        assertThrows(OptimisticLockingFailureException.class,
                ()->{updatePartTimeEmployee3();});
    }

    @Test
    //@Order(5)
    public void givenMultipleThreads_whenUpdatingPartTimeEmployee_thenOptimisticLockingExceptionIsThrown() throws InterruptedException {
        // Create a new PartTimeEmployee
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setName("Jon Doe");
        partTimeEmployee.setEmail("jondoe@weird.com");
        partTimeEmployee.setHourlyRate(1.1);
        partTimeEmployee.setContractedHours(5.1);
        partTimeEmployeeRepository.save(partTimeEmployee);

        // Create two threads that will concurrently update the PartTimeEmployee
        Thread thread1 = new Thread(() -> {
            Optional<PartTimeEmployee> optional = partTimeEmployeeRepository.findById(partTimeEmployee.getId());
            if (optional.isPresent()) {
                PartTimeEmployee pte = optional.get();
                pte.setHourlyRate(1.2);
                partTimeEmployeeRepository.save(pte);
            }
        });

        Thread thread2 = new Thread(() -> {
            Optional<PartTimeEmployee> optional = partTimeEmployeeRepository.findById(partTimeEmployee.getId());
            if (optional.isPresent()) {
                PartTimeEmployee pte = optional.get();
                pte.setContractedHours(5.2);
                partTimeEmployeeRepository.save(pte);
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for the threads to finish
        thread1.join();
        thread2.join();

        // Check that an OptimisticLockingFailureException is thrown
        assertThrows(OptimisticLockingFailureException.class, () -> {
            partTimeEmployeeRepository.save(partTimeEmployee);
        });
    }
}

