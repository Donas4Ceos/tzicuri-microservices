package com.ceos.tzicurimicroservices.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ceos.tzicurimicroservices.entities.User;

/**
 * 
 */
public interface UserRepo extends JpaRepository<User, Integer> {

}
