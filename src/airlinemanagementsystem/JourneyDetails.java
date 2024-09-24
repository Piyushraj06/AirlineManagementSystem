package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class JourneyDetails extends JFrame implements ActionListener{
    JTable table;
    JTextField pnr;
    JButton show;
    public JourneyDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpnr.setBounds(50,50,100,25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160,50,120,25);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        add(show);
        
        //tabular form
        table = new JTable();
              
        JScrollPane jsp = new JScrollPane(table);//scroll bar ke liye
        jsp.setBounds(0,100,800,150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
//        table.setBounds(0,0,800,500);
//        add(table);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(400,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Invalid PNR");
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new JourneyDetails(); 
    }
}
