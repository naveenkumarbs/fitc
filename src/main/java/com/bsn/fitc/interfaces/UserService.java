package com.bsn.fitc.interfaces;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bsn.fitc.dto.UserDTO;

public interface UserService {

	public UserDTO getUserDetails(String username) throws SQLException;
	public String updateProfile(HttpServletRequest request) throws SQLException;

}
