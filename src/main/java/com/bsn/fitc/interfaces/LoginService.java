package com.bsn.fitc.interfaces;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
	public boolean validateUser(HttpServletRequest request);
	public String getUserRole(String user) throws SQLException;
	public boolean userLogin(HttpServletRequest request) throws SQLException;
	public List<String> getUserValidated(HttpServletRequest request);
	
}
