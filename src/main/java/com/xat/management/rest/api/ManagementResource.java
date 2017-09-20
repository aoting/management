package com.xat.management.rest.api;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xat.model.Organisation;

@RestController
@EnableAutoConfiguration
public class ManagementResource {
	
	@RequestMapping("/")
    String home() {
        return "Application Management Resource";
    }
	
	@RequestMapping(value = "/management", method = POST)
	public Organisation updateOrganisation(@RequestBody Organisation organisation) {
		System.out.println(organisation.getId());
		return organisation;
	}

}
