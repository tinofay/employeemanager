package co.zw.company.employeemanager;

//import org.junit.jupiter.api.Assertions;

import co.zw.company.employeemanager.entity.FullTimeEmployee;
import co.zw.company.employeemanager.repository.FullTimeEmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@RunWith(SpringRunner.class)
public class FullTimeEmployeeRepositoryTest {
    @Autowired
    private FullTimeEmployeeRepository fullTimeEmployeeRepository;
    @Autowired
    private TestEntityManager  testEntityManager;


    @Test
    public void saveTest(){
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        fullTimeEmployee.setEmail("munyagapu@gmail.com");
        fullTimeEmployee.setBenefits("fuel allowance");
        fullTimeEmployee.setName("munyaradzi gapu");
        fullTimeEmployee.setSalary(4500.00);

        testEntityManager.persist(fullTimeEmployee);
        testEntityManager.flush();

        fullTimeEmployeeRepository.save(fullTimeEmployee);
        Assertions.assertThat(fullTimeEmployee.getId()).isGreaterThan(0);


    }
    @Test
    @Order(2)
    public void getEmployee(){
        FullTimeEmployee fullTimeEmployee=new FullTimeEmployee();
        fullTimeEmployee.setEmail("munyagapu@gmail.com");

        fullTimeEmployee.setBenefits("fuel allowance");
        fullTimeEmployee.setName("munyaradzi gapu");
        fullTimeEmployee.setSalary(4500.00);
        fullTimeEmployeeRepository.save(fullTimeEmployee);

        FullTimeEmployee fullTimeEmployeeFind=fullTimeEmployeeRepository.findById(1L).get();
        Assertions.assertThat(fullTimeEmployeeFind.getId()).isEqualTo(1L);


    }
    @Test
    @Order(3)
    public void getListEmployees(){
        FullTimeEmployee fullTimeEmployee=new FullTimeEmployee();
        fullTimeEmployee.setEmail("munyagapu@gmail.com");

        fullTimeEmployee.setBenefits("fuel allowance");
        fullTimeEmployee.setName("munyaradzi gapu");
        fullTimeEmployee.setSalary(4500.00);
        fullTimeEmployeeRepository.save(fullTimeEmployee);

        List<FullTimeEmployee> fullTimeEmployees=fullTimeEmployeeRepository.findAll();
        Assertions.assertThat(fullTimeEmployees.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateEmployees(){
        FullTimeEmployee fullTimeEmployeeSave=new FullTimeEmployee();
        fullTimeEmployeeSave.setEmail("munyagapu@gmail.com");

        fullTimeEmployeeSave.setBenefits("fuel allowance");
        fullTimeEmployeeSave.setName("munyaradzi gapu");
        fullTimeEmployeeSave.setSalary(4500.00);
        fullTimeEmployeeRepository.save(fullTimeEmployeeSave);
        FullTimeEmployee fullTimeEmployee=fullTimeEmployeeRepository.findById(1L).get();
        fullTimeEmployee.setEmail("gapu@gmail.com");
        FullTimeEmployee fullTimeEmployee2=fullTimeEmployeeRepository.save(fullTimeEmployee);
        Assertions.assertThat(fullTimeEmployee2.getEmail()).isEqualTo("gapu@gmail.com");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployees(){

        FullTimeEmployee fullTimeEmployee=fullTimeEmployeeRepository.findById(1L).get();
        fullTimeEmployeeRepository.delete(fullTimeEmployee);
        FullTimeEmployee checkfulltimevariable=null;
        Optional<FullTimeEmployee> optionalFullTimeEmployee=fullTimeEmployeeRepository.findByEmail("gapu@gmail.com");
        if(optionalFullTimeEmployee.isPresent()){
            checkfulltimevariable=optionalFullTimeEmployee.get();
        }
        Assertions.assertThat(checkfulltimevariable).isNull();


    }

}
