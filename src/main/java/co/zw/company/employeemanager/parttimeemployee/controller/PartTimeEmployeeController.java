package co.zw.company.employeemanager.parttimeemployee.controller;

import co.zw.company.employeemanager.parttimeemployee.model.PartTimeEmployee;
import co.zw.company.employeemanager.parttimeemployee.service.PartTimeEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/get-parttimeemployee-by-id")
    public Optional<PartTimeEmployee> findPartTimeEmployeeById(Long id){
        final var getPartTimeEmployee = partTimeEmployeeService.findPartTimeEmployeeById(id);
        return getPartTimeEmployee;
    }

}
