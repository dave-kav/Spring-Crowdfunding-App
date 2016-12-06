package ie.cit.crowdfunding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ie.cit.crowdfunding.entity.Pledge;

public interface PledgeRepository extends CrudRepository<Pledge, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM Pledges WHERE id = :p_id", nativeQuery = true)
	public void deletePledge(@Param("p_id") int pledge_id);
	
	@Query(value="Select * FROM Pledges", nativeQuery = true)
	public  List<Pledge> findAllPledges();

}
