package co.zw.company.employeemanager;

import co.zw.company.employeemanager.entity.Contractor;
import co.zw.company.employeemanager.repository.ContractorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContractorRepositoryTest {

    @Autowired
    private ContractorRepository contractorRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByEndDate_shouldReturnContractor(){
        //given
        Contractor contractor = new Contractor();
        contractor.setName("Tino Zee");
        contractor.setEmail("tinozee@contractor.com");
        contractor.setStart(LocalDate.of(2023, 1, 1));
        contractor.setEnd(LocalDate.of(2023, 6, 30));
        contractorRepository.save(contractor);

        //when
        Contractor foundContractor = contractorRepository.findByStart(LocalDate.of(2023, 1, 1));

        //then
        Assertions.assertThat(foundContractor).isNotNull();
        Assertions.assertThat(foundContractor.getName()).isEqualTo("Tino Zee");}

}
