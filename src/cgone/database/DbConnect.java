package cgone.database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author kesavan(K7)
 */

public class DbConnect {

    static Connection con;


    public static Connection getConnection(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cric guru","root","cricguru");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e,"DB.Error!!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return con;
    }
}
