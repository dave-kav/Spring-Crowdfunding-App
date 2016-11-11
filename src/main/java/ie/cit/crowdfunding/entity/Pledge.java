package ie.cit.crowdfunding.entity;

/**
 * 
 * @author Dave Kavanagh	
 * @author Thomas O'Halloran
 * @author Darren Smith
 *
 */
public class Pledge {
	
	private float amount;
	/**
	 * is it beneficial for pledge to know which project it 
	 * belongs to or is it sufficient for each project 
	 * to know its own pledges?
	 */
	private Project project;
	/**
	 * user can cancel a pledge, but not after a project's
	 * time limit has expired 
	 */
	private boolean canBeCancelled;
	
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public boolean isCanBeCancelled() {
		return canBeCancelled;
	}

	public void setCanBeCancelled(boolean canBeCancelled) {
		this.canBeCancelled = canBeCancelled;
	}

	public String toString() {
		String out = "";
		return out;
	}
}
