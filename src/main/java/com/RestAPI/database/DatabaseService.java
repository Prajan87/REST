package com.RestAPI.database;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.RestAPI.MiniOffice.Profile;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class DatabaseService {
	
	public List<Profile> getDatabase(){
		List<Profile> coll = new ArrayList<>();

		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			
			DB db = mongo.getDB("miniOffice");
			DBCollection table = db.getCollection("profiles");
			
			
			
			BasicDBObject searchQuery = new BasicDBObject();
			//searchQuery.put("name", "Prajan");
			DBCursor cursor = table.find(searchQuery);
			
			while (cursor.hasNext()){
			BasicDBObject profileObj= (BasicDBObject) cursor.next();
			
				 String name = profileObj.getString("name");
				 String contact = profileObj.getString("contact");
				 String address = profileObj.getString("address");
				 
				 Profile profile = new Profile(name,contact,address);
				 coll.add(profile);
			

			}
			
			//System.out.println("outside loop");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coll;

	}

	public Profile postDatabase(Profile profile){
		try {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("miniOffice");
		DBCollection table = db.getCollection("profiles");
		
		BasicDBObject document = new BasicDBObject();
		document.put("name", profile.getName());
		document.put("contact", profile.getContact());
		document.put("address", profile.getAddress());
		table.insert(document);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profile;
	}
	
	public void deleteProfile(String name){
		
		try {
			MongoClient mongo = new MongoClient("localhost", 27017);
			DB db = mongo.getDB("miniOffice");
			DBCollection table = db.getCollection("profiles");
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", name);
			//DBCursor cursor = table.find(searchQuery);
			
			table.remove(searchQuery);

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public Profile updateDatabase(Profile profile){
		try {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("miniOffice");
		DBCollection table = db.getCollection("profiles");
		
		BasicDBObject document = new BasicDBObject();
		document.put("name", profile.getName());
		document.put("contact", profile.getContact());
		document.put("address", profile.getAddress());
		
		BasicDBObject querry = new BasicDBObject().append("name", profile.getName());
		table.update(querry, document);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profile;
	}
}
