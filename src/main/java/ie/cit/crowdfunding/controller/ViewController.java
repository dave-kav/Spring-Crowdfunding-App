package ie.cit.crowdfunding.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ie.cit.crowdfunding.entity.Pledge;
import ie.cit.crowdfunding.entity.Project;
import ie.cit.crowdfunding.entity.User;
import ie.cit.crowdfunding.repository.PledgeRepository;
import ie.cit.crowdfunding.repository.ProjectRepository;
import ie.cit.crowdfunding.repository.UserRepository;
import ie.cit.crowdfunding.service.UpdateService;

@Controller
public class ViewController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PledgeRepository pledgeRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	UpdateService updateService;
	
	public int errors1 = 0;
	public int errors2 = 0;
	
	@RequestMapping(value={"/login"}, method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
	public String landing() {
		return "landing";
	}
	
	@RequestMapping(value={"/projects"}, method=RequestMethod.GET)
	public String projects(Model model) {
		this.setPledgeErrorCount(0);
		this.setProjectErrorCount(0);
		Iterable<Project> projects = projectRepository.findAll();
		model.addAttribute("project_list", projects);
		return "projects";
	}
	
	@RequestMapping(value={"/projects/{projectid}"}, method=RequestMethod.GET)
	public String showProject(Model model, @PathVariable(value="projectid") int id) {
		Project p = projectRepository.findOne(id);
		System.out.println(p.getPledges().toString());
		
		model.addAttribute("project", p);
		return "show";
	}
	
	@RequestMapping(value={"/projects/{projectid}"}, method=RequestMethod.POST)
	public String updateProject(Model model, Project project, @PathVariable(value="projectid") int id) {
		//TODO get description and update & save
		Project p = projectRepository.findOne(id);
		p.setDescription(project.getDescription());
		p = projectRepository.save(p);
		model.addAttribute("project", p);
		return "show";
	}
	
	@RequestMapping(value={"/projects/{projectid}/edit"}, method=RequestMethod.GET)
	public String editProject(Model model, @PathVariable(value="projectid") int id) {
		Project p = projectRepository.findOne(id);
		model.addAttribute("project", p);
		return "editProject";
	}
	
	@RequestMapping(value={"/projects"}, method=RequestMethod.POST)
	public String addProject(@Valid Project project, BindingResult bindingResult, Model model ) {
		
		//if error in form redirect
		if (bindingResult.hasErrors()) {
			this.setProjectErrorCount(bindingResult.getErrorCount());
			return "redirect:/projects/new";
        }
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		User u = userRepository.findByIdUsername(name);
		
		project.setUser(u);
		project.setActive(true);
		project = projectRepository.save(project);
		
		userRepository.addProjectToUser(u.getId(), project.getId());

		//add all projects to model
		Iterable<Project> projects = projectRepository.findAll();
		model.addAttribute("project_list", projects);
		this.setProjectErrorCount(0);
		return "projects";
	}
	
	@RequestMapping(value={"/adminDashboard"}, method=RequestMethod.GET)
	public String adminDashboard(Model model) {
		this.setPledgeErrorCount(0);
		this.setProjectErrorCount(0);
		updateService.updateProjects();
		
		Iterable<Project> projects = projectRepository.findAll();
		model.addAttribute("project_list", projects);
		return "projects";
	}
	
	@RequestMapping(value={"/userDashboard"}, method=RequestMethod.GET)
	public String userDashboard(Model model) {
		this.setPledgeErrorCount(0);
		this.setProjectErrorCount(0);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		User u = userRepository.findByIdUsername(name);
		model.addAttribute("user", u);
		return "userDashboard";
	}
	
	@RequestMapping(value={"/projects/{projectid}/pledges/{pledgeid}"}, method=RequestMethod.GET)
	public String deletePledge(Model model, @PathVariable(value="pledgeid") int pledgeId, 
											@PathVariable(value="projectid") int projectId) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		User u = userRepository.findByIdUsername(name);
		
		pledgeRepository.delete(pledgeRepository.findOne(pledgeId));
		userRepository.deletePledgeFromUser(u.getId(), pledgeId);
		projectRepository.deletePledgeFromProject(projectId, pledgeId);
		
		userRepository.save(u);
		
		Iterable<Project> projects = projectRepository.findAll();
		model.addAttribute("project_list", projects);
		return "projects";
		
	}
	
	@RequestMapping(value={"/projects/new"}, method=RequestMethod.GET)
	public String newProject(Model model) {
		model.addAttribute("project", new Project());
		model.addAttribute("error", this.getProjectErrorCount());
		
		return "addProject";
	}
	
	@RequestMapping(value={"/projects/{projectid}/pledges/new"}, method=RequestMethod.GET)
	public String newPledge(Model model, @PathVariable(value="projectid") int id) {	
		Project p = projectRepository.findOne(id);
		model.addAttribute("project", p);
		model.addAttribute("pledge", new Pledge());
		model.addAttribute("error", this.getPledgeErrorCount());
		
		return "addPledge";
	}
	
	@RequestMapping(value={"/projects/{projectid}/pledges/"}, method=RequestMethod.POST)
	public String savePledge(Model model, @PathVariable(value="projectid") int id, 
								@Valid Pledge pledge, BindingResult bindingResult) {
		
		//if error in form redirect
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			this.setPledgeErrorCount(1);
			return "redirect:/projects/{projectid}/pledges/new/";
        }	
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName();
		User u = userRepository.findByIdUsername(name);
		
		if ((u.getPledgeTotal() + pledge.getAmount()) >= u.getCreditLimit())
		{
			ObjectError error = new ObjectError("creditLow","Not enough credit");
			bindingResult.addError(error);
			this.setPledgeErrorCount(2);
			return "redirect:/projects/{projectid}/pledges/new/";
		}
	
		Project p = projectRepository.findOne(id);
		pledge.setPermanent(false);
		pledge.setUser(userRepository.findOne(u.getId()));
		pledge.setProject(p);
		pledge = pledgeRepository.save(pledge);
		
		userRepository.addPledgeToUser(u.getId(), pledge.getId());
		projectRepository.addPledgeToProject(p.getId(), pledge.getId());
		p = projectRepository.save(p);
		p.getPledges().add(pledge); //for initial display only
		model.addAttribute("project", p);
		this.setPledgeErrorCount(0);
		return "show";
	}
	
	public void setProjectErrorCount(int num) {
		errors1 = num;
	}
	
	public int getProjectErrorCount() {
		return errors1;
	}
	
	public void setPledgeErrorCount(int num) {
		errors2 = num;
	}
	
	public int getPledgeErrorCount() {
		return errors2;
	}
	
}
