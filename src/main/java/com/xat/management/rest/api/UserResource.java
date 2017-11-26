package com.xat.management.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xat.model.User;
import com.xat.services.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
public class UserResource {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    User getUser(@PathVariable String userId) {
		User user = userService.getUserById(userId);
		if (user != null) {
	        return user;
		} else {
			System.out.println("No user found for " + userId);
			return null;
		}
    }
	
	/**
	 * Create user
	 * @param user
	 * @return
	 * 
	 * <code>
	 * {
     * "username": "testuser4",
     * "password": "xat",
     * "authorities": [
     *     "ADMIN"
     * ],
     * "firstName" : "Gary",
     * "lastName" : "Neville",
     * "lastModified": "2017-09-10T13:39:39.718Z",
     * "organisation" : {"id" : "5a196649bb7eb111714e040c"}
	 * }
	 * </code>
	 */
	@RequestMapping(method = RequestMethod.POST)
    User create(@RequestBody User user) {
		return userService.createUser(user);
    }
	
	/**
	 * DO NOT USED
	 * @return
	 */
	@RequestMapping("/user")
    String user() {
		UserDetails userDetails = userDetailsService.loadUserByUsername("xat");
		System.out.println(userDetails.getUsername());
        return "Application User Resource";
    }
}
