package com.ceos.tzicurimicroservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceos.tzicurimicroservices.entities.User;
import com.ceos.tzicurimicroservices.services.UserService;

import jakarta.validation.Valid;

/**
 * 
 */

@RestController
@RequestMapping("/microservices")
public class UserController {

	@Autowired
	UserService userservice;

	@GetMapping("/user")
	public List<User> getUsers() {
		return userservice.getUsers();
	}

	@PostMapping("/user")
	public ResponseEntity<?> postUser(@Valid @RequestBody User usuario) {

		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.postUser(usuario));
	}

}
