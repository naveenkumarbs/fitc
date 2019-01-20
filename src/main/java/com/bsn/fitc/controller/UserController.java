package com.bsn.fitc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bsn.fitc.dto.UserDTO;
import com.bsn.fitc.service.impl.UserServiceImpl;

@Controller

public class UserController {
	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("editprofile")
    public ModelAndView editProfile(HttpServletRequest request) throws SQLException {
		logger.debug("Inside editProfile");
		UserDTO userdetails = userService.getUserDetails(request.getParameter("username"));
		
    	ModelAndView mv = new ModelAndView("user/editUser");
    	mv.addObject("userId", userdetails.getId());
    	mv.addObject("firstname", userdetails.getFirstname());
    	mv.addObject("lastname", userdetails.getLastname());
    	mv.addObject("email", userdetails.getEmail());
    	mv.addObject("phone", userdetails.getPhone());
    	mv.addObject("address", userdetails.getAddress());
    	return mv;
    }
	
	@RequestMapping("updateProfileDetails")
	@ResponseBody
    public String updateProfile(HttpServletRequest request) throws SQLException {
		logger.debug("Inside editProfile");
    	
		return userService.updateProfile(request);
    }
}
