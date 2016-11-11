package ie.cit.crowdfunding.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Dave Kavanagh	
 * @author Thomas O'Halloran
 * @author Darren Smith
 *
 */
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	@Column(name="full_name")
	private String fullName;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="credit_limit")
	private float creditLimit;
	// list of projects that the user owns
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name="artist_movements",
		joinColumns={@JoinColumn(name="artist_id", referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="movement_id", referencedColumnName="id")})
	public List<Project> projects;
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
	
	public List<Project> getProjects() {
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
