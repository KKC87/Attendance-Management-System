package com.ams.app.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@RequestMapping("/getAppName")
	public String index() {
		return "Greetings from AMS app";
	}
	
	@RequestMapping(value = "/login/{emailid}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  @ResponseBody String login(@PathVariable("emailid") String emailid, @PathVariable("password") String password) {
		
		if(emailid.equals("admin@gmail.com") && password.equals("admin")) {
			//return new ResponseEntity<String>("Vaid User", HttpStatus.OK);
			return "Vaid User";
		}
		
		//return  new ResponseEntity<String>("InVaid User", HttpStatus.OK);
		return "Vaid User";
	}
	
	
	
	
}
