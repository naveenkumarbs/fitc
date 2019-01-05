package com.bsn.fitc.interfaces;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
	public boolean validateUser(HttpServletRequest request);
	public String getUserRole(String user);
	
}
