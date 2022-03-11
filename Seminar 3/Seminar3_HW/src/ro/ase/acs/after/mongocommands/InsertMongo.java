package ro.ase.acs.after.mongocommands;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class InsertMongo implements ro.ase.acs.after.contracts.InsertMongo {
    @Override
    public void insert(MongoDatabase mongoDb, String collection) {
        Document employee1 = new Document().append("name", "Popescu Ion").
                append("address", "Bucharest").append("salary", 4000);

        MongoCollection<Document> mongoCollection = mongoDb.getCollection(collection);
        mongoCollection.insertOne(employee1);

        Document employee2 = new Document().append("name", "Ionescu Vasile").
                append("salary", 4500);
        mongoCollection.insertOne(employee2);
    }
}
