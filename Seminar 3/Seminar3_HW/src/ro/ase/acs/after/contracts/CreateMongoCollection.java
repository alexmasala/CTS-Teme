package ro.ase.acs.after.contracts;

import com.mongodb.client.MongoDatabase;

public interface CreateMongoCollection {
    public void create(MongoDatabase mongoDb, String collection);
}
