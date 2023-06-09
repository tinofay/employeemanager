package co.zw.company.employeemanager;

import co.zw.company.employeemanager.entity.PartTimeEmployee;
import co.zw.company.employeemanager.repository.PartTimeEmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.assertj.core.api.Assertions;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PartTimeEmployeeTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PartTimeEmployeeRepository partTimeEmployeeRepository;

    private PartTimeEmployee partTimeEmployee;

    @Before
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

        Assertions.assertThat(partTimeEmployee).isNotNull();
    }

    @Test
    public void givenPartTimeEmployee_whenSave_shouldReturnPartTimeEmployee(){
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setName("Jon Doe");
        partTimeEmployee.setEmail("jondoe@weird.com");
        partTimeEmployee.setHourlyRate(1.1);
        partTimeEmployee.setContractedHours(5.0);

        entityManager.persist(partTimeEmployee);
        entityManager.flush();

        assertEquals(partTimeEmployee.getId(), partTimeEmployeeRepository.findById(partTimeEmployee.getId()).orElse(null).getId());

    }

    @Test
    public void givenPartTimeEmployee_whenDelete_thenRemove() throws Exception{
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
        partTimeEmployee.setName("Jon Doe");
        partTimeEmployee.setEmail("jondoe@weird.com");
        partTimeEmployee.setHourlyRate(1.1);
        partTimeEmployee.setContractedHours(5.0);

        entityManager.persist(partTimeEmployee);
        entityManager.flush();

        partTimeEmployeeRepository.deleteById(partTimeEmployee.getId());

        Assertions.assertThat(partTimeEmployeeRepository.findById(partTimeEmployee.getId()).orElse(null)).isNull();

    }

    @Test
    public void givenPartTimeEmployeeList_whenFindAll_shouldReturnPartTimeEmployeeList(){
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


}
