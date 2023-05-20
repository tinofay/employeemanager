package co.zw.company.employeemanager.entity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Contractor extends BaseEmployee {
    private LocalDate contractStartDate, contractEndDate;
}
