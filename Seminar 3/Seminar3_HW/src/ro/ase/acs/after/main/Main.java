package ro.ase.acs.after.main;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import ro.ase.acs.after.mongocommands.*;
import ro.ase.acs.after.sql.sqlcommands.Create;
import ro.ase.acs.after.sql.sqlcommands.Insert;
import ro.ase.acs.after.sql.sqlcommands.Read;

import java.sql.*;

public class Main {
	public static void main(String[] args) {
		Create createTable = new Create();
		Insert insertData = new Insert();
		Read readData = new Read();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
			connection.setAutoCommit(false);
			
			createTable.execute(connection);
			insertData.execute(connection);
			readData.readValues(connection);
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String collection = "employees";
		OpenMongoCollection openConnectionNoSQL = new OpenMongoCollection();
		MongoClient mongoClient = openConnectionNoSQL.openConnection();
		MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
		CreateMongoCollection createMongo = new CreateMongoCollection();
		createMongo.create(mongoDatabase, collection);
		InsertMongo insertMongo = new InsertMongo();
		insertMongo.insert(mongoDatabase, collection);
		ReadMongo readMongo = new ReadMongo();
		readMongo.read((MongoClient) mongoDatabase, collection);
		CloseMongoConnection closeMongoConnection = new CloseMongoConnection();
		closeMongoConnection.close(mongoClient);
	}
	

}
