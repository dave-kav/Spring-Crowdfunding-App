package ie.cit.crowdfunding.repository;

import org.springframework.data.repository.CrudRepository;

import ie.cit.crowdfunding.entity.Pledge;

public interface PledgeRepository extends CrudRepository<Pledge, Integer>{

}
