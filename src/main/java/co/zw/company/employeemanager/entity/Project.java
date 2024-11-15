package co.zw.company.employeemanager.entity;
import co.zw.company.employeemanager.department.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Department department;
//    @ManyToMany(mappedBy = "projects")
//    private List<BaseEmployee> employees;
}
