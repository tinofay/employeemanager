package co.zw.company.employeemanager;

import co.zw.company.employeemanager.entity.Department;
import co.zw.company.employeemanager.entity.Project;
import co.zw.company.employeemanager.repository.DepartmentRepository;
import co.zw.company.employeemanager.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ProjectTests {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    private Department department;

    @Test
    @Rollback(value = false)
    public void saveProject() {

        Project project =  new Project ();
        project.setName("Chaka Chaya");
        project.setDescription("description");
        Project savedProject = projectRepository.save(project);
        assertNotNull(savedProject);

    }

    @Test
    public void getProjectTest() {

        Project project =  new Project ();
        project.setName("Chaka Chaya");
        project.setDescription("description");
        projectRepository.save(project);
        projectRepository.findById(1L).get();
        Assertions.assertThat(project.getId()).isEqualTo(1L);
    }

    @Test
    public void getListOfProjectTest() {

        Project project =  new Project ();
        project.setName("Chaka Chaya");
        project.setDescription("description");
        projectRepository.save(project);
        List<Project> projectS = projectRepository.findAll();
        Assertions.assertThat(projectS.size()).isGreaterThan(0);
    }

    @Test
    @Rollback(value = false)
    public void updateProjectTest(){
        Project project =  new Project ();
        project.setName("Chaka Chaya");
        project.setDescription("description");
        projectRepository.save(project);
        Project projectUpdated =  projectRepository.findById(1L).get();
        projectUpdated.setName("Vaya Technologies");
        projectRepository.save(project);
        Assertions.assertThat(project.getName()).isEqualTo("Vaya Technologies");
    }
}
