package co.zw.company.employeemanager.parttimeemployee.repository;

import co.zw.company.employeemanager.parttimeemployee.model.PartTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartTimeEmployeeRepository extends JpaRepository<PartTimeEmployee,Long> {

    List<PartTimeEmployee> findAll();

    Optional<PartTimeEmployee> findPartTimeEmployeeById(Long id);

//    @Lock(LockModeType.OPTIMISTIC)
    PartTimeEmployee save(PartTimeEmployee partTimeEmployee);

    void deleteById(Long id);


    //void updatePartTimeEmployeeById(Long id);
}
