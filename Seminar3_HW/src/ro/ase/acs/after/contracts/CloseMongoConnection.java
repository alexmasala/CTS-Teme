package ro.ase.acs.after.contracts;

import com.mongodb.client.MongoClient;

public interface CloseMongoConnection {
    public void close(MongoClient mongoClient);
}
