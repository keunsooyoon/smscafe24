package com.example.smsexam;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignupController {

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("/checknum")
	public @ResponseBody String checknum(
										@RequestParam ("phonenum") String phonenum
			) throws NoSuchAlgorithmException, IOException {
		
		
		Random rand = new Random();
		String check = Integer.toString(rand.nextInt(9000) + 1000);
				
		SMS.sendsms("확인 창에 " + check + "를 입력하세요", phonenum);		
		
		System.out.println(check);
		
		return check;
	}
	
	
	
}
