package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//ActionListner use karte hai buttons in sb pr action perform karne ke liye
public class Home extends JFrame implements ActionListener {
    //kisi bi name ke aage J lga hai toh wo swing field se aaya hai.
    public Home(){ 
        setLayout(null);
        //Image icon Add
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));//image lane ke liye
        JLabel image = new JLabel(i1);
        image.setBounds(0,-60, 1440,700);
        add(image);// isko hmko screeen pr dikhana hai islie add function use hua hai
        
        //Heading 
        JLabel heading = new JLabel("AIR INDIA WELCOME YOU");
        heading.setBounds(500,60,1000,40);//left,top,width,length
        heading.setForeground(Color.RED);//color change krne ke liye jo likha hua hai
        heading.setFont(new Font("Tahoma", Font.PLAIN,36));
        image.add(heading);//isko hmko image ke uper dikhana hai air india likha hua islie image.add aaega
        
        //Details Menu
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem BookFlight = new JMenuItem("Book Flight");
        BookFlight.addActionListener(this);
        details.add(BookFlight);
        
        
//        JMenuItem reservationDetails = new JMenuItem("Reservation Details");
//        reservationDetails.addActionListener(this);
//        details.add(reservationDetails);
        
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation= new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        
        //Ticket Menu
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//yeh full size kr dega
        setLocation(600,250); // left,top
        setVisible(true);//frame visible nahi hota hai islie true karte hai
    }
    
    public void actionPerformed(ActionEvent ae){
        String text = ae.getActionCommand();
        
        if(text.equals("Add Customer Details")){
            new AddCustomer();
        }else if(text.equals("Flight Details")){
            new Flightinfo();
        }else if(text.equals("Book Flight")){
            new BookFlight();
        }else if(text.equals("Journey Details")){
            new JourneyDetails();
        }else if(text.equals("Cancel Ticket")){
            new Cancel();
        }else if(text.equals("Boarding Pass")){
            new BoardingPass();
        }
    }
    public static void main(String args[]){
        new Home();
    }
}