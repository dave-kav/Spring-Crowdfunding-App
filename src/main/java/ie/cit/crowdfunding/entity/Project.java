package ie.cit.crowdfunding.entity;

import java.util.ArrayList;

/**
 * 
 * @author Dave Kavanagh	
 * @author Thomas O'Halloran
 * @author Darren Smith
 *
 */
public class Project {
	
	private String name;
	private String description;
	private String imgUrl;
	private float goalAmt;
	/**
	 * int value representing number of days remaining,
	 * easier than messing around with dates  
	 */
	private int timeLimit; 
	private ArrayList<Pledge> pledges;
	/**
	 * project has reference to owner for easier implementation
	 * of user's ability to edit their own projects 
	 */
	private User projectOwner;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public float getGoalAmt() {
		return goalAmt;
	}
	
	public void setGoalAmt(float goalAmt) {
		this.goalAmt = goalAmt;
	}
	
	public int getTimeLimit() {
		return timeLimit;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public ArrayList<Pledge> getPledges() {
		return pledges;
	}
	
	public void setPledges(ArrayList<Pledge> pledges) {
		this.pledges = pledges;
	}
	
	public User getProjectOwner() {
		return projectOwner;
	}
	
	public void setProjectOwner(User projectOwner) {
		this.projectOwner = projectOwner;
	}
	
	@Override
	public String toString() {
		String out = "";
		return out;
	}

}
