package co.zw.company.employeemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartTimeEmployee extends BaseEmployee{
    private double hourlyRate;
    private double contractedHours;
@Builder
    public PartTimeEmployee(Long id, String name, String email, double hourlyRate, double contractedHours) {
        super(id, name, email);
        this.hourlyRate = hourlyRate;
        this.contractedHours = contractedHours;
    }
}
