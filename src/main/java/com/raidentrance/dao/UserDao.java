/**
 * 
 */
package com.raidentrance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.raidentrance.model.ServiceException;
import com.raidentrance.model.User;

/**
 * @author raidentrance
 *
 */
@Component
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<User> findAll() {
		List<User> users = jdbcTemplate.query("select * from user", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User(rs.getInt("USER_ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"));
				return user;
			}
		});
		return users;
	}

	public User findByUsername(String username) throws ServiceException {
		User user = jdbcTemplate.query(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement("select * from user where username=?");
				ps.setString(1, username);
				return ps;
			}
		}, new ResultSetExtractor<User>() {
			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					User user = new User(rs.getInt("USER_ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"));
					return user;
				} else {
					return null;
				}
			}
		});
		if (user != null) {
			return user;
		} else {
			throw new ServiceException(Status.NOT_FOUND.getStatusCode(), "User not found ", 4004);
		}
	}
}
