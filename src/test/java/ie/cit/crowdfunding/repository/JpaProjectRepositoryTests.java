package ie.cit.crowdfunding.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ie.cit.crowdfunding.CrowdfundingApplication;
import ie.cit.crowdfunding.entity.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrowdfundingApplication.class)
@ActiveProfiles("test")
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class JpaProjectRepositoryTests {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Test
	public void getProject() {
		Project p = projectRepository.findOne(1);
		assertEquals("Trickstick",p.getName());
	}
	
	@Test
	public void getAllProjects() {
		ArrayList<Project> projects = (ArrayList<Project>) projectRepository.findAll();
		assertEquals(4, projects.size());
	}
	
	@Test
	public void addProject() {
		Project p = new Project();
		p.setId(66);
		p.setActive(true);
		p.setDescription("sadfdasfsaf sadfda fdsaf asdgds gdsag sdgd agsag");
		p.setGoalAmt(5000);
		p.setName("Dummy Project");
		p.setImage("");
		p.setTimeLimit(20);
		projectRepository.save(p);
		
		ArrayList<Project> projects = (ArrayList<Project>) projectRepository.findAll();
		assertEquals(5, projects.size());
	}
	
	@Test
	public void updateProject() {
		Project p = projectRepository.findOne(1);
		p.setName("Dummy Name");
		projectRepository.save(p);
		
		Project p1 = projectRepository.findOne(1);
		assertEquals("Dummy Name", p1.getName());	
	}

}
