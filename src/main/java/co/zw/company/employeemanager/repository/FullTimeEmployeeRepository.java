package co.zw.company.employeemanager.repository;

import co.zw.company.employeemanager.entity.FullTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FullTimeEmployeeRepository extends JpaRepository<FullTimeEmployee, Long>{
    Optional<FullTimeEmployee> findByEmail(String email);
}
