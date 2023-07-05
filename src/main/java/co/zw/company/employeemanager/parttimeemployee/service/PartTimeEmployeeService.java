package co.zw.company.employeemanager.parttimeemployee.service;

import co.zw.company.employeemanager.parttimeemployee.model.PartTimeEmployee;

import java.util.Optional;

public interface PartTimeEmployeeService {

    PartTimeEmployee savePartTimeEmployee(PartTimeEmployee partTimeEmployee);
    Optional<PartTimeEmployee> findPartTimeEmployeeById(Long id);
}
