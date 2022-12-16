package com.email.trigger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.trigger.service.EmailService;
import com.email.trigger.to.Emailto;

@RestController
public class EmailController {
	
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public boolean emailTrigger(@RequestBody Emailto emailto){
		return emailService.sendEmail(emailto);
	}

}
