package cgone.display;

/**
 * @author kesavan(K7)
 */

import cgone.file.DbConnect;
import cgone.file.FileRepository;
import cgone.repository.CricGuruApp;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayOverView{

    //variable declaration

    ResultSet rs;
    Connection con;
    Statement st;
    JLabel lblmid;
    JLabel lblteam1;
    JLabel lblteam2;
    JLabel lblscore1;
    JLabel lblscore2;
    JLabel lblstatus;
    JLabel lblpom;

    public void perform(String que) {
        try{
            FileRepository fileRepository=new DbConnect();
            con= fileRepository.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(que);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e,"Query.Error!!",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        lblmid = CricGuruApp.getLblmid();
        lblteam1 = CricGuruApp.getLblteam1();
        lblteam2 = CricGuruApp.getLblteam2();
        lblscore1 = CricGuruApp.getLblscore1();
        lblscore2 = CricGuruApp.getLblscore2();
        lblstatus = CricGuruApp.getLblstatus();
        lblpom = CricGuruApp.getLblpom();

        try {
            while (rs.next()){
                lblmid.setText("Match ID: "+rs.getString("match_id"));
                lblteam1.setText(rs.getString("team_1"));
                lblscore1.setText(rs.getString("team_1_score"));
                lblteam2.setText(rs.getString("team_2"));
                lblscore2.setText(rs.getString("team_2_score"));
                lblstatus.setText(rs.getString("status"));
                lblpom.setText(rs.getString("player_of_the_match"));
            }

        }catch (Exception e1){
            JOptionPane.showMessageDialog(null,e1,"Error!!",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
