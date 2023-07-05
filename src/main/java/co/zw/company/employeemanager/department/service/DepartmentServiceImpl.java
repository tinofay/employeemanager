package co.zw.company.employeemanager.department.service;

import co.zw.company.employeemanager.department.exception.DepartmentException;
import co.zw.company.employeemanager.department.model.Department;
import co.zw.company.employeemanager.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);

        return optionalDepartment.orElseGet(() -> {
            Department notFoundDepartment = new Department();
            notFoundDepartment.setName("Department Not Found");
            return notFoundDepartment;
        });
    }

    @Override
    public Department updateDepartment(Long id, Department departmentDetails) {
        Department department = getDepartmentById(id);
        department.setName(departmentDetails.getName());
        department.setDescription(departmentDetails.getDescription());
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
