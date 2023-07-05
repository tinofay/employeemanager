package co.zw.company.employeemanager.parttimeemployee.service;

import co.zw.company.employeemanager.parttimeemployee.model.PartTimeEmployee;
import co.zw.company.employeemanager.parttimeemployee.repository.PartTimeEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartTimeEmployeeServiceImpl implements PartTimeEmployeeService {

    private final PartTimeEmployeeRepository partTimeEmployeeRepository;
//    public PartTimeEmployeeServiceImpl(PartTimeEmployeeRepository partTimeEmployeeRepository) {
//        this.partTimeEmployeeRepository = partTimeEmployeeRepository;
//    }
    @Override
    public PartTimeEmployee savePartTimeEmployee(PartTimeEmployee partTimeEmployee) {
        final var partTimeEmployee1 = partTimeEmployeeRepository.save(partTimeEmployee);
        return partTimeEmployee1;
    }
}
