package ro.ase.acs.after.sql.sqlcommands;

import ro.ase.acs.after.contracts.Execution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Insert implements Execution<Connection> {
    @Override
    public Connection execute(Connection connection) {
        String sqlInsert = "INSERT INTO employees VALUES(1, 'Popescu Ion', 'Bucharest', 4000)";
        String sqlInsertWithParams = "INSERT INTO employees VALUES (?,?,?,?)";
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlInsert);
            statement.close();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sqlInsertWithParams);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Ionescu Vasile");
            preparedStatement.setString(3, "Brasov");
            preparedStatement.setDouble(4, 4500);
            preparedStatement.executeUpdate();
            preparedStatement.close();

            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


}
