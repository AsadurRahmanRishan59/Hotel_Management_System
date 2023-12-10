
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CheckOut extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1;
    CheckOut(){
        
        JLabel chcek = new JLabel("Check Out");
        chcek.setBounds(120,20,120,30);
        chcek.setForeground(Color.blue);
        chcek.setFont(new Font("serif", Font.PLAIN, 25));
        add(chcek);
        
        
        
        JLabel guest = new JLabel("Guest ID");
        guest.setBounds(30,80,125,30);
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
        c1.setBounds(150,80,160,35);
        add(c1);
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(30,120,125,30);
        add(room);
        
        t1 = new JTextField();
        t1.setBounds(150,120,160,30);
        add(t1);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,200,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(170,200,120,30);
        b2.addActionListener(this);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(310,80,20,20);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l1 = new JLabel(i6);
        l1.setBounds(350,0,400,250);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(250,150,800,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String str1 = c1.getSelectedItem();
            String room = t1.getText();
            conn c = new conn();
            
            try{
                 c.s.executeUpdate("Delete from customer where number = '"+str1+"'");
                 c.s.executeUpdate("update room set available ='Available' where room =  '"+room+"'");
                JOptionPane.showMessageDialog(null, "Chekout Done");
                new Reception().setVisible(true);
                this.setVisible(false);
                }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource() == b3){
            String str = c1.getSelectedItem();
            conn c = new conn();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from customer where number = '"+str+"'");
                while (rs.next()){
                    t1.setText(rs.getString("room"));
                }
                }catch(Exception e){
                System.out.println(e);
            }
        }
    }
        
    public static void main(String[] args){
        new CheckOut().setVisible(true);
    }

}
