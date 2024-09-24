package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Cancel extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, tfcancellation, lblcode, lbljourneydate;
    JButton fetchButton, flight;
    
    
    public Cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(480,20,250,35);
        heading.setFont(new Font("Tahuma",Font.PLAIN,32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(590, 580,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);// humko imahge JLabel me save karna hai
        JLabel image = new JLabel(i3);//jLabel me directly save ni kr sakte islie new class bnaye hai
        image.setBounds(470,100,300,300);
        add(image);
        
        
        JLabel lblpnr = new JLabel("PNR Number ");
        lblpnr.setBounds(60,60,150,25);
        lblpnr.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblpnr);
        
        tfpnr= new JTextField();
        tfpnr.setBounds(200,60, 200, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(420,60,125,25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        
        JLabel lblname = new JLabel("Name ");
        lblname.setBounds(60,100,150,25);
        lblname.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,100, 200, 25);
        add(tfname);
        
        JLabel lblcancellation= new JLabel("Cancellation No");
        lblcancellation.setBounds(60,140,150,25);
        lblcancellation.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblcancellation);
        
        tfcancellation = new JLabel(""+random.nextInt(1000000));//jlabel string leta hai islie empty pass kiye h ki int ho jae
        tfcancellation.setBounds(220,140, 200, 25);
        add(tfcancellation);
         
        
        JLabel lbladdress = new JLabel("Flight Code");
        lbladdress.setBounds(60,180,150,25);
        lbladdress.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lbladdress);
        
        lblcode = new JLabel();
        lblcode.setBounds(220,180, 200, 25);
        add(lblcode);
        
        JLabel lblgender = new JLabel("Date Of Journey");
        lblgender.setBounds(60,220,150,25);
        lblgender.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblgender);
        
        lbljourneydate = new JLabel();
        lbljourneydate.setBounds(220,220,150,25);
        add(lbljourneydate);

        
        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220,280,130,25);
        flight.addActionListener(this);
        add(flight);
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//(length,width) frame bna rhe hai ushi ka size hai.
        setLocation(350,150);//left,top
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == fetchButton) {
            String pnr = tfpnr.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '"+pnr+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    lblcode.setText(rs.getString("flightcode"));
                    lbljourneydate.setText(rs.getString("ddate"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct PNR number");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = tfcancellation.getText(); 
            String fcode = lblcode.getText();
            String date = lbljourneydate.getText();
            
            try {
                Conn conn = new Conn();

                String query = "insert into cancel values('"+pnr+"','"+name+"', '"+cancelno+"','"+fcode+"','"+date+"')";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR='"+pnr+"'");
                JOptionPane.showMessageDialog(null,"Ticket Cancelled");
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new Cancel();
    }
}
