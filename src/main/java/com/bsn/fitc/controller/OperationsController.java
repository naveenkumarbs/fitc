package com.bsn.fitc.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("operations")
public class OperationsController {
	@RequestMapping("adminOperations")
	public ModelAndView adminOperations(HttpServletRequest request) {
    	ModelAndView mv = new ModelAndView("common/help");
    	
    	String operationName = request.getParameter("opName");
    	
    	switch(operationName) {
    	case "addMarket":
    	
    	case "removeMarket":
    		
    	case "addMarketAdmin":
    		
    	case "removeMarketAdmin":
    		
    	case "addPP":
    		
    	case "removePP":
    		
    	case "addPPAdmin":
    		
    	case "removePPAdmin":
    		
    	default:
    		
    		
    	}
    	
    	return mv;
    }
	
}