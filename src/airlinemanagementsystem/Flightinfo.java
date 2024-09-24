package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;// jar file import kiye hai ushi ka hai yeh

public class Flightinfo extends JFrame{
    
    public Flightinfo(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        //tabular form
        JTable table = new JTable();
        
        try{
            Conn conn = new Conn();
            
            ResultSet rs = conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));// jar file use kar rhe hai table bnane ke liye
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);//scroll bar ke liye
        jsp.setBounds(0,0,800,500);
        add(jsp);
        
//        table.setBounds(0,0,800,500);
//        add(table);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String args[]){
        new Flightinfo();
    }
}
