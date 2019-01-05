package com.bsn.fitc.service.impl;

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
	public String getUserRole(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
