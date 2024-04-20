package com.waycourier.app.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class CustomIdGenerator {
	@Autowired
	private MongoOperations mongoOp;
	
	public String generatePackageId() {
		return generateId("packages", "PK");
	}

	private String generateId(String collectionName, String prefix) {
		
		long count = mongoOp.count(new Query(), collectionName);
		
		return prefix + String.format("%03d", count+1);
	}
}
