package ie.cit.crowdfunding.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * @author Dave Kavanagh	
 * @author Thomas O'Halloran
 * @author Darren Smith
 *
 */
@Entity
@Table(name="projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String image;
	private float goalAmt;
	/**
	 * int value representing number of days remaining,
	 * easier than messing around with dates  
	 */
	private int timeLimit; 

	@ManyToMany(mappedBy="projects")
	private List<User> users;
	@ManyToMany(mappedBy="projects")
	private List<Pledge> pledges;
	
	public int getProjectId() {
		return id;
	}

	public void setProjectId(int projectId) {
		this.id = projectId;
	}

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
		return image;
	}
	
	public void setImgUrl(String imgUrl) {
		this.image = imgUrl;
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
	
	@Override
	public String toString() {
		String out = "project [id=" + id + ", name=" + name + ", description=" + description
				+ ", goal amount=" + goalAmt + "]";
		return out;
	}

}
