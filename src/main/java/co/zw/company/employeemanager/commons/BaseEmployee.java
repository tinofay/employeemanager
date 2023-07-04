package co.zw.company.employeemanager.commons;

import co.zw.company.employeemanager.entity.Department;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name ="name", nullable = true)
    private String name;
    @Column(name ="email", nullable = true)
    private String email;
    @ManyToOne
    private Department department;
    @Version
    private Long version;
}
