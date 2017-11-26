package com.xat.management.rest.api;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xat.model.Organisation;
import com.xat.model.User;
import com.xat.services.OrganisationService;
import com.xat.services.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/organisations")
public class OrganisationResource {
	@Autowired
	OrganisationService organisationService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Organisation> list() {
		return organisationService.getOrganisations();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void saveOrganisation(@RequestBody Organisation org) {
		System.out.println("organisation " + org.getId());
		System.out.println("organisation name: " + org.getName());
		if (org.getId() != null && !StringUtils.isEmpty(org.getId())) {
			organisationService.save(org);
		} else {
			organisationService.create(org);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{organisationId}/users")
    List<User> getUsers(@PathVariable String organisationId) {
		return userService.getUsersByOrganisationId(organisationId);
    }
}
