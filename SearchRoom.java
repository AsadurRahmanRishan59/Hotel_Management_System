
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JComboBox c1;
    JCheckBox c2;
    JTable table1;
    
    SearchRoom(){
       
        JLabel roomStatus = new JLabel("Search For Room");
        roomStatus.setBounds(400,30,200,30);
        roomStatus.setForeground(Color.blue);
        roomStatus.setFont(new Font("serif", Font.PLAIN, 25));
        add(roomStatus);
        
        JLabel type = new JLabel("Room Type");
        type.setBounds(50,100,100,20);
        add(type);
        
        c1 = new JComboBox(new String[]{"Single Bed","Double Bed"});
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,100,150,25);
        add(c1);
        
        c2 = new JCheckBox("Only Display Available");
        c2.setBackground(Color.WHITE);
        c2.setBounds(650,100,150,25);
        add(c2);
        
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
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(40,148,100,20);
        add(room);
        
        JLabel available = new JLabel("Availability");
        available.setBounds(240,148,100,20);
        add(available);
        
        JLabel clean = new JLabel("Cleaning Status");
        clean.setBounds(440,148,100,20);
        add(clean);
        
        JLabel price = new JLabel("Price");
        price.setBounds(640,148,100,20);
        add(price);
        
        JLabel bed = new JLabel("Bed-Type");
        bed.setBounds(840,148,100,20);
        add(bed);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(250,150,1000,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{
                String s1 = "select * from room where bed_type = '"+c1.getSelectedItem()+"'";
                String s2 = "select * from room where available = 'Available' AND bed_type = '"+c1.getSelectedItem()+"'";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(s1);
                table1.setModel(DbUtils.resultSetToTableModel(rs));
                
                if(c2.isSelected()){
                    ResultSet rs2 = c.s.executeQuery(s2);
                    table1.setModel(DbUtils.resultSetToTableModel(rs2));
                }
            
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
        new SearchRoom().setVisible(true);
    }
}
