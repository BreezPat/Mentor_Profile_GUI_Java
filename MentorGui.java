package mymentorgui;

import javax.swing.SwingUtilities;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import static java.awt.GridBagConstraints.HORIZONTAL;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author brijeshkumar
 */
public class MentorGui extends JFrame{
    JFrame frame = new JFrame("Mentor Profile GUI created by Brijeshkumar Patel");
    JPanel panelCont = new JPanel();
    JPanel panelAuth = new JPanel();
    JPanel panelMentorsInfo = new JPanel();
    CardLayout cl = new CardLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagLayout layout = new GridBagLayout();
    
    Font f1 = new Font("TimesRoman", Font.BOLD, 25);
    Font f2 = new Font("TimesRoman", Font.BOLD, 20);
    

    //public void setLayout(GridBagLayout layout) {
        //this.layout = layout;
    
    
    
    
    ///////Components for Authentication/////////    
    JLabel labelUname = new JLabel("Username");
    
    JLabel labelPass = new JLabel("Password");
    JLabel labelAuth = new JLabel("Authentication");
    
    JButton btnLogin = new JButton("Login");
    
    JTextField tfUname = new JTextField(25);
    
    JPasswordField pfPass = new JPasswordField(25);
    
    
    
    
    
    /////////Components for mentorInfo Panel/////
    JLabel labelFname = new JLabel("Firstname");
    JLabel labelLname = new JLabel("Lastname");
    JLabel labelEmail = new JLabel("Email");
    JLabel labelTPhone = new JLabel("Telephone");
    JLabel labelAddr = new JLabel("Address");
    JLabel labelHdegree = new JLabel("Highest Degree");
    JLabel labelGyear = new JLabel("Graduation Year");
    JLabel labelMinterest = new JLabel("Mentoring Interest");
   
    JButton btnSave = new JButton("Save");
    JButton btnReset = new JButton("Reset");
    
    JTextField tfFname = new JTextField(20);
    JTextField tfLname = new JTextField(20);
    JTextField tfEmail = new JTextField(20);
    JTextField tfTelephone = new JTextField(20);
    JTextField tfAddress = new JTextField(20);
    
   
    
    String[] degreeOpt= {"Select a Degree", "Associate", "Bachelors", "Masters", "PHD"};
    JComboBox cbHdegree = new JComboBox(degreeOpt);
            
    String[] gradYear= {"  Select a Year  ", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022" };   
    JComboBox cbGyear = new JComboBox(gradYear);
    
    JCheckBox chCS = new JCheckBox("Computer Science");
    JCheckBox chCyberS = new JCheckBox("Cybersecurity");
    JCheckBox chCIT = new JCheckBox("Computer Information Technology");
    JCheckBox chCIS = new JCheckBox("Computer Information System");
    
    
           
       
    public MentorGui(){
        
        /////Adding components to panel authentication
        panelCont.setLayout(cl);
        panelAuth.setLayout(layout);
        panelMentorsInfo.setLayout(layout);
       
        panelAuth.setSize(600, 600);
        gbc.insets = new Insets(15, 5, 5, 5);
        gbc.anchor = GridBagConstraints.LINE_START;
        
        labelUname.setFont(f2);
        labelPass.setFont(f2);
        labelAuth.setFont(f1);
        tfUname.setFont(f2);
        pfPass.setFont(f2);
        btnLogin.setFont(f2);

        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelAuth.add(labelUname, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelAuth.add(labelPass, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelAuth.add(labelAuth, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelAuth.add(btnLogin, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelAuth.add(tfUname, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panelAuth.add(pfPass, gbc);
        
        panelCont.add(panelAuth, "1");
        
        /////Adding components to panel Mentor Info
        
        panelMentorsInfo.setSize(600, 600);
        gbc.insets = new Insets(15, 5, 5, 5);
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelMentorsInfo.add(labelFname, gbc); labelFname.setFont(f2);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelMentorsInfo.add(labelLname, gbc); labelLname.setFont(f2);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelMentorsInfo.add(labelEmail, gbc); labelEmail.setFont(f2);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelMentorsInfo.add(labelTPhone, gbc); labelTPhone.setFont(f2);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panelMentorsInfo.add(labelAddr, gbc); labelAddr.setFont(f2);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        panelMentorsInfo.add(labelHdegree, gbc); labelHdegree.setFont(f2);
        
        gbc.gridx = 0;
        gbc.gridy = 6;
        panelMentorsInfo.add(labelGyear, gbc); labelGyear.setFont(f2);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        panelMentorsInfo.add(labelMinterest, gbc); labelMinterest.setFont(f2);
        labelMinterest.setToolTipText("Select majors that you are interested in mentoring");
        
        gbc.gridx = 1;
        gbc.gridy = 10;
        panelMentorsInfo.add(btnSave, gbc); btnSave.setFont(f1);
        
        gbc.gridx = 2;
        gbc.gridy = 10;
        panelMentorsInfo.add(btnReset, gbc); btnReset.setFont(f1);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panelMentorsInfo.add(tfFname, gbc); tfFname.setFont(f2);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelMentorsInfo.add(tfLname, gbc); tfLname.setFont(f2);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelMentorsInfo.add(tfEmail, gbc); tfEmail.setFont(f2);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelMentorsInfo.add(tfTelephone, gbc); tfTelephone.setFont(f2);
        
        gbc.gridx = 1;
        gbc.gridy = 4;
        panelMentorsInfo.add(tfAddress, gbc); tfAddress.setFont(f2);
        
        gbc.gridx = 1;
        gbc.gridy = 5;
        panelMentorsInfo.add(cbHdegree, gbc); cbHdegree.setFont(f2);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        panelMentorsInfo.add(cbGyear, gbc); cbGyear.setFont(f2);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
        panelMentorsInfo.add(chCS, gbc); chCS.setFont(f2);
       
        gbc.gridx = 2;
        gbc.gridy = 7;
        panelMentorsInfo.add(chCyberS, gbc); chCyberS.setFont(f2);
        
        gbc.gridx = 1;
        gbc.gridy = 8;
        panelMentorsInfo.add(chCIT, gbc); chCIT.setFont(f2);
        
        gbc.gridx = 2;
        gbc.gridy = 8;
        panelMentorsInfo.add(chCIS, gbc); chCIS.setFont(f2);
        
        
        
        panelCont.add(panelMentorsInfo, "2");
        cl.show(panelCont, "1");
        
        
        
        
        btnLogin.addActionListener((ActionEvent arg0) -> {
            String u = tfUname.getText();
            String p = pfPass.getText();
            
            
            String username = "admin";
            String password = "a123";
            
     
            if (u.equals(username) && (p.equals(password))){
                cl.show(panelCont, "2");
            }
            else{
                JOptionPane.showMessageDialog(this,"Please enter username or password");
            }
                
                
            //if (u.equals("") || p.equals("")){
                
                //JOptionPane.showMessageDialog(this,"Please enter username or password");
                
                    
            //}else{
                //cl.show(panelCont, "2");
                
            //}
     
            
                
            
                
            
 
           
            
            
        });
        
        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                tfFname.setText(" ");
                tfLname.setText(" ");
                tfEmail.setText("");
                tfTelephone.setText(" ");
                tfAddress.setText(" ");
                cbHdegree.setSelectedItem("Select a Degree");
                cbGyear.setSelectedItem("  Select a Year  ");
                chCS.setSelected(false);
                chCyberS.setSelected(false);
                chCIS.setSelected(false);
                chCIT.setSelected(false);
                
            }
        });
        
        
        btnSave.addActionListener((ActionEvent arg0) -> {
            try{
                
                
                String f = tfFname.getText();
                String l = tfLname.getText();
                String e = tfEmail.getText();
                String t = tfTelephone.getText();
                String a = tfAddress.getText();
                String cbd = cbHdegree.getSelectedItem().toString();
                String gy = cbGyear.getSelectedItem().toString();
                String cs = chCS.getText().trim();
                String cc = chCyberS.getText().trim();
                String cit = chCIT.getText().trim();
                String cis = chCIS.getText().trim();
                
                
                
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    //String url = "jdbc:derby://localhost:1527/Mentors System";
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MentorGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Mentors System", "Hello", "hi");
                Statement st = con.createStatement();
               
                PreparedStatement ps = con.prepareStatement("INSERT INTO" + "APP.MENTORS(FIRSTNAME, LASTNAME, EMAIL, TELEPHONE, ADDRESS, HIGHESTDEGREE, GRADUATIONTEAR, MENTORINGINTERESTS)"
                                                                + "values(?,?,?,?,?,?,?,?)");
                
                
                ps.setString(1, f);
                ps.setString(2, l);
                ps.setString(3, e);
                ps.setString(4, t);
                ps.setString(5, a);
                ps.setString(6, cbd);
                ps.setString(7, gy);
                if (chCS.isSelected()){
                    ps.setString(8, cs);
                }
                if (chCyberS.isSelected()){
                    ps.setString(8, cs);
                }
                if (chCIT.isSelected()){
                    ps.setString(8, cs);
                }
                if (chCIS.isSelected()){
                    ps.setString(8, cs);
                }
                ps.executeUpdate();
                
               
                JOptionPane.showMessageDialog(null,"Information Saved");
                    
                  
                
                
            }
            
            catch (HeadlessException | SQLException e){
                //JOptionPane.showMessageDialog(null,"Error!");
            
            }
        });
        
  
        frame.add(panelCont);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
                
        
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new MentorGui();
            }
        });
            
        
        
        
    }

    private void add(GridBagConstraints gbc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
