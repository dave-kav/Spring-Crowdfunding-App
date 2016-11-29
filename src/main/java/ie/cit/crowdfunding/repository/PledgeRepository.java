package ie.cit.crowdfunding.repository;

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
	public void deleteFromPledges(@Param("p_id") int pledge_id);

}
