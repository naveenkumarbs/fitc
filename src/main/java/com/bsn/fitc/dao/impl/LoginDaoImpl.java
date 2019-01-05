package com.bsn.fitc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
}
