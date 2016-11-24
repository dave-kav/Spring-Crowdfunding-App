package ie.cit.crowdfunding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.crowdfunding.entity.Pledge;
import ie.cit.crowdfunding.entity.Project;
import ie.cit.crowdfunding.repository.ProjectRepository;

@Service
public class ProjectUpdateService implements UpdateService {
	@Autowired
	ProjectRepository projectRepository;

	@Override
	public void updateProjects() {
		
		Iterable<Project> projects = projectRepository.findAll();
		
		for (Project project: projects) {
			
			int timeLimit = project.getTimeLimit();
			float totalPledged = project.getTotal();
			
			if (timeLimit > 0)
				project.setTimeLimit(timeLimit - 1);
			
			// if time to raise funds elapsed or goal met
			if (timeLimit == 0 ||totalPledged >= project.getGoalAmt()) {
				project.setActive(false);
				//get all pledges
				List<Pledge> pledges = project.getPledges();
				
				for (Pledge pledge: pledges) {
					pledge.setPermanent(true);
				}
			}
			projectRepository.save(project);
		}
	}
}
