package co.zw.company.employeemanager.repository;

import co.zw.company.employeemanager.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // create
    List<Department> findAll();

    Department findById(long id);

    Department findByName(String name);

    Department save(Department department);

    void deleteById(long id);
}
