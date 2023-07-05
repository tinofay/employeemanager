package co.zw.company.employeemanager.parttimeemployee.controller;

import co.zw.company.employeemanager.commons.ApiResponse;
import co.zw.company.employeemanager.parttimeemployee.model.PartTimeEmployee;
import co.zw.company.employeemanager.parttimeemployee.service.PartTimeEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parttime")
public class PartTimeEmployeeController {

    private final PartTimeEmployeeService partTimeEmployeeService;

    public PartTimeEmployeeController(PartTimeEmployeeService partTimeEmployeeService) {
        this.partTimeEmployeeService = partTimeEmployeeService;
    }

    @PostMapping("/save")
    public PartTimeEmployee save(@RequestBody PartTimeEmployee partTimeEmployee) {
        final var savedPartTimeEmployee = partTimeEmployeeService.savePartTimeEmployee(partTimeEmployee);
        return savedPartTimeEmployee;
    }

}
