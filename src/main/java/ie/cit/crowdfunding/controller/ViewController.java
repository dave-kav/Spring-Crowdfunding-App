package ie.cit.crowdfunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	@RequestMapping(value={"/", "/login"}, method=RequestMethod.GET)
	public String login() {
		
		return "login";
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
