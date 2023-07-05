package co.zw.company.employeemanager.entity;

import co.zw.company.employeemanager.commons.BaseEmployee;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
public class Contractor extends BaseEmployee {
    private LocalDate contractStartDate, contractEndDate;

    }
