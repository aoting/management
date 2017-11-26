package com.xat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xat.db.repository.OrganisationRepository;
import com.xat.model.Organisation;

@Service
public class OrganisationService {
	@Autowired
	private OrganisationRepository organisationRepository;
	
	public List<Organisation> getOrganisations() {
		return organisationRepository.findAll();
	}
	
	public Organisation save(Organisation organisation) {
		return organisationRepository.save(organisation);
	}
	
	public Organisation create(Organisation organisation) {
		return organisationRepository.insert(organisation);
	}
}
