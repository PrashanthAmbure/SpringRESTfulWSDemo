/**
 * 
 */
package com.xlncinc.client.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author PAmbure
 *
 */
@Controller
@RequestMapping(value="/welcome")
public class HelloWorldController {
	
	@RequestMapping(value="/message", method=RequestMethod.GET)
	public void getMessage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		response.getWriter().write("Welcome to Spring RESTful Web Services !!");
	}
}
