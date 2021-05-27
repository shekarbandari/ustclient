package com.ust.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.UserProfile;

@RestController
public class MyRestController {
	@RequestMapping("/ust/userDetails")
	public ResponseEntity<UserProfile> getUserDetails(){
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserProfile userProfile=new UserProfile();
		userProfile.setName(user.getUsername());
		userProfile.setEmail("shekharbandari@gmail.com");
		return ResponseEntity.ok(userProfile);
	}

}
