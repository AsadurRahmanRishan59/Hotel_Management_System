
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2,r3,r4;
    JComboBox c1;
    Choice c2;
    JButton b1,b2;
    
    AddCustomer(){
        
        JLabel addDriver = new JLabel("NEW CUSTOMER FORM");
        addDriver.setBounds(100,20,300,30);
        addDriver.setForeground(Color.blue);
        addDriver.setFont(new Font("serif", Font.PLAIN, 18));
        add(addDriver);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,80,70,20);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);
        
        JLabel id = new JLabel("ID");
        id.setBounds(40,120,70,20);
        add(id);
        
        c1 = new JComboBox(new String[]{"National ID","Passport","Driving-License"});
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,120,150,25);
        add(c1);
        
        JLabel number = new JLabel("Number");
        number.setBounds(40,160,70,20);
        add(number);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(40,200,70,20);
        add(gender);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("serif", Font.PLAIN, 14));
        r1.setBackground(Color.WHITE);
        r1.setBounds(200,200,70,20);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("serif", Font.PLAIN, 14));
        r2.setBackground(Color.WHITE);
        r2.setBounds(280,200,70,20);
        add(r2);
        
        JLabel country = new JLabel("Country");
        country.setBounds(40,240,70,20);
        add(country);
        
        t3 = new JTextField();
        t3.setBounds(200,240,150,25);
        add(t3);
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(40,280,120,20);
        add(room);
        
        c2 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            while(rs.next()){
                c2.add(rs.getString("room"));
            }
        }catch(Exception e){
            System.out.println("e");
        }
        c2.setBounds(200,280,150,25);
        add(c2);
         
        JLabel checkIn = new JLabel("Checked In");
        checkIn.setBounds(40,320,70,20);
        add(checkIn);
        
        t4 = new JTextField();
        t4.setBounds(200,320,150,25);
        add(t4);
        
        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(40,360,70,20);
        add(deposit);
        
        t5 = new JTextField();
        t5.setBounds(200,360,150,25);
        add(t5);
        
        b1 = new JButton("Add Customer");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50,410,120,25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,410,120,25);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/guest.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,50,300,400);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,150,800,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == b1){
             
             String name = t1.getText();
             String id = (String)c1.getSelectedItem();
             String number = t2.getText();
             String gender = null;
             
             if(r1.isSelected()){
                 gender = "Male";
             }else if (r2.isSelected()){
                 gender = "Female";
             }
             
             String country = t3.getText();
             String room = c2.getSelectedItem();
             String checkIn = t4.getText();
             String deposit = t5.getText();
            
             conn c = new conn();
        
             String str1 = "insert into customer values('"+name+"','"+id+"','"+number+"','"+gender+"','"+country+"','"+room+"','"+checkIn+"','"+deposit+"')";
             String str2 = "update room set available = 'Occupied' where room = '"+room+"'";
             try{
                 c.s.executeUpdate(str1);
                 c.s.executeUpdate(str2);
                 JOptionPane.showMessageDialog(null,"New Customer Added");
                 new Reception().setVisible(true);
                 this.setVisible(false);
             }catch(Exception e){
                 System.out.println(e);
             }
         }else if(ae.getSource() == b2){
             new Reception().setVisible(true);
             this.setVisible(false);
         }
    }
    public static void main(String[] args){
        new AddCustomer().setVisible(true);
    }
}
