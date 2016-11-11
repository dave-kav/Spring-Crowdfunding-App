package ie.cit.crowdfunding.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ie.cit.crowdfunding.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
