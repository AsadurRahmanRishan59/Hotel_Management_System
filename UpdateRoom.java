
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
    
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3;
    
    UpdateRoom(){
        
        JLabel roomStatus = new JLabel("Update Room Status");
        roomStatus.setBounds(30,20,250,30);
        roomStatus.setForeground(Color.blue);
        roomStatus.setFont(new Font("serif", Font.PLAIN, 25));
        add(roomStatus);
        
        JLabel guest = new JLabel("Guest ID");
        guest.setBounds(40,80,70,20);
        add(guest);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch(Exception e){
            System.out.println("e");
        }
        c1.setBounds(200,80,150,25);
        add(c1);
        
        JLabel name = new JLabel("Room Number");
        name.setBounds(40,130,120,20);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200,130,150,30);
        add(t1);
        
        JLabel status = new JLabel("Availability");
        status.setBounds(40,180,70,20);
        add(status);
        
        t2 = new JTextField();
        t2.setBounds(200,180,150,30);
        add(t2);
        
        JLabel cleanStatus = new JLabel("Clean Status");
        cleanStatus.setBounds(40,230,120,20);
        add(cleanStatus);
        
        t3 = new JTextField();
        t3.setBounds(200,230,150,30);
        add(t3);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(130,300,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(40,350,120,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.WHITE);
        b3.setBounds(220,350,120,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,10,500,400);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(250,150,980,450);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
           
            String room = null;
            String str1 = c1.getSelectedItem();
            conn c = new conn();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+str1+"'");
                while (rs.next()){
                    t1.setText(rs.getString("room"));
                    room = rs.getString("room");
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room = '"+room+"'");
                while (rs2.next()){
                    t2.setText(rs2.getString("available"));
                    t3.setText(rs2.getString("status"));
                }  
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == b2){
            try{
                conn c = new conn();
                String room = t1.getText();
                String available = t2.getText();
                String status = t3.getText();
                
                String str = "update room set available = '"+available+"',status = '"+status+"' where room = '"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Room Updated");
                new Reception().setVisible(true);
                this.setVisible(false);
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        }
    
    public static void main(String[] args){
        new UpdateRoom().setVisible(true);
    }
    
}
