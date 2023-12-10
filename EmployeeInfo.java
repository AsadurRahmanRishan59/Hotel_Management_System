
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener {
    
    JTable t1;
    JButton b1,b2;
    
    EmployeeInfo(){
        
        t1 = new JTable();
        t1.setBounds(0,40,1000,430);
        add(t1);
        
        JLabel name = new JLabel("Name");
        name.setBounds(40,10,70,20);
        add(name);
        
        JLabel age = new JLabel("Age");
        age.setBounds(170,10,70,20);
        add(age);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(290,10,70,20);
        add(gender);
        
        JLabel job = new JLabel("Job");
        job.setBounds(420,10,70,20);
        add(job);
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(540,10,70,20);
        add(salary);
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(660,10,70,20);
        add(phone);
        
        JLabel nationalId = new JLabel("National ID");
        nationalId.setBounds(780,10,70,20);
        add(nationalId);
        
        JLabel email = new JLabel("Email");
        email.setBounds(905,10,70,20);
        add(email);
        
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
                ResultSet rs = c.s.executeQuery("select * from employee");
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
        new EmployeeInfo().setVisible(true);
    }
}
