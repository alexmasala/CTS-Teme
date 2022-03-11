package ro.ase.acs.after.contracts;

import com.mongodb.client.MongoClient;

public interface OpenMongoCollection {
    public MongoClient openConnection();
}
