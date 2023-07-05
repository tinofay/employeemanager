package co.zw.company.employeemanager;

import co.zw.company.employeemanager.entity.Project;
import co.zw.company.employeemanager.repository.ProjectRepository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)

@DataJpaTest
public class ProjectTests {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TestEntityManager testEntityManager;
    private Project project;


    @Test
    public void givenProject_whenSave_ShouldSaveProject() {
       Project project =  new Project();
        project.setName("Chaka Chaya");
        project.setDescription("description");

        testEntityManager.persist(project);
        testEntityManager.flush();

        var savedProject = projectRepository.save(project);
        projectRepository.getById(savedProject.getId());

        assertNotNull(savedProject);

    }

    @Test
    public void givenId_whenGetProjectById_shouldReturnProjectTest() throws Exception{

        Project project =  new Project();
        project.setName("Chaka Chaya");
        project.setDescription("description");
        testEntityManager.persist(project);
        testEntityManager.flush();

        projectRepository.findById(project.getId());

        Assertions.assertThat(project.getId()).isEqualTo(1L).isNotNull();

    }

    @Test
    public void getListOfProjectTest() {

        Project project =  new Project ();
        project.setName("Chaka Chaya");
        project.setDescription("description");
        testEntityManager.persist(project);
        testEntityManager.flush();
        List<Project> projectS = projectRepository.findAll();
        Assertions.assertThat(projectS.size()).isGreaterThan(0);
    }

    @Test
    public void updateProjectTest(){
        Project project =  new Project ();
        project.setName("Chaka Chaya");
        project.setDescription("description");
        testEntityManager.persist(project);
        testEntityManager.flush();
        Project projectUpdated =  projectRepository.findById(1L).get();
        projectUpdated.setName("Vaya Technologies");
        projectRepository.save(project);
        Assertions.assertThat(project.getName()).isEqualTo("Vaya Technologies");
    }
}
