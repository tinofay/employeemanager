package co.zw.company.employeemanager.repository;

import co.zw.company.employeemanager.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAll();

    Department findById(long id);

    Department findByName(String name);
    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Department save(Department department);

    void deleteById(long id);
}
