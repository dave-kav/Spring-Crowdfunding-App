package ie.cit.crowdfunding.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ie.cit.crowdfunding.entity.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserName(rs.getString("user_name"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		
		return user;
	}
}
