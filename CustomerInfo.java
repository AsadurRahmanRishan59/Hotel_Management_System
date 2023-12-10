
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2;
    
    CustomerInfo(){
        t1 = new JTable();
        t1.setBounds(0,40,1000,430);
        add(t1);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,10,70,20);
        add(name);
        
        JLabel id = new JLabel("ID");
        id.setBounds(170,10,70,20);
        add(id);
        
        JLabel number = new JLabel("Number");
        number.setBounds(270,10,70,20);
        add(number);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(420,10,70,20);
        add(gender);
        
        JLabel country = new JLabel("Country");
        country.setBounds(540,10,70,20);
        add(country);
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(640,10,90,20);
        add(room);
        
        JLabel status = new JLabel("Checked In");
        status.setBounds(780,10,70,20);
        add(status);
        
        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(905,10,70,20);
        add(deposit);
        
        b1 = new JButton("Load Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(350,500,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(530,500,120,30);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(250,150,1000,580);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from customer");
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new CustomerInfo().setVisible(true);
    }
}
