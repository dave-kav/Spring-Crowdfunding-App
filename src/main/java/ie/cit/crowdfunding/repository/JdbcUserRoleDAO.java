package ie.cit.crowdfunding.repository;

import java.util.List;

import ie.cit.crowdfunding.entity.User;

public interface JdbcUserRoleDAO {
	
	List<User> getUserRole();

}
