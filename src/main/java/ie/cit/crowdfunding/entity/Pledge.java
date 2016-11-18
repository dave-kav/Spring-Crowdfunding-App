package ie.cit.crowdfunding.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Dave Kavanagh	
 * @author Thomas O'Halloran
 * @author Darren Smith
 *
 */
@Entity
@Table(name="pledges")
public class Pledge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private float amount;
	/**
	 * user can cancel a pledge, but not after a project's
	 * time limit has expired 
	 */
	private boolean permanent;
	
	@ManyToMany(mappedBy="pledges", cascade = {CascadeType.ALL})
	private List<User> users;
	
	@ManyToMany(mappedBy="pledges", cascade = {CascadeType.ALL})
	private List<Project> projects; 
	
	public int getPledgeId() {
		return id;
	}

	public void setPledgeId(int pledgeId) {
		this.id = pledgeId;
	}
	
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public boolean isPermanet() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	
	public User getUser() {
		return users.get(0);
	}

	public void setUser(User user) {
		users.add(user);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public Project getProject() {
		return projects.get(0);
	}

	public void setProject(Project project) {
		projects.add(project);
	}

	public String toString() {
		String out = "pledge [id=" + id + ", amount=" + amount + ", permanent=" + permanent 
				+ "]";
		return out;
	}
}
