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


@Configuration
@Repository
public class LoginDaoImpl {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LogManager.getLogger(LoginDaoImpl.class);

	public List<String> getPersons() {
		return jdbcTemplate.query("select * from Persons", new RowMapper() {

			@Override
			public List<String> mapRow(ResultSet rs, int rowNum) throws SQLException {
				List<String> persons = new ArrayList<String>();

				persons.add(rs.getString("firstname"));

				return persons;
			}

		});
	}

	public List<String> getUserValidated(String parameter) {
		List<String> result = jdbcTemplate.query("select * from users where username=?", new PreparedStatementSetter() {

			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, parameter);
			}
		}, new RowMapper() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("userName");
			}
		});

		return result;
	}

	public boolean userLogin(String[] parameter) throws SQLException  {
		String SQL = "select * from users u join userlogin ul on ul.userid=u.id where u.username=? and ul.password=?";
		List<String> result = jdbcTemplate.query(SQL, new PreparedStatementSetter() {

			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, parameter[0]);
				preparedStatement.setString(2, parameter[1]);
			}
		}, new RowMapper() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("userName");
			}
		});

		return !result.isEmpty();
	}

	public String getUserRole(String user)  throws SQLException{
		String SQL = "select ur.name as role from userroles ur " + 
				"join users_roles_map map on ur.id=map.roleid " + 
				"join users u on u.id=map.userid " + 
				"where u.username=?  ";
		List<String> result = jdbcTemplate.query(SQL, new PreparedStatementSetter() {

			public void setValues(PreparedStatement preparedStatement) throws SQLException {
				preparedStatement.setString(1, user);
			}
		}, new RowMapper() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("role");
			}
		});
		
		return result.get(0);
	}

	public String registerUser(HttpServletRequest request) throws SQLException {
		String SQL = "insert into users (firstname, lastname, username,email,phone,address) values"
				+ "(?,?,?,?,?,?)";
		
		List<String> params = new ArrayList<>();
		params.add(request.getParameter("firstname"));
		params.add(request.getParameter("lastname"));
		params.add(request.getParameter("username"));
		params.add(request.getParameter("email"));
		params.add(request.getParameter("phone"));
		params.add(request.getParameter("address"));
		
		logger.debug("SQL:"+SQL);
		logger.debug("params:"+params);
		jdbcTemplate.update(SQL,params.get(0),
				params.get(1),
				params.get(2),
				params.get(3),
				params.get(4),
				params.get(5)
				);
		
		//insert into users_roles_map
		String SQL1 = "insert into users_roles_map (userid,roleid) values ((select id from users where username=?),(select id from userroles where name=?))";
		List<String> params1 = new ArrayList<>();
		params1.add(request.getParameter("username"));
		params1.add(request.getParameter("role"));
		
		jdbcTemplate.update(SQL1,params1.get(0),params1.get(1));
		
		String SQL2 = "insert into userlogin (userid,password) values ((select id from users where username=?),?)";
		List<String> params2 = new ArrayList<>();
		params2.add(request.getParameter("username"));
		params2.add(request.getParameter("password"));
		
		jdbcTemplate.update(SQL2,params2.get(0),params2.get(1));
		
		return "Success";
	}
}
