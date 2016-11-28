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

}
