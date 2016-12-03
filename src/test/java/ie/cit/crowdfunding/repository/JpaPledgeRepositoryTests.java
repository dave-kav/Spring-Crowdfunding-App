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
import ie.cit.crowdfunding.entity.Pledge;
import ie.cit.crowdfunding.entity.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrowdfundingApplication.class)
@ActiveProfiles("test")
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class JpaPledgeRepositoryTests {

	@Autowired
	PledgeRepository pledgeRepository;
	
	@Test
	public void getPledge() {
		Pledge p = pledgeRepository.findOne(1);
		assertNotNull(p);
	}
	
	@Test 
	public void getAllPledges() {
		ArrayList<Pledge> pledges = (ArrayList<Pledge>) pledgeRepository.findAll();
		assertEquals(7, pledges.size());
	}
	
	@Test
	public void addPledge() {
		Pledge p = new Pledge();
		p.setId(8);
		p.setAmount(750);
		p.setPermanent(false);
		pledgeRepository.save(p);
		
		Pledge p1 = pledgeRepository.findOne(8);
		assertNotNull(p1);
	}
	
	@Test
	public void updatePledge() {
		Pledge p = pledgeRepository.findOne(1);
		p.setAmount(7500);
		pledgeRepository.save(p);
		
		Pledge p1 = pledgeRepository.findOne(1);
		assertNotSame(p, p1);
	}
	
	@Test
	public void deletePledge() {
		//pledgeRepository.deletePledge(1);
		Iterable<Pledge> pledges =  pledgeRepository.findAll();
		int count = 0;
		for (Pledge pledge: pledges) {
			count++;
		}
		assertEquals(7, count);
	}
	
}
