package com.bsn.fitc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public class LoginDaoImpl {

	@Autowired
	public JdbcTemplate jdbcTemplate;

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
}
