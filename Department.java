
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JTable table1;
    
    Department(){
       
        JLabel roomStatus = new JLabel("DEPARTMENTS");
        roomStatus.setBounds(230,5,200,30);
        roomStatus.setForeground(Color.blue);
        roomStatus.setFont(new Font("serif", Font.PLAIN, 25));
        add(roomStatus);
       
        table1 = new JTable();
        table1.setBounds(0,80,700,300);
        add(table1);
        
        b1 = new JButton("Load Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(170,470,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(370,470,120,30);
        b2.addActionListener(this);
        add(b2);
        
        JLabel name = new JLabel("Department");
        name.setBounds(150,50,100,20);
        add(name);
        
        JLabel age = new JLabel("Budget");
        age.setBounds(480,50,100,20);
        add(age);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(250,150,700,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                
                String s1 = "select * from department";
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
        new Department().setVisible(true);
    }
}
