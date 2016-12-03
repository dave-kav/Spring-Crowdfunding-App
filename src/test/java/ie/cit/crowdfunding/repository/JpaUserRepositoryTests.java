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
import ie.cit.crowdfunding.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrowdfundingApplication.class)
@ActiveProfiles("test")
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class JpaUserRepositoryTests {

	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void getUser() {
		User u = userRepository.findOne(1);
		assertEquals("Dave Kavanagh", u.getFullName());
	}
	
	@Test
	public void getAllUsers() {
		ArrayList<User> users = (ArrayList<User>) userRepository.findAll();
		assertEquals(3, users.size());
	}
}
