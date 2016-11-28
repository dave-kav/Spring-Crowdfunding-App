package ie.cit.crowdfunding.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * 
 * @author Dave Kavanagh	
 * @author Thomas O'Halloran
 * @author Darren Smith
 *
 */
@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String fullName;
	@Column(name="username")
	private String userName;
	private String password;
	private float creditLimit;
	private boolean enabled;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	// list of projects that the user owns
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name="user_projects",
		joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="project_id", referencedColumnName="id")})
	public List<Project> projects;
	
	// list of pledges made by the user
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name="user_pledges",
		joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="pledge_id", referencedColumnName="id")})
	private List<Pledge> pledges;
	
	public User () {
		projects = new ArrayList<Project>();
		pledges = new ArrayList<Pledge>();
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void setPledges(List<Pledge> pledges) {
		this.pledges = pledges;
	}

	public int getUserid() {
		return id;
	}
	
	public void setUserid(int userid) {
		this.id = userid;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}
	
	public List<Pledge> getPledges() {
		return pledges;
	}
	
	public void setPledges(ArrayList<Pledge> pledges) {
		this.pledges = pledges;
	}
	
	public float getPledgeTotal() {
		float total = 0;
		for (Pledge p: pledges) {
			total += p.getAmount();
		}
		return total;
	}
	
	public int getNumProjects() {
		return projects.size();
	}
	
	public int getNumPledges() {
		return pledges.size();
	}
	
	@Override
	public String toString() {
		String out = "User [id=" + id + ", fullname=" + fullName + ", username=" + userName
				+ ", creditlimit=" + creditLimit + ", projects =[";
		for (Project p: projects) {
			out += p.toString() + ", ";
		}
		out += "], pledges=[";
		for (Pledge p: pledges) {
			out += p.toString() + ", ";
		}
		out += "]]";
		return out;
	}
}
