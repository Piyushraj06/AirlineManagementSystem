package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, tfnationality, tfsrc, tfdesti, labelfname, labelfcode,tfdate;
    JButton fetchButton;
    
    
    public BoardingPass(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(400,20,500,35);
        heading.setFont(new Font("Tahuma",Font.PLAIN,48));
        heading.setForeground(Color.RED);
        add(heading);
        
        JLabel subheading = new JLabel("BOARDING PASS");
        subheading.setBounds(350,70,350,30);
        subheading.setFont(new Font("Tahuma",Font.PLAIN,40));
        subheading.setForeground(Color.RED);
        add(subheading);
        
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setBounds(60,120,150,25);
        lblaadhar.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220,120, 200, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(440,120,125,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60,150,150,25);
        lblname.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,150, 200, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220,180, 200, 25);
        add(tfnationality);
         
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60,210,150,25);
        lbladdress.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lbladdress);
        
        tfsrc = new JLabel();
        tfsrc.setBounds(220,210, 200, 25);
        add(tfsrc);
        
        JLabel lblgender = new JLabel("DESTI");
        lblgender.setBounds(340,210,150,25);
        lblgender.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblgender);
        
        tfdesti = new JLabel();
        tfdesti.setBounds(500,210,150,25);
        add(tfdesti);
        
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,240,150,25);
        lblfname.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,240, 200, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(340,240,150,25);
        lblfcode.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(500,240,150,25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,270,150,25);
        lbldate.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lbldate);
        
        tfdate = new JLabel();
        tfdate.setBounds(200, 270, 150, 25);  // Adjust bounds to provide more space
        add(tfdate); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(310, 310, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(560,40,350,350);
        add(lblimage);
        
        
        setSize(1000, 450);
        setLocation(300, 150);//left,top
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
            String pnr = tfpnr.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '"+pnr+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    tfsrc.setText(rs.getString("src"));
                    tfdesti.setText(rs.getString("des"));
                    labelfname.setText(rs.getString("flightname"));
                    labelfcode.setText(rs.getString("flightcode"));
                    tfdate.setText(rs.getString("ddate"));

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR number");                
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    public static void main(String args[]){
        new BoardingPass();
    }
}
