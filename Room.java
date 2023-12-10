
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
    
    Room(){
        t1 = new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(10,10,100,20);
        add(room);
        
        JLabel availability = new JLabel("Availability");
        availability.setBounds(105,10,100,20);
        add(availability);
        
        JLabel status = new JLabel("Cleaning Status");
        status.setBounds(200,10,100,20);
        add(status);
        
        JLabel price = new JLabel("Price");
        price.setBounds(330,10,100,20);
        add(price);
        
        JLabel type = new JLabel("Bed Type");
        type.setBounds(400,10,100,20);
        add(type);
        
        b1 = new JButton("Load Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,460,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(250,460,120,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(510,0,600,600);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(250,150,1080,580);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from room");
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
        new Room().setVisible(true);
    }
    
}
