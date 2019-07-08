package cgone.repository;

/**
 * @author kesavan(K7)
 **/

import cgone.display.Display1stInn;
import cgone.display.Display2ndInn;
import cgone.display.DisplayOverView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CricGuruApp extends JFrame implements ActionListener {

    //variable deceleration

    String er = "Error";
    String fst = "Stencil";
    String fsb = "Source Code Pro Semibold";

    String que = "select match_id,team_1,team_1_score,team_2,team_2_score,status,player_of_the_match from matches where match_id =";
    String afg ="Afghanistan";
    String aus ="Australia";
    String ban ="Bangladesh";
    String eng ="England";
    String ind ="India";
    String nz ="New Zealand";
    String pak ="Pakistan";
    String rsa ="South Africa";
    String sl ="Sri Lanka";
    String wi ="West Indies";


    Image img;
    Image next;
    Image prev;

    JLabel lbllogo;
    JLabel lblteam;
    JLabel lblOverView;
    static JLabel lblmid;
    static JLabel lblteam1;
    static JLabel lblteam2;
    static JLabel lblscore1;
    static JLabel lblscore2;
    static JLabel lblstatus;
    static JLabel lblpom;
    JLabel lbl1teamname;
    JLabel lbl1col1;
    JLabel lbl1col2;
    JLabel lbl1col3;
    JLabel lbl1col4;
    JLabel lbl1col5;
    JLabel lbl1col6;
    JLabel lbl2col1;
    JLabel lbl2col2;
    JLabel lbl2col3;
    JLabel lbl2col4;
    JLabel lbl2col5;
    JLabel lbl2col6;
    static JTable tblbat;
    static JTable tblbowl;

    JButton btnselect;
    JButton btnnxt;
    JButton btnprev;
    JButton btnfinn;
    JButton btnsinn;

    JComboBox cbcountry;

    String [] teams = {afg,aus,ban,eng,ind,nz,pak,rsa,sl,wi};
    int [] tafg = {4,7,13,21,24,28,31,36,42};
    int [] taus = {4,10,14,17,20,26,32,37,45};
    int [] tban = {5,9,12,16,23,26,31,40,43};
    int [] teng = {1,6,12,19,24,27,32,38,41};
    int [] tind = {8,14,18,22,28,34,38,40,44};
    int [] tnz = {3,9,13,18,25,29,33,37,41};
    int [] tpak = {2,6,11,17,22,30,33,36,43};
    int [] trsa = {15,8,15,21,25,30,35,45};
    int [] tsl = {3,7,11,16,20,27,35,39,44};
    int [] twi = {2,10,15,19,23,29,34,39,42};
    int [] temp;
    int index=-1;

    //getter methods

    public static JLabel getLblmid() {
        return lblmid;
    }

    public static JLabel getLblteam1() {
        return lblteam1;
    }

    public static JLabel getLblteam2() {
        return lblteam2;
    }

    public static JLabel getLblscore1() {
        return lblscore1;
    }

    public static JLabel getLblscore2() {
        return lblscore2;
    }

    public static JLabel getLblstatus() {
        return lblstatus;
    }

    public static JLabel getLblpom() {
        return lblpom;
    }

    public static JTable getTblbat() { return tblbat; }

    public static JTable getTblbowl() { return tblbowl; }

    public CricGuruApp(){
        super("Cric Guru");
        setBounds(0,0,1920,1080);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setForeground(Color.DARK_GRAY);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        //design.logo

        lbllogo = new JLabel("");
        lbllogo.setBounds(-110,-10,440,280);
        lbllogo.setForeground(Color.DARK_GRAY);
        lbllogo.setBackground(Color.LIGHT_GRAY);
        img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
        lbllogo.setIcon(new ImageIcon(img));
        add(lbllogo);

        //design.selection

        lblteam = new JLabel("Select Team =>");
        lblteam.setBounds(320,60,300,30);
        lblteam.setFont(new Font(fst,Font.BOLD,25));
        lblteam.setForeground(Color.DARK_GRAY);
        lblteam.setBackground(Color.LIGHT_GRAY);
        add(lblteam);

        cbcountry = new JComboBox(teams);
        cbcountry.setForeground(Color.DARK_GRAY);
        cbcountry.setBackground(Color.LIGHT_GRAY);
        cbcountry.setFont(new Font("SansSerif", Font.PLAIN, 20));
        cbcountry.setBounds(620,60,300,30);
        add(cbcountry);

        btnselect = new JButton("Select");
        btnselect.setForeground(Color.DARK_GRAY);
        btnselect.setBackground(Color.LIGHT_GRAY);
        btnselect.setFont(new Font("Tekton Pro Ext", Font.BOLD, 20));
        btnselect.setBounds(1020,60,200,30);
        btnselect.addActionListener(this);
        add(btnselect);

        //design.overview

        lblOverView = new JLabel("Over View");
        lblOverView.setBounds(60,260,200,30);
        lblOverView.setFont(new Font(fst, Font.BOLD, 30));
        lblOverView.setForeground(Color.DARK_GRAY);
        lblOverView.setBackground(Color.LIGHT_GRAY);
        add(lblOverView);

        lblmid = new JLabel("Match ID: ");
        lblmid.setBounds(20,300,200,30);
        lblmid.setFont(new Font(fst, Font.ITALIC, 20));
        lblmid.setForeground(Color.DARK_GRAY);
        lblmid.setBackground(Color.LIGHT_GRAY);
        add(lblmid);

        lblteam1 = new JLabel("Team1");
        lblteam1.setBounds(20,330,100,30);
        lblteam1.setFont(new Font(fsb, Font.BOLD, 17));
        lblteam1.setForeground(Color.DARK_GRAY);
        lblteam1.setBackground(Color.LIGHT_GRAY);
        add(lblteam1);

        lblscore1 = new JLabel("Score1");
        lblscore1.setBounds(80,330,200,30);
        lblscore1.setFont(new Font(fsb, Font.BOLD, 17));
        lblscore1.setForeground(Color.DARK_GRAY);
        lblscore1.setBackground(Color.LIGHT_GRAY);
        add(lblscore1);

        lblteam2 = new JLabel("Team2");
        lblteam2.setBounds(20,360,100,30);
        lblteam2.setFont(new Font(fsb, Font.BOLD, 17));
        lblteam2.setForeground(Color.DARK_GRAY);
        lblteam2.setBackground(Color.LIGHT_GRAY);
        add(lblteam2);

        lblscore2 = new JLabel("Score2");
        lblscore2.setBounds(80,360,200,30);
        lblscore2.setFont(new Font(fsb, Font.BOLD, 17));
        lblscore2.setForeground(Color.DARK_GRAY);
        lblscore2.setBackground(Color.LIGHT_GRAY);
        add(lblscore2);

        lblstatus = new JLabel("Match Status");
        lblstatus.setBounds(20,390,300,30);
        lblstatus.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        lblstatus.setForeground(Color.DARK_GRAY);
        lblstatus.setBackground(Color.LIGHT_GRAY);
        add(lblstatus);

        lblpom = new JLabel("Player of the Match");
        lblpom.setBounds(20,420,250,30);
        lblpom.setFont(new Font("Times New Roman", Font.ITALIC, 17));
        lblpom.setForeground(Color.DARK_GRAY);
        lblpom.setBackground(Color.LIGHT_GRAY);
        add(lblpom);

        btnprev = new JButton("");
        btnprev.setBounds(50,460,30,30);
        btnprev.setForeground(Color.DARK_GRAY);
        btnprev.setBackground(Color.LIGHT_GRAY);
        prev = new ImageIcon(this.getClass().getResource("/prev.png")).getImage();
        btnprev.setIcon(new ImageIcon(prev));
        btnprev.addActionListener(this);
        add(btnprev);

        btnnxt = new JButton("");
        btnnxt.setBounds(100,460,30,30);
        btnnxt.setForeground(Color.DARK_GRAY);
        btnnxt.setBackground(Color.LIGHT_GRAY);
        next = new ImageIcon(this.getClass().getResource("/next.png")).getImage();
        btnnxt.setIcon(new ImageIcon(next));
        btnnxt.addActionListener(this);
        add(btnnxt);

        btnfinn = new JButton("First Innings");
        btnfinn.setBounds(20,520,250,30);
        btnfinn.setForeground(Color.DARK_GRAY);
        btnfinn.setBackground(Color.LIGHT_GRAY);
        btnfinn.setFont(new Font(fsb, Font.BOLD, 20));
        btnfinn.addActionListener(this);
        add(btnfinn);

        btnsinn = new JButton("Second Innings");
        btnsinn.setBounds(20,580,250,30);
        btnsinn.setForeground(Color.DARK_GRAY);
        btnsinn.setBackground(Color.LIGHT_GRAY);
        btnsinn.setFont(new Font(fsb, Font.BOLD, 20));
        btnsinn.addActionListener(this);
        add(btnsinn);

        //design.innings

        tblbat = new JTable();
        tblbat.setBounds(320,220,900,175);
        add(tblbat);

        lbl1teamname = new JLabel("Team");
        lbl1teamname.setFont(new Font(fst, Font.BOLD, 25));
        lbl1teamname.setBounds(320,130,150,30);
        add(lbl1teamname);

        lbl1col1 = new JLabel("Batsman");
        lbl1col1.setFont(new Font(fsb, Font.BOLD, 18));
        lbl1col1.setBounds(320,180,150,30);
        add(lbl1col1);

        lbl1col2 = new JLabel("Runs Scored");
        lbl1col2.setFont(new Font(fsb, Font.BOLD, 18));
        lbl1col2.setBounds(470,180,150,30);
        add(lbl1col2);

        lbl1col3 = new JLabel("Bowls Faced");
        lbl1col3.setFont(new Font(fsb, Font.BOLD, 18));
        lbl1col3.setBounds(620,180,150,30);
        add(lbl1col3);

        lbl1col4 = new JLabel("Fours Scored");
        lbl1col4.setFont(new Font(fsb, Font.BOLD, 18));
        lbl1col4.setBounds(770,180,150,30);
        add(lbl1col4);

        lbl1col5 = new JLabel("Sixs Scored");
        lbl1col5.setFont(new Font(fsb, Font.BOLD, 18));
        lbl1col5.setBounds(920,180,150,30);
        add(lbl1col5);

        lbl1col6 = new JLabel("Strike Rate");
        lbl1col6.setFont(new Font(fsb, Font.BOLD, 18));
        lbl1col6.setBounds(1070,180,150,30);
        add(lbl1col6);

        tblbowl = new JTable();
        tblbowl.setBounds(320,500,900,112);
        add(tblbowl);

        lbl2col1 = new JLabel("Bowler");
        lbl2col1.setFont(new Font(fsb, Font.BOLD, 18));
        lbl2col1.setBounds(320,460,150,30);
        add(lbl2col1);

        lbl2col2 = new JLabel("Over Throwed");
        lbl2col2.setFont(new Font(fsb, Font.BOLD, 18));
        lbl2col2.setBounds(470,460,150,30);
        add(lbl2col2);

        lbl2col3 = new JLabel("Maiden Overs");
        lbl2col3.setFont(new Font(fsb, Font.BOLD, 18));
        lbl2col3.setBounds(620,460,150,30);
        add(lbl2col3);

        lbl2col4 = new JLabel("Runs Given");
        lbl2col4.setFont(new Font(fsb, Font.BOLD, 18));
        lbl2col4.setBounds(770,460,150,30);
        add(lbl2col4);

        lbl2col5 = new JLabel("Wicket Taken");
        lbl2col5.setFont(new Font(fsb, Font.BOLD, 18));
        lbl2col5.setBounds(920,460,150,30);
        add(lbl2col5);

        lbl2col6 = new JLabel("Econemy");
        lbl2col6.setFont(new Font(fsb, Font.BOLD, 18));
        lbl2col6.setBounds(1070,460,150,30);
        add(lbl2col6);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //select button

        if(e.getSource().equals(btnselect)){
            if (cbcountry.getSelectedItem().equals(afg))
                temp = tafg;
            if (cbcountry.getSelectedItem().equals(aus))
                temp = taus;
            if (cbcountry.getSelectedItem().equals(ban))
                temp = tban;
            if (cbcountry.getSelectedItem().equals(eng))
                temp = teng;
            if (cbcountry.getSelectedItem().equals(ind))
                temp = tind;
            if (cbcountry.getSelectedItem().equals(nz))
                temp = tnz;
            if (cbcountry.getSelectedItem().equals(pak))
                temp = tpak;
            if (cbcountry.getSelectedItem().equals(rsa))
                temp = trsa;
            if (cbcountry.getSelectedItem().equals(sl))
                temp = tsl;
            if (cbcountry.getSelectedItem().equals(wi))
                temp = twi;

            try {
                index = 0;

                DisplayOverView cga = new DisplayOverView();
                cga.perform(que+temp[index]);

            }catch (Exception ae){
                JOptionPane.showMessageDialog(null,e,er,JOptionPane.INFORMATION_MESSAGE);
            }
        }

        //next button

        if((e.getSource().equals(btnnxt))&&(index>=0)){
            if (cbcountry.getSelectedItem().equals(afg))
                temp = tafg;
            if (cbcountry.getSelectedItem().equals(aus))
                temp = taus;
            if (cbcountry.getSelectedItem().equals(ban))
                temp = tban;
            if (cbcountry.getSelectedItem().equals(eng))
                temp = teng;
            if (cbcountry.getSelectedItem().equals(ind))
                temp = tind;
            if (cbcountry.getSelectedItem().equals(nz))
                temp = tnz;
            if (cbcountry.getSelectedItem().equals(pak))
                temp = tpak;
            if (cbcountry.getSelectedItem().equals(rsa))
                temp = trsa;
            if (cbcountry.getSelectedItem().equals(sl))
                temp = tsl;
            if (cbcountry.getSelectedItem().equals(wi))
                temp = twi;

            try {
                index ++;

                DisplayOverView cga = new DisplayOverView();
                cga.perform(que+temp[index]);

            }catch (Exception ae){
                JOptionPane.showMessageDialog(null,"No New Matches Found",er,JOptionPane.INFORMATION_MESSAGE);
            }
        }

        //prev button

        if((e.getSource().equals(btnprev))&&(index>=1)){

            try {
                index --;

                DisplayOverView cga = new DisplayOverView();
                cga.perform(que+temp[index]);

            }catch (Exception ae){
                JOptionPane.showMessageDialog(null,e,er,JOptionPane.INFORMATION_MESSAGE);
            }
        }

        //first innings button

        if(e.getSource().equals(btnfinn)){

            lbl1teamname.setText(lblteam1.getText());

            try {

                Display1stInn di = new Display1stInn();
                di.perform("SELECT Name,Runs_Scored,Balls_Faced,Fours_Scored,Sixes_Scored,Strike_Rate FROM scorecard,Players WHERE scorecard.Player_ID = players.Player_ID and scorecard.Innings_ID = 1 and scorecard.Match_ID ='"+temp[index]+"'",
                        "SELECT Name,Over_Throwed,Maiden_Throwed,Runs_Given,Wicket_Taken,Economy FROM scorecard,Players WHERE scorecard.Player_ID = players.Player_ID and Over_Throwed > 0 and Innings_ID = 2 and scorecard.Match_ID ='"+temp[index]+"'");

            }catch (Exception ae){
                JOptionPane.showMessageDialog(null,"First Select the Country",er,JOptionPane.INFORMATION_MESSAGE);
            }
        }

        //second innings button

        if(e.getSource().equals(btnsinn)){

            lbl1teamname.setText(lblteam2.getText());

            try {

                Display2ndInn di1 = new Display2ndInn();
                di1.perform("SELECT Name,Runs_Scored,Balls_Faced,Fours_Scored,Sixes_Scored,Strike_Rate FROM scorecard,Players WHERE scorecard.Player_ID = players.Player_ID and scorecard.Innings_ID = 2 and scorecard.Match_ID ='"+temp[index]+"'",
                        "SELECT Name,Over_Throwed,Maiden_Throwed,Runs_Given,Wicket_Taken,Economy FROM scorecard,Players WHERE scorecard.Player_ID = players.Player_ID and Over_Throwed > 0 and Innings_ID = 1 and scorecard.Match_ID ='"+temp[index]+"'");
            }catch (Exception ae){
                JOptionPane.showMessageDialog(null,"First Select the Country",er,JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
}
