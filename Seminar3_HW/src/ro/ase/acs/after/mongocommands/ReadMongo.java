package ro.ase.acs.after.mongocommands;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ReadMongo implements ro.ase.acs.after.contracts.ReadMongo {
    @Override
    public void read(MongoClient mongoClient, String collection) {
        MongoDatabase mongoDb = mongoClient.getDatabase("test");
        MongoCollection<Document> mongoCollection = mongoDb.getCollection(collection);

        FindIterable<Document> result = mongoCollection.find();
        for (Document doc : result) {
            System.out.println(doc);
        }
    }
}
