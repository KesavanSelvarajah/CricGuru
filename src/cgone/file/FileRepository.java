package cgone.file;

import java.sql.Connection;
import java.sql.SQLException;

public interface FileRepository {
    public Connection getConnection() throws SQLException, ClassNotFoundException;
}
