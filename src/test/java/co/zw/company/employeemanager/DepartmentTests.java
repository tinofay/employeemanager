package co.zw.company.employeemanager;
import co.zw.company.employeemanager.entity.Department;
import co.zw.company.employeemanager.repository.DepartmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.assertj.core.api.Assertions;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OptimisticLockException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DepartmentTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testSaveDepartment() {
        Department department = new Department();
        department.setName("Engineering");
        department.setDescription("Develops software products");
        entityManager.persist(department);
        entityManager.flush();
        Department found = departmentRepository.findById(department.getId()).orElse(null);
        assert found != null;
        Assertions.assertThat(found.getName()).isEqualTo(department.getName());
    }

    @Transactional
    @Test
    public void testUpdateDepartmentWithVersion() {
        //create department
        Department department = new Department();
        department.setName("Software Engineering");
        department = departmentRepository.save(department);

        // Simulate a concurrent update to the same entity
        Department concurrentDepartment = new Department();
        concurrentDepartment.setId(department.getId());
        concurrentDepartment.setName("Software Engineering Department");
        concurrentDepartment.setVersion(department.getVersion());
        departmentRepository.save(concurrentDepartment);

        // Call the service method to update the department entity
        department.setName("Artificial Intelligence");

        // Assert that the service method throws an OptimisticLockException
        Department finalDepartment = department;
        assertThrows(OptimisticLockException.class, () -> {
            departmentRepository.save(finalDepartment);
        });
        
    }

    @Test
    public void testFindAllDepartments() {
        Department department1 = new Department();
        department1.setName("Engineering");
        department1.setDescription("Develops software products");
        entityManager.persist(department1);
        Department department2 = new Department();
        department2.setName("Marketing");
        department2.setDescription("Promotes software products");
        entityManager.persist(department2);
        List<Department> departments = departmentRepository.findAll();
        assertEquals(2, departments.size());
    }

    @Test
    public void testFindDepartmentByName() {
        Department department = new Department();
        department.setName("Engineering");
        department.setDescription("Develops software products");
        entityManager.persist(department);
        Department foundDepartment = departmentRepository.findByName("Engineering");
        assertEquals(department.getId(), foundDepartment.getId());
        assertEquals("Engineering", foundDepartment.getName());
        assertEquals("Develops software products", foundDepartment.getDescription());
    }

    @Test
    public void testUpdateDepartment() {
        Department department = new Department();
        department.setName("Engineering");
        department.setDescription("Develops software products");
        entityManager.persistAndFlush(department);
        department.setName("Research and Development");
        department.setDescription("Develops innovative products");
        Department updatedDepartment = departmentRepository.save(department);
        assertEquals("Research and Development", updatedDepartment.getName());
        assertEquals("Develops innovative products", updatedDepartment.getDescription());
    }

    @Test
    public void testDeleteDepartment() {
        Department department = new Department();
        department.setName("Engineering");
        department.setDescription("Develops software products");
        entityManager.persistAndFlush(department);
        departmentRepository.deleteById(department.getId());
        assertNull(entityManager.find(Department.class, department.getId()));
    }




}
