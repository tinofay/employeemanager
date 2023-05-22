package co.zw.company.employeemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "name")
    private List<BaseEmployee> baseEmployee;
}
