package ro.ase.acs.after.mongocommands;

import com.mongodb.client.MongoDatabase;

public class CreateMongoCollection implements ro.ase.acs.after.contracts.CreateMongoCollection {
    @Override
    public void create(MongoDatabase mongoDb, String collection) {
        if (mongoDb.getCollection(collection) != null) {
            mongoDb.getCollection(collection).drop();
        }
        mongoDb.createCollection(collection);
    }
}
