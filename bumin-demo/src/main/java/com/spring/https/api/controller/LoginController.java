package com.spring.https.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.https.api.form.LoginForm;

@Controller
public class LoginController {

	// to get login form page
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String getLoginForm() {
			// return html page name
			return "login";
		}

		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {

			String email = loginForm.getEmail();
			String password = loginForm.getPassword();

			if ("demo@bumin.com.tr".equals(email) && "cjaiU8CV".equals(password)) {
				//api login
				
				
				return "home";
			}
			model.addAttribute("invalidCredentials", true);
			return "login";
		}

	
}
