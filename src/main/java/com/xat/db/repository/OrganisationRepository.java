package com.xat.db.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.xat.model.Organisation;

public interface OrganisationRepository extends MongoRepository<Organisation, String> {
	public Organisation findById(final String id);
}
