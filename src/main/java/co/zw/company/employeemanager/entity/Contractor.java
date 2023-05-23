package co.zw.company.employeemanager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Contractor extends BaseEmployee {
    private LocalDate start, end;

    }
