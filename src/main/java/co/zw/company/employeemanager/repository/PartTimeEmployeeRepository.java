package co.zw.company.employeemanager.repository;

import co.zw.company.employeemanager.entity.PartTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartTimeEmployeeRepository extends JpaRepository<PartTimeEmployee,Long> {

    List<PartTimeEmployee> findAll();

    Optional<PartTimeEmployee> findPartTimeEmployeeById(Long id);

    PartTimeEmployee save(PartTimeEmployee partTimeEmployee);

    PartTimeEmployee deletePartTimeEmployeeById(Long id);
}
