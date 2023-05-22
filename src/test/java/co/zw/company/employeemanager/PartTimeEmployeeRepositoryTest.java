package co.zw.company.employeemanager;

import co.zw.company.employeemanager.entity.PartTimeEmployee;
import co.zw.company.employeemanager.repository.PartTimeEmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PartTimeEmployeeRepositoryTest {

    @Autowired
    private PartTimeEmployeeRepository partTimeEmployeeRepository;
    @Autowired
    private EntityManager entityManager;

    @Test
   public void savePartTimeEmployeeTest(){
        PartTimeEmployee partTimeEmployee = PartTimeEmployee.builder()
                .name("Din")
                .email("dingrogu@galaxyymail.tat")
                .hourlyRate(1.1)
                .contractedHours(17.0)
                .build();

        entityManager.persist(partTimeEmployee);
        entityManager.flush();

        assertEquals(partTimeEmployee.getId(), partTimeEmployeeRepository.findById(partTimeEmployee.getId()).orElse(null).getId());
    }

    @Test
    public void testDeleteFullTimeEmployee() {
        PartTimeEmployee partTimeEmployee = PartTimeEmployee.builder()
                .name("Din")
                .email("dingrogu@galaxyymail.tat")
                .hourlyRate(1.1)
                .contractedHours(17.0)
                .build();

        entityManager.persist(partTimeEmployee);
        entityManager.flush();

        partTimeEmployeeRepository.deleteById(partTimeEmployee.getId());

        Assertions.assertThat(partTimeEmployeeRepository.findById(partTimeEmployee.getId()).orElse(null)).isNull();
    }

}
