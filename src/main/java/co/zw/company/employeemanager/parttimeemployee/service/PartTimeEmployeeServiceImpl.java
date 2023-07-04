package co.zw.company.employeemanager.parttimeemployee.service;

import co.zw.company.employeemanager.parttimeemployee.model.PartTimeEmployee;
import co.zw.company.employeemanager.parttimeemployee.repository.PartTimeEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartTimeEmployeeServiceImpl implements PartTimeEmployeeService {

    private final PartTimeEmployeeRepository partTimeEmployeeRepository;

    public PartTimeEmployeeServiceImpl(PartTimeEmployeeRepository partTimeEmployeeRepository) {
        this.partTimeEmployeeRepository = partTimeEmployeeRepository;
    }
    @Override
    public PartTimeEmployee savePartTimeEmployee(PartTimeEmployee partTimeEmployee) {
        final var partTimeEmployee1 = partTimeEmployeeRepository.save(partTimeEmployee);
        return partTimeEmployee1;
    }

    @Override
    public Optional<PartTimeEmployee> findPartTimeEmployeeById(Long id) {
        final var partTimeEmployee = partTimeEmployeeRepository.findPartTimeEmployeeById(id);
        return Optional.of(partTimeEmployee).orElse(null);
    }
}
