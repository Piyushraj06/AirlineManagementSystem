package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//ActionListner use karte hai buttons in sb pr action perform karne ke liye
public class Login extends JFrame implements ActionListener {
    //kisi bi name ke aage J lga hai toh wo swing field se aaya hai
    
    JTextField tfusername, tfpassword;
    JButton submit,reset,close;
    public Login(){
 
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
        JLabel lblusername =  new JLabel("Username");
        lblusername.setBounds(20,20,100,20);//left, top,length,height
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername); // isse username ke aage box aaega
        
        JLabel lblpassword =  new JLabel("Password");
        lblpassword.setBounds(20,50,100,20);//left, top,length,height
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130,50,200,20);
        add(tfpassword); // isse password ke aage box aaega
        
        //Buttons
        
        reset = new JButton("Reset");
        reset.setBounds(60, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(210, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(130, 160, 120, 20);
        close.addActionListener(this);
        add(close);
        
        setSize(400,250);//hori len,verti height
        setLocation(600,250); // left,top
        setVisible(true);//frame visible nahi hota hai islie true karte hai
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            try{
                Conn c = new Conn();
                String query = "select * from login where username = '"+ username +"' and password = '"+ password+"'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"invalid Username or Password");
                    setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == reset){
            tfusername.setText("");
            tfpassword.setText("");
        }else if(ae.getSource() == close){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}