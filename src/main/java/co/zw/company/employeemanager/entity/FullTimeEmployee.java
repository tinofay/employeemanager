package co.zw.company.employeemanager.entity;

import co.zw.company.employeemanager.commons.BaseEmployee;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class FullTimeEmployee extends BaseEmployee {
    private Double salary;
    private String benefits;
}
