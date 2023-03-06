package com.ceos.tzicurimicroservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceos.tzicurimicroservices.entities.User;
import com.ceos.tzicurimicroservices.repos.UserRepo;

/**
 * 
 */
@Service
public class UserService {

	@Autowired
	UserRepo userrepo;

	public List<User> getUsers() {
		return userrepo.findAll();
	}

	public User postUser(User usuario) {
		return userrepo.save(usuario);
	}
}
