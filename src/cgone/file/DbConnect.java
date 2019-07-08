package cgone.file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author kesavan(K7)
 */

public class DbConnect implements FileRepository{

    Connection con;

    @Override
    public Connection getConnection()throws SQLException,ClassNotFoundException {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cric guru","root","cricguru");

        return con;
    }
}
