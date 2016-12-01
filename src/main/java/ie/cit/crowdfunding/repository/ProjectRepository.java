package ie.cit.crowdfunding.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ie.cit.crowdfunding.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO Project_pledges VALUES (:prj_id, :pld_id)", nativeQuery = true)
	public void addPledgeToProject(@Param("prj_id") int project_id, @Param("pld_id") int pledge_id);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM Project_pledges WHERE project_id = :prj_id AND pledge_id = :pld_id", nativeQuery = true)
	public void deletePledgeFromProject(@Param("prj_id") int project_id, @Param("pld_id") int pledge_id);

	
}
