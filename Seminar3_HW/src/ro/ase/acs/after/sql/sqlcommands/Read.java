package ro.ase.acs.after.sql.sqlcommands;

import ro.ase.acs.after.contracts.Reader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Read implements Reader {
    @Override
    public Connection readValues(Connection connection) {

        String sqlSelect = "SELECT * FROM employees";

        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            while(rs.next()) {
                int id = rs.getInt("id");
                System.out.println("id: " + id);
                String name = rs.getString(2);
                System.out.println("name: " + name);
                String address = rs.getString("address");
                System.out.println("address: " + address);
                double salary = rs.getDouble("salary");
                System.out.println("salary: " + salary);
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
