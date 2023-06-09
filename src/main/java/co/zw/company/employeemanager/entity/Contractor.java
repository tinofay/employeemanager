package co.zw.company.employeemanager.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Data
public class Contractor extends BaseEmployee {
    private LocalDate contractStartDate, contractEndDate;

    }
