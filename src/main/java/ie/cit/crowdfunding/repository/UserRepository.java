package ie.cit.crowdfunding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.cit.crowdfunding.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
