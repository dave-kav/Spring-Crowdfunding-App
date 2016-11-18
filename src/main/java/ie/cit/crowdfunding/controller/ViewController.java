package ie.cit.crowdfunding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.crowdfunding.entity.Pledge;
import ie.cit.crowdfunding.entity.Project;
import ie.cit.crowdfunding.entity.User;
import ie.cit.crowdfunding.repository.PledgeRepository;
import ie.cit.crowdfunding.repository.ProjectRepository;
import ie.cit.crowdfunding.repository.UserRepository;

@Controller
public class ViewController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PledgeRepository pledgeRepository;
	@Autowired
	ProjectRepository projectRepository;
	
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
		Iterable<Project> projects = projectRepository.findAll();
		model.addAttribute("project_list", projects);
		return "projects";
	}
	
	@RequestMapping(value={"/projects/{projectid}"}, method=RequestMethod.GET)
	public String showProject(Model model, @PathVariable(value="projectid") int id) {
		Project p = projectRepository.findOne(id);
		model.addAttribute("project", p);
		return "show";
	}
	
	@RequestMapping(value={"/projects/{projectid}"}, method=RequestMethod.POST)
	public String updateProject(Model model, Project project, @PathVariable(value="projectid") int id) {
		//TODO get description and update & save
		Project p = projectRepository.findOne(id);
		p.setDescription(project.getDescription());
		projectRepository.save(p);
		model.addAttribute("project", p);
		return "show";
	}
	
	@RequestMapping(value={"/projects/{projectid}/edit"}, method=RequestMethod.GET)
	public String editProject(Model model, @PathVariable(value="projectid") int id) {
		Project p = projectRepository.findOne(id);
		//TODO get description and update & save
		model.addAttribute("project", p);
		return "editProject";
	}
	
	@RequestMapping(value={"/projects"}, method=RequestMethod.POST)
	public String addProject(Model model, Project project) {
		//TODO insert user dynamically depending on logged in
		project.setUser(userRepository.getOne(1));
		projectRepository.save(project);

		//add all projects to model
		Iterable<Project> projects = projectRepository.findAll();
		model.addAttribute("project_list", projects);
		return "projects";
	}
	
	@RequestMapping(value={"/adminDashboard"}, method=RequestMethod.GET)
	public String adminDashboard() {
		
		return "adminDashboard";
	}
	
	@RequestMapping(value={"/users/{userid}"}, method=RequestMethod.GET)
	public String userDashboard(Model model, @PathVariable(value="userid") int id) {
		User u = userRepository.findOne(id);
		model.addAttribute("user", u);
		return "userDashboard";
	}
	
	@RequestMapping(value={"/projects/new"}, method=RequestMethod.GET)
	public String newProject(Model model) {
		model.addAttribute("project", new Project());
		return "addProject";
	}
	
	@RequestMapping(value={"/projects/{projectid}/pledges/new"}, method=RequestMethod.GET)
	public String newPledge(Model model, @PathVariable(value="projectid") int id) {
		Project p = projectRepository.findOne(id);
		model.addAttribute("project", p);
		model.addAttribute("pledge", new Pledge());
		return "addPledge";
	}
	
	@RequestMapping(value={"/projects/{projectid}/pledges/"}, method=RequestMethod.POST)
	public String savePledge(Model model, @PathVariable(value="projectid") int id, Pledge pledge) {
		Project p = projectRepository.findOne(id);
		
		pledge.setPermanent(false);
		//TODO insert user dynamically depending on logged in
		pledge.setUser(userRepository.getOne(1));
		pledge.setProject(p);
		pledgeRepository.save(pledge);
		
		p.getPledges().add(pledge);
		projectRepository.save(p);
		
		model.addAttribute("project", p);
		return "show";
	}
}
