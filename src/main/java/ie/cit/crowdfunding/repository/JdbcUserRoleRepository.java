package ie.cit.crowdfunding.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import ie.cit.crowdfunding.entity.User;
import ie.cit.crowdfunding.rowmapper.UserRowMapper;

public class JdbcUserRoleRepository implements JdbcUserRoleDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcUserRoleRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
		
	@Override
	public List<User> getUserRole() {
		String sql = "SELECT * FROM user_roles";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
}
