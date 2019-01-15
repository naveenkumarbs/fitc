package com.bsn.fitc.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsn.fitc.dao.impl.LoginDaoImpl;
import com.bsn.fitc.interfaces.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDaoImpl loginDao;
	
	@Override
	public boolean validateUser(HttpServletRequest request) {
		List<String> persons = loginDao.getPersons();
		return persons.isEmpty();
	}

	@Override
	public String getUserRole(String user) throws SQLException{
		return loginDao.getUserRole(user);
	}

	@Override
	public boolean userLogin(HttpServletRequest request) throws SQLException {
		String params[] = {request.getParameter("userName"),request.getParameter("password")};
		
		return loginDao.userLogin(params);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getUserValidated(HttpServletRequest request) {
		return loginDao.getUserValidated(request.getParameter("userName"));
	}

}
