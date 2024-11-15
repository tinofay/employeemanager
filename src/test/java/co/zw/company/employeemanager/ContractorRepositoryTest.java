package co.zw.company.employeemanager;

import co.zw.company.employeemanager.entity.Contractor;
import co.zw.company.employeemanager.repository.ContractorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.time.LocalDate;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ContractorRepositoryTest {

    @Autowired
    private ContractorRepository contractorRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    private Contractor contractor;

    @BeforeEach
    public void setUp(){
        contractor = new Contractor();
        contractor.setName("Tino Zee");
        contractor.setEmail("tinozee@contractor.com");
        contractor.setContractStartDate(LocalDate.of(2023, 1, 1));
        contractor.setContractEndDate(LocalDate.of(2023, 6, 30));
    }


    @Test
    public void findContractorByStartDate_shouldReturnContractor(){

        testEntityManager.persist(contractor);
        testEntityManager.flush();

        contractorRepository.findContractorByContractStartDate(LocalDate.of(2023, 1, 1));

        Assertions.assertThat(contractor).isNotNull();
    }

    @Test
    public void saveContractor_shouldReturnContractor(){

        testEntityManager.persist(contractor);
        testEntityManager.flush();

        Assertions.assertThat(contractor.getName()).isEqualTo("Tino Zee");
    }


}
