package ro.ase.acs.after.contracts;

import java.sql.Connection;

public interface Reader {
    Connection readValues(Connection connection);
}
