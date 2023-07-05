package co.zw.company.employeemanager.department.service;

import co.zw.company.employeemanager.department.model.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    Department updateDepartment(Long id, Department departmentDetails);

    void deleteDepartment(Long id);
}
