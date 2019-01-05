package com.bsn.fitc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bsn.fitc.interfaces.LoginService;

public class FITCServices {
	
	@Autowired
	private static LoginService loginService;
	
	public static LoginService getLoginService() {
		return loginService;
	}
}
