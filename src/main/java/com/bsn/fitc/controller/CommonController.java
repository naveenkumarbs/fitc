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
}
