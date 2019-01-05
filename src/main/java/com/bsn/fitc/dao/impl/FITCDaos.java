package com.bsn.fitc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

public class FITCDaos {
	@Autowired
	private static LoginDaoImpl loginDaoImpl;
	
	public static LoginDaoImpl getLoginDaoImpl() {
		
		return loginDaoImpl;
	}
}
