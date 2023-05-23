package co.zw.company.employeemanager;

import co.zw.company.employeemanager.entity.Contractor;
import co.zw.company.employeemanager.repository.ContractorRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContractorRepositoryTest {

    @Autowired
    private ContractorRepository contractorRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findContractorByStartDate_shouldReturnContractor(){
        //given
        Contractor contractor = new Contractor();
        contractor.setName("Tino Zee");
        contractor.setEmail("tinozee@contractor.com");
        contractor.setContractStartDate(LocalDate.of(2023, 1, 1));
        contractor.setContractEndDate(LocalDate.of(2023, 6, 30));
        contractorRepository.save(contractor);

        //when
        Contractor foundContractor = contractorRepository.findContractorByContractStartDate(LocalDate.of(2023, 1, 1));

        //then
        Assertions.assertThat(foundContractor).isNotNull();
        Assertions.assertThat(foundContractor.getName()).isEqualTo("Tino Zee");}



}
