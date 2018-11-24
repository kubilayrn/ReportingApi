package com.spring.https.api.controller;




import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;








@Controller
public class ReportController {

	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String getReport() {
		// return html page name
		return "report";
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public String Report() {

		return "report";
	}
}
