package ie.cit.crowdfunding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value={"/", "/login"}, method=RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value={"/home"}, method=RequestMethod.GET)
	public String home(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("user_list", users);
		return "home";
	}
	
	@RequestMapping(value={"/adminDashboard"}, method=RequestMethod.GET)
	public String adminDashboard() {
		
		return "adminDashboard";
	}
	
	@RequestMapping(value={"/userDashboard"}, method=RequestMethod.GET)
	public String userDashboard() {
		
		return "userDashboard";
	}
	
	@RequestMapping(value={"/addProject"}, method=RequestMethod.GET)
	public String addProject() {
		
		return "addProject";
	}

}
