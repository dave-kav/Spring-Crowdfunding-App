package ie.cit.crowdfunding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.cit.crowdfunding.entity.Pledge;

public interface PledgeRepository extends JpaRepository<Pledge, Integer>{

}
