package com.bsn.fitc.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsn.fitc.dao.impl.UserDaoImpl;
import com.bsn.fitc.dto.UserDTO;
import com.bsn.fitc.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDaoImpl userDao;
	
	@Override
	public UserDTO getUserDetails(String username) throws SQLException{
		
		return userDao.getUserDetails(username);
	}

	@Override
	public String updateProfile(HttpServletRequest request) throws SQLException {
		return userDao.updateProfile(request);
	}
}
