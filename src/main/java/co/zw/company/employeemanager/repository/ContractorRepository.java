package co.zw.company.employeemanager.repository;

import co.zw.company.employeemanager.entity.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {
    Contractor findByStart(LocalDate start);
}
