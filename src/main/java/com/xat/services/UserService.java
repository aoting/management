package com.xat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xat.db.repository.UserRepository;
import com.xat.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

    public User getUserById(String id) {

//    	Find by mongo client
//        MongoDatabase database = mongoClient.getDatabase("myFirstDb");
//        MongoCollection<Document> collection = database.getCollection("users");
//
//        Document document = collection.find(Filters.eq("_id", new ObjectId(id))).first();
//        
//        
//
//        if(document != null) {
//            User user = new User(document.getObjectId("_id").toString(), document.getString("firstName"), document.getString("lastName"), document.getString("username"));
//            return user;
//        }
//
//        return null;
        
        return userRepository.findById(id);
    }
    
    public List<User> getUsersByOrganisationId(String organisationId) {
    	System.out.println(organisationId);
    	return userRepository.findByOrganisationId(organisationId);
    }
    
    public User createUser(User user) {
    	return userRepository.insert(user);
    }
}
