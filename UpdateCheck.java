
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener {
    
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    UpdateCheck(){
        
        JLabel roomStatus = new JLabel("Check-In Details");
        roomStatus.setBounds(30,20,250,30);
        roomStatus.setForeground(Color.blue);
        roomStatus.setFont(new Font("serif", Font.PLAIN, 25));
        add(roomStatus);
        
        JLabel guest = new JLabel("Guest ID");
        guest.setBounds(40,80,160,20);
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
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(40,120,160,20);
        add(room);
        
        t1 = new JTextField();
        t1.setBounds(200,120,150,30);
        add(t1);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,160,160,20);
        add(name);
        
        t2 = new JTextField();
        t2.setBounds(200,160,150,30);
        add(t2);
        
        JLabel check = new JLabel("Check-In");
        check.setBounds(40,200,160,20);
        add(check);
        
        t3 = new JTextField();
        t3.setBounds(200,200,150,30);
        add(t3);
        
        JLabel amount = new JLabel("Amount-Paid");
        amount.setBounds(40,240,160,20);
        add(amount);
        
        t4 = new JTextField();
        t4.setBounds(200,240,150,30);
        add(t4);
        
        JLabel remain = new JLabel("Pending-Amount");
        remain.setBounds(40,280,160,20);
        add(remain);
        
        t5 = new JTextField();
        t5.setBounds(200,280,150,30);
        add(t5);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,340,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150,340,100,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.WHITE);
        b3.setBounds(270,340,100,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
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
            String deposit = null;
            int amountPaid;
            String price = null;
            String str1 = c1.getSelectedItem();
            conn c = new conn();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+str1+"'");
                while (rs.next()){
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("checkIn"));
                    t4.setText(rs.getString("deposit"));
                    room = rs.getString("room");
                    deposit = rs.getString("deposit");
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room = '"+room+"'");
                while (rs2.next()){
                    price =rs2.getString("price");
                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPaid));
                }  
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == b2){
             try{
                 conn c = new conn();
                 String s1 = c1.getSelectedItem();
                 String s2 = t1.getText(); //room_number;
                 String s3 = t2.getText(); //name
                 String s4 = t3.getText(); //status;
                 String s5 = t4.getText(); //deposit
                 
                 c.s.executeUpdate("update customer set room = '"+s2+"', name = '"+s3+"', checkIn = '"+s4+"', deposit = '"+s5+"' where number = '"+s1+"'");
                 JOptionPane.showMessageDialog(null, "Data Updated");
                 new Reception().setVisible(true);
                 setVisible(false);
             }catch(Exception ee){
                 System.out.println(ee);
             }
            
        }else if(ae.getSource() == b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new UpdateCheck().setVisible(true);
    }
}
