package com.xat.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.xat.model.XaUserDetails;

@Service
public class XaUserDetailsService implements UserDetailsService {

    @Autowired
    private MongoClient mongoClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MongoDatabase database = mongoClient.getDatabase("myFirstDb");
        MongoCollection<Document> collection = database.getCollection("users");

        Document document = collection.find(Filters.eq("username", username)).first();

        if(document!=null) {

//            String username = document.getString("username");
            String password = document.getString("password");
            List<String> authorities = (List<String>) document.get("authorities");

            XaUserDetails mongoUserDetails = new XaUserDetails(username, password, authorities.toArray(new String[authorities.size()]));

            return mongoUserDetails;
        }

        return null;
    }

}