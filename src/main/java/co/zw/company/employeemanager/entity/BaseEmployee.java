package co.zw.company.employeemanager.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;



    @ManyToOne
    @JoinColumn(name = "department_name")
    private Department department;

    public BaseEmployee(Long id, String name, String email) {
    }
}
