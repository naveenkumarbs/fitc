package com.bsn.fitc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController {
	@RequestMapping("help")
    public ModelAndView getHelp(SessionStatus status,HttpSession session) {
    	ModelAndView mv = new ModelAndView("common/help");
    	return mv;
    }
	
	@RequestMapping("about")
    public ModelAndView getAboutUs(SessionStatus status,HttpSession session) {
    	ModelAndView mv = new ModelAndView("common/aboutUs");
    	return mv;
    }
	
	@RequestMapping("loginForm")
    public ModelAndView login(SessionStatus status,HttpSession session) {
    	ModelAndView mv = new ModelAndView("login/loginform");
    	return mv;
    }
	
	//registrationForm
	@RequestMapping("registrationForm")
    public ModelAndView registration(SessionStatus status,HttpSession session) {
    	ModelAndView mv = new ModelAndView("user/newUser");
    	return mv;
    }
	
	//Operations
	@RequestMapping("consumerOrders")
    public ModelAndView consumerOrders(SessionStatus status,HttpSession session) {
    	ModelAndView mv = new ModelAndView("operations/consumerOrders");
    	return mv;
    }
	
	@RequestMapping("newOrders")
    public ModelAndView newOrders(SessionStatus status,HttpSession session) {
    	ModelAndView mv = new ModelAndView("operations/newOrders");
    	return mv;
    }
	
	@RequestMapping("adminOperations")
    public ModelAndView adminOperations(SessionStatus status,HttpSession session) {
    	ModelAndView mv = new ModelAndView("operations/adminOperations");
    	return mv;
    }
	
	@RequestMapping("farmerOperations")
    public ModelAndView farmerOperations(SessionStatus status,HttpSession session) {
    	ModelAndView mv = new ModelAndView("operations/farmerOperations");
    	return mv;
    }
	
	@RequestMapping("marketadminOperations")
    public ModelAndView marketadminOperations(SessionStatus status,HttpSession session) {
    	ModelAndView mv = new ModelAndView("operations/marketadminOperations");
    	return mv;
    }
	
	@RequestMapping("ppadminOperations")
    public ModelAndView ppadminOperations(SessionStatus status,HttpSession session) {
    	ModelAndView mv = new ModelAndView("operations/ppadminOperations");
    	return mv;
    }
}
