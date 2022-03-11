package ro.ase.acs.after.contracts;


import java.sql.Connection;

public interface Execution<T> {
    T execute(Connection connection);

}
