package com.bsn.fitc.controller;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bsn.fitc.service.impl.LoginServiceImpl;
 
@Controller
@SessionAttributes("userName")
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginService;
 
    @RequestMapping("login")
    public ModelAndView home(HttpServletRequest request) {
    	
    	ModelAndView mv = new ModelAndView("login/loginSuccess");
		mv.addObject("message", loginService.validateUser(request));
		mv.addObject("userName", request.getParameter("userName"));
		return mv;
    }
     
    @RequestMapping("/next1")
    public String next(Map<String, Object> model) {
        model.put("message", "You are in new page !!");
        return "next";
    }
 
}