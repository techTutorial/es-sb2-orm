package com.es.sb.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.es.sb.mvc.entity.UserEntity;
import com.es.sb.mvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> userDetails() {
        
		List<UserEntity> userDetails = userService.getUserDetails();
		return new ResponseEntity<List<UserEntity>>(userDetails, HttpStatus.OK);
	}

}
