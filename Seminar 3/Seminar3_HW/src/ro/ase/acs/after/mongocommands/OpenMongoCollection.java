package ro.ase.acs.after.mongocommands;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class OpenMongoCollection implements ro.ase.acs.after.contracts.OpenMongoCollection {
    @Override
    public MongoClient openConnection() {

        MongoClient mongoClient;
        mongoClient = MongoClients.create();
        MongoDatabase mongoDb = mongoClient.getDatabase("test");
        return mongoClient;
    }
}
