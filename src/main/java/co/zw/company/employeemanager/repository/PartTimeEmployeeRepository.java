package co.zw.company.employeemanager.repository;

import co.zw.company.employeemanager.entity.PartTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartTimeEmployeeRepository extends JpaRepository<PartTimeEmployee,Long> {
}
