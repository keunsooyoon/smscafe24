package com.example.smsexam;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SmsController {
	
	@GetMapping("/")
	public String index() {
		return "sms";
	}
	
	@PostMapping("/sms")
	public String sms(@RequestParam ("phone") String phone,
					  @RequestParam ("message") String message
			) throws NoSuchAlgorithmException, IOException {
		
		SMS.sendsms(message, phone);
		
		return "sms";
	}
	
}
