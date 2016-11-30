package ie.cit.crowdfunding.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ie.cit.crowdfunding.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO User_projects VALUES (:u_id, :p_id)", nativeQuery = true)
	public void addProjectToUser(@Param("u_id") int user_id, @Param("p_id") int project_id);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM User_projects WHERE user_id = :u_id AND project_id = :prj_id", nativeQuery = true)
	public void deleteProjectFromUser(@Param("u_id") int user_id, @Param("prj_id") int project_id);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO User_pledges VALUES (:u_id, :pld_id)", nativeQuery = true)
	public void addPledgeToUser(@Param("u_id") int user_id, @Param("pld_id") int pledge_id);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM User_pledges WHERE user_id = :u_id AND pledge_id = :pld_id", nativeQuery = true)
	public void deletePledgeFromUser(@Param("u_id") int user_id, @Param("pld_id") int pledge_id);
	
	@Query(value="Select * FROM Users WHERE username = :username", nativeQuery = true)
	public User findByIdUsername(@Param("username") String username);

}
