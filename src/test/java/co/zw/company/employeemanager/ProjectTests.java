package co.zw.company.employeemanager;

import co.zw.company.employeemanager.entity.Department;
import co.zw.company.employeemanager.entity.FullTimeEmployee;
import co.zw.company.employeemanager.entity.Project;
import co.zw.company.employeemanager.repository.DepartmentRepository;
import co.zw.company.employeemanager.repository.ProjectRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjectTests {

    @Autowired
    private ProjectRepository projectRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveProject() {

        Project project =  new Project ();
        project.setName("Chaka Chaya");
        project.setDescription("description");
        Project savedProject = projectRepository.save(project);
        assertNotNull(savedProject);
    }

    @Test
    @Order(2)
    public void getProject() {
        Project project =  new Project ();
        project.setName("Chaka Chaya");
        project.setDescription("description");
        projectRepository.save(project);
        projectRepository.findById(1L).get();
        Project findProject = projectRepository.findById(1L).get();
        Assertions.assertThat(findProject.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfProjects() {
        Project project =  new Project ();
        project.setName("Chaka Chayaa");
        project.setDescription("description");
        projectRepository.save(project);
        List<Project> projectS = projectRepository.findAll();
        Assertions.assertThat(projectS.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateProject(){
        Project project =  new Project ();
        project.setName("Chaka Chaya");
        project.setDescription("description");
        projectRepository.save(project);
        Project projectUpdated =  projectRepository.findById(1L).get();
        projectUpdated.setName("Vaya Technologies");
        Project projectTwo = projectRepository.save(projectUpdated);
        Assertions.assertThat(projectTwo.getName()).isEqualTo("Vaya Technologies");
    }
}
