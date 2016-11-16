package ie.cit.crowdfunding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value={"/", "/projects"}, method=RequestMethod.GET)
	public String projects(Model model) {
//		List<User> users = userRepository.findAll();
//		model.addAttribute("user_list", users);
		List<Project> projects = projectRepository.findAll();
		model.addAttribute("project_list", projects);
		return "projects";
	}
	
	@RequestMapping(value={"/projects/{id}"}, method=RequestMethod.GET)
	public String showProject(Model model, @PathVariable(value="id") int id) {
		Project p = projectRepository.findOne(id);
		model.addAttribute("project", p);
		return "show";
	}
	
	@RequestMapping(value={"/adminDashboard"}, method=RequestMethod.GET)
	public String adminDashboard() {
		
		return "adminDashboard";
	}
	
	@RequestMapping(value={"/users/{id}"}, method=RequestMethod.GET)
	public String userDashboard(Model model, @PathVariable(value="id") int id) {
		User u = userRepository.findOne(id);
		model.addAttribute("user", u);
		return "userDashboard";
	}
	
	@RequestMapping(value={"/addProject"}, method=RequestMethod.GET)
	public String addProject() {
		
		return "addProject";
	}

}
