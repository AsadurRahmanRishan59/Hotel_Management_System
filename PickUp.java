
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class PickUp extends JFrame implements ActionListener{
    
    JButton b1,b2;
    Choice c1;
    JTable table1;
    
    PickUp(){
       
        JLabel roomStatus = new JLabel("Pick-Up Service");
        roomStatus.setBounds(400,30,200,30);
        roomStatus.setForeground(Color.blue);
        roomStatus.setFont(new Font("serif", Font.PLAIN, 25));
        add(roomStatus);
        
        JLabel type = new JLabel("Type of Car");
        type.setBounds(50,100,100,20);
        add(type);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("car"));
            }
        }catch(Exception e){
            System.out.println("e");
        }
        c1.setBounds(150,100,200,35);
        add(c1);
        
        table1 = new JTable();
        table1.setBounds(0,170,1000,300);
        add(table1);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(300,470,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(500,470,120,30);
        b2.addActionListener(this);
        add(b2);
        
        JLabel name = new JLabel("Driver Name");
        name.setBounds(40,148,100,20);
        add(name);
        
        JLabel age = new JLabel("Age");
        age.setBounds(200,148,100,20);
        add(age);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(330,148,100,20);
        add(gender);
        
        JLabel car = new JLabel("Car");
        car.setBounds(470,148,100,20);
        add(car);
        
        JLabel model = new JLabel("Model");
        model.setBounds(600,148,100,20);
        add(model);
        
        JLabel available = new JLabel("Availability");
        available.setBounds(740,148,100,20);
        add(available);
        
        JLabel location = new JLabel("Location");
        location.setBounds(880,148,100,20);
        add(location);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(250,150,1000,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                
                String s1 = "select * from driver where car = '"+c1.getSelectedItem()+"'";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(s1);
                table1.setModel(DbUtils.resultSetToTableModel(rs));
          
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new PickUp().setVisible(true);
    }
}
