package ro.ase.acs.after.sql.sqlcommands;

import ro.ase.acs.after.contracts.Execution;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Create implements Execution<Connection> {

    @Override
    public Connection execute(Connection connection) {
        String sqlDrop = "DROP TABLE IF EXISTS employees";
        String sqlCreate = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
                + "name TEXT, address TEXT, salary REAL)";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDrop);
            statement.executeUpdate(sqlCreate);
            statement.close();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }
}
