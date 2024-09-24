package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode;
    JButton bookflight, fetchButton, flight;
    Choice source, destination;
    JDateChooser dcdate;
    
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("BOOK FLIGHT");
        heading.setBounds(420,20,500,35);
        heading.setFont(new Font("Tahuma",Font.PLAIN,32));
        heading.setForeground(Color.RED);
        add(heading);
        
        JLabel lblaadhar = new JLabel("Aadhar Number ");
        lblaadhar.setBounds(60,60,150,25);
        lblaadhar.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,60, 200, 25);
        add(tfaadhar);
        
        fetchButton = new JButton("Fetch User");
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
        
        JLabel lblnationality = new JLabel("Nationality ");
        lblnationality.setBounds(60,140,150,25);
        lblnationality.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220,140, 200, 25);
        add(tfnationality);
         
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,180,150,25);
        lbladdress.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220,180, 200, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,220,150,25);
        lblgender.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblgender);
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(220,220,150,25);
        add(labelgender);
       
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60,260,150,25);
        lblsource.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblsource);
        
        //Dropdown --> Choice or JComboBox se bhi bn jaega dropdown
        source = new Choice();
        source.setBounds(220,260,190,25);
        add(source);
        

        JLabel lbldesti = new JLabel("Destination");
        lbldesti.setBounds(60,300,150,25);
        lbldesti.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lbldesti);
        
        destination = new Choice();
        destination.setBounds(220,300,190,25);
        add(destination);
        
        try{
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(420,300,130,25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60,340,150,25);
        lblfname.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(200,340, 200, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60,380,150,25);
        lblfcode.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(200,380, 200, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date Of Journey");
        lbldate.setBounds(60,430,150,25);
        lbldate.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(200, 430, 150, 25);  // Adjust bounds to provide more space
        add(dcdate); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600,60,600,500);
        add(lblimage);
        
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(120,490,150,25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//(length,width) frame bna rhe hai ushi ka size hai.
        setLocation(200,50);//left,top
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == fetchButton) {
            String aadhar = tfaadhar.getText();
            
            try {
                Conn conn = new Conn();

                String query = "select * from passenger where aadhar = '"+aadhar+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tfname.setText(rs.getString("name")); 
                    tfnationality.setText(rs.getString("nationality")); 
                    tfaddress.setText(rs.getString("address"));
                    labelgender.setText(rs.getString("gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar number");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == flight) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            try {
                Conn conn = new Conn();

                String query = "select * from flight where source = '"+src+"' and destination = '"+dest+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    labelfname.setText(rs.getString("f_name")); 
                    labelfcode.setText(rs.getString("f_code")); 
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            
            String aadhar = tfaadhar.getText();
            String name = tfname.getText(); 
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText(); 
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem(); 
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
            try {
                Conn conn = new Conn();

                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+des+"', '"+ddate+"')";

                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new BookFlight();
    }
}
