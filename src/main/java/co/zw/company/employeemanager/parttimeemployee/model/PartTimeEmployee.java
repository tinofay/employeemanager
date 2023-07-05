package co.zw.company.employeemanager.parttimeemployee.model;

import co.zw.company.employeemanager.commons.BaseEmployee;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="part_time_employee")
public class PartTimeEmployee extends BaseEmployee {

    @Column(name = "hourly_rate")
    private double hourlyRate;
    @Column(name="contracted_hours")
    private double contractedHours;

}
