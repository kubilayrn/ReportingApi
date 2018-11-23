package com.spring.https.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
			String URLAddress="https://sandbox-reporting.rpdpymnt.com/api/v3/merchant/user/login";
			String inputString = null;
			int responseCode = 0;
			
			if ("demo@bumin.com.tr".equals(email) && "cjaiU8CV".equals(password)) {
				//Start
				
				 try {
				      URL url = new URL(URLAddress); 
				      try {
				        // Get an HttpURLConnection subclass object instead of URLConnection
				        HttpURLConnection myHttpConnection = (HttpURLConnection) url.openConnection();
				        
				        // ensure you use the GET method
				        myHttpConnection.setRequestMethod("POST");
				        myHttpConnection.setDoOutput(true);
				        
				        // create the query params
				        StringBuffer queryParam = new StringBuffer();
				        queryParam.append("email=");
				        queryParam.append(email);
				        queryParam.append("&");
				        queryParam.append("password=");
				        queryParam.append(password);
				        
				        
				        // Output the results
				        OutputStream output = myHttpConnection.getOutputStream();
				        output.write(queryParam.toString().getBytes());
				        output.flush();
				        
				        // get the response-code from the response 
				        responseCode = myHttpConnection.getResponseCode();
				        
				        // print out URL details
				        System.out.format("Connecting to %s\nConnection Method: '%s'\nResponse Code is: %d\n", URLAddress, "POST", responseCode);
				        
				        System.out.println("----[ OUTPUT BELOW ]-----------------------------------------------------------------");
				        
				        // open the contents of the URL as an inputStream and print to stdout
				        BufferedReader in = new BufferedReader(new InputStreamReader(
				            myHttpConnection.getInputStream()));
				        while ((inputString = in.readLine()) != null) {
				          System.out.println(inputString);
				        }
				        in.close();   
				        System.out.println("-------------------------------------------------------------------------------------");
				      } catch (IOException e) {
				        e.printStackTrace();
				      }
				    } catch (MalformedURLException e) {
				      e.printStackTrace();
				    }
				
				return "home";
			}
			model.addAttribute("invalidCredentials", true);
			return "login";
		}

	
}
