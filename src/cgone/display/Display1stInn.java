package cgone.display;

/**
 * @author kesavan(K7)
 */

import cgone.file.DbConnect;
import cgone.file.FileRepository;
import cgone.repository.CricGuruApp;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Display1stInn implements Display{

    //variable declaration

    ResultSet rs1;
    ResultSet rs2;
    Connection con;
    Statement st1;
    Statement st2;
    JTable tblbat;
    JTable tblbowl;

    @Override
    public void perform(String que1,String que2) {
        try{
            FileRepository fileRepository= new DbConnect();
            con= fileRepository.getConnection();
            st1 = con.createStatement();
            st2 = con.createStatement();
            rs1 = st1.executeQuery(que1);
            rs2 = st2.executeQuery(que2);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e,"Query.Error!!",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        tblbat = CricGuruApp.getTblbat();
        tblbowl = CricGuruApp.getTblbowl();

        try {
            tblbat.setModel(DbUtils.resultSetToTableModel(rs1));
            tblbowl.setModel(DbUtils.resultSetToTableModel(rs2));
        }catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1,"Error!!",JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
