package com.bsn.fitc.controller;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bsn.fitc.service.impl.FITCServices;
import com.bsn.fitc.service.impl.LoginServiceImpl;
import com.mysql.cj.util.StringUtils;
 
@Controller
@SessionAttributes({"userName","userrole"})

public class LoginController {
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	
	@Autowired
	private LoginServiceImpl loginService;
 
    @RequestMapping(value="login", method = RequestMethod.POST)
    public ModelAndView home(HttpServletRequest request) throws SQLException {
    	String username = request.getParameter("userName");
    	String password = request.getParameter("password");
    	ModelAndView mv = new ModelAndView("login/loginFailure");
    	if(!StringUtils.isNullOrEmpty(username) && !StringUtils.isNullOrEmpty(password)) {
    		if(loginService.userLogin(request)) {
    			mv = new ModelAndView("login/loginSuccess");
    			mv.addObject("userName", username);
        		String userrole = loginService.getUserRole(username);
        		mv.addObject("userrole",userrole);
        		logger.debug("userName:"+username+",userrole:"+userrole);
    		}
    		
    	}
    	
		return mv;
    }
    
    @RequestMapping("logout")
    public ModelAndView logout(SessionStatus status,HttpSession session) {
    	status.setComplete();
    	ModelAndView mv = new ModelAndView("index");
    	return mv;
    }
    
    @RequestMapping("validateUser")
    @ResponseBody
    public String validateUser(HttpServletRequest request) {
    	logger.info("Inside validateUser ");
    	List<String> result = loginService.getUserValidated(request);
    	logger.info("validateUser result "+result.toString());
    	return result.isEmpty()?"Valid":"Invalid";
    }
}