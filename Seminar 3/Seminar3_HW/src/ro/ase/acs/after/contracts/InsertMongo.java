package ro.ase.acs.after.contracts;

import com.mongodb.client.MongoDatabase;

public interface InsertMongo {
    public void insert(MongoDatabase mongoDb, String collection);
}
