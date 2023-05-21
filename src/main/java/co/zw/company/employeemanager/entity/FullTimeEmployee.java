package co.zw.company.employeemanager.entity;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends BaseEmployee {
    private Double salary;
    private String benefits;
}
