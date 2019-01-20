package com.bsn.fitc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bsn.fitc.dto.UserDTO;

@Configuration
@Repository
public class UserDaoImpl {
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

	public UserDTO getUserDetails(String username) throws SQLException{
		logger.debug("Inside getUserDetails: "+username);
		String SQL = "select * from users where username=?";
		
		return jdbcTemplate.queryForObject(SQL, new Object[] { username }, new RowMapper<UserDTO>() {

			@Override
			public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDTO user = new UserDTO();
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setId(rs.getString("id"));
				return user;
			}
		});
		
	}

	public String updateProfile(HttpServletRequest request) throws SQLException{
		String SQL = "update users set firstname=?, lastname=?,email=?,phone=?,address=? where id=?";
		
		List<String> params = new ArrayList<>();
		params.add(request.getParameter("firstname"));
		params.add(request.getParameter("lastname"));
		params.add(request.getParameter("email"));
		params.add(request.getParameter("phone"));
		params.add(request.getParameter("address"));
		params.add(request.getParameter("userId"));
		
		logger.debug("SQL:"+SQL);
		logger.debug("params:"+params);
		int result = jdbcTemplate.update(SQL,params.get(0),
				params.get(1),
				params.get(2),
				params.get(3),
				params.get(4),
				Integer.parseInt(params.get(5))
				);
		return result>0?"Success":"Failure";
	}
}
