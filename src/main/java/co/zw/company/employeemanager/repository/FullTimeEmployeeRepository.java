package co.zw.company.employeemanager.repository;

import co.zw.company.employeemanager.entity.FullTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullTimeEmployeeRepository extends JpaRepository<FullTimeEmployee, Long>{
    FullTimeEmployee save (FullTimeEmployee fullTimeEmployee);
}
