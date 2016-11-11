package ie.cit.crowdfunding.entity;

import java.util.ArrayList;

/**
 * 
 * @author Dave Kavanagh	
 * @author Thomas O'Halloran
 * @author Darren Smith
 *
 */
public class User {
	
	private int userid; 
	private String fullName;
	private String userName;
	private String password;
	private float creditLimit;
	// list of projects that the user owns
	private ArrayList<Project> projects;
	// list of pledges made by the user
	private ArrayList<Pledge> pledges;
		
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public float getCreditLimit() {
		return creditLimit;
	}
	
	public void setCreditLimit(float creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public ArrayList<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	
	public ArrayList<Pledge> getPledges() {
		return pledges;
	}
	
	public void setPledges(ArrayList<Pledge> pledges) {
		this.pledges = pledges;
	}
	
	@Override
	public String toString() {
		String out = "";
		//implement
		return out;
	}
}
