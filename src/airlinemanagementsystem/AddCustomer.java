package airlinemanagementsystem;
import javax.swing.*; // JFrame
import java.awt.*; // color class
import java.awt.event.*;//ActionListener

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname,tfaadhar,tfnationality,tfphone,tfaddress ;
    JRadioButton rbmale,rbfemale;
    
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(255,20,500,35);
        heading.setFont(new Font("Tahuma",Font.PLAIN,32));
        heading.setForeground(Color.RED);
        add(heading);
        
        
        JLabel lblname = new JLabel("Name ");
        lblname.setBounds(60,80,150,25);
        lblname.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,82, 200, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality ");
        lblnationality.setBounds(60,120,150,25);
        lblnationality.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(200,120, 200, 25);
        add(tfnationality);
        
        
        JLabel lblaadhar = new JLabel("Aadhar Number ");
        lblaadhar.setBounds(60,160,150,25);
        lblaadhar.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(200,160, 200, 25);
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,200,150,25);
        lbladdress.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,200, 200, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,240,150,25);
        lblgender.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();//yeh use kiye hai ki koi ek hi button click ho dono ni
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,240,95,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(310,240,95,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);//sirf male ya female ek baar me ek hi work kre dono click na ho islie
        gendergroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(60,280,150,25);
        lblphone.setFont(new Font("Tahuma",Font.PLAIN,16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,280,200,25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(130,330,150,35);
        save.addActionListener(this);
        add(save);
        
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(500,80,300,400);
        add(lblimage);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);//(length,width) frame bna rhe hai ushi ka size hai.
        setLocation(300,150);//left,top
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }
        
        try{
            Conn conn = new Conn();
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"' ,'"+address+"', '"+aadhar+"', '"+gender+"')";
            
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new AddCustomer();
    }
}
