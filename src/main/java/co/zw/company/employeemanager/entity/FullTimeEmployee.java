package co.zw.company.employeemanager.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class FullTimeEmployee extends BaseEmployee {
    private Double salary;
    private String benefits;
}
