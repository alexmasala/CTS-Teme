package ro.ase.acs.after.contracts;

import com.mongodb.client.MongoClient;

public interface ReadMongo {
    public void read(MongoClient mongoClient, String collection);
}
