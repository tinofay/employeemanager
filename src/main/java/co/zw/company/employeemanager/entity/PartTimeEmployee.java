package co.zw.company.employeemanager.entity;

import lombok.AllArgsConstructor;
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
}
