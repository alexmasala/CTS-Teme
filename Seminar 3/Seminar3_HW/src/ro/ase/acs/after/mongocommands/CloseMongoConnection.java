package ro.ase.acs.after.mongocommands;

import com.mongodb.client.MongoClient;

public class CloseMongoConnection implements ro.ase.acs.after.contracts.CloseMongoConnection {
    @Override
    public void close(MongoClient mongoClient) {
        mongoClient.close();
    }
}
