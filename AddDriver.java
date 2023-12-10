
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    
    JTextField t1,t2,t3,t4,t5;
    JRadioButton r1,r2,r3,r4;
    //JComboBox c1,c2;
    JButton b1,b2;
    
    AddDriver(){
        
        JLabel addDriver = new JLabel("ADD DRIVER");
        addDriver.setFont(new Font("serif", Font.BOLD, 18));
        addDriver.setBounds(150,10,150,30);
        add(addDriver);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("serif", Font.PLAIN, 17));
        name.setBounds(60,70,100,30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);
        
        JLabel age = new JLabel("Age");
        age.setFont(new Font("serif", Font.PLAIN, 17));
        age.setBounds(60,110,100,30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200,110,150,30);
        add(t2);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("serif", Font.PLAIN, 17));
        gender.setBounds(60,150,120,30);
        add(gender);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("serif", Font.PLAIN, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(200,150,70,30);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("serif", Font.PLAIN, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(280,150,70,30);
        add(r2);
        
        JLabel car = new JLabel("Car Company");
        car.setFont(new Font("serif", Font.PLAIN, 17));
        car.setBounds(60,190,100,30);
        add(car);
        
        t3 = new JTextField();
        t3.setBounds(200,190,150,30);
        add(t3);
        
        JLabel model = new JLabel("Car Model");
        model.setFont(new Font("serif", Font.PLAIN, 17));
        model.setBounds(60,230,100,30);
        add(model);
        
        t4 = new JTextField();
        t4.setBounds(200,230,150,30);
        add(t4);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("serif", Font.PLAIN, 16));
        available.setBounds(60,270,100,30);
        add(available);
        
        r3 = new JRadioButton("Available");
        r3.setFont(new Font("serif", Font.PLAIN, 14));
        r3.setBackground(Color.WHITE);
        r3.setBounds(200,270,100,30);
        add(r3);
        
        r4 = new JRadioButton("Reserved");
        r4.setFont(new Font("serif", Font.PLAIN, 14));
        r4.setBackground(Color.WHITE);
        r4.setBounds(280,270,100,30);
        add(r4);
        
        JLabel location = new JLabel("Location");
        location.setFont(new Font("serif", Font.PLAIN, 17));
        location.setBounds(60,310,100,30);
        add(location);
        
        t5 = new JTextField();
        t5.setBounds(200,310,150,30);
        add(t5);
        
        b1 = new JButton("Add Driver");
        b1.setBackground(Color.black);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60,370,130,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.WHITE);
        b2.setBounds(220,370,130,30);
        b2.addActionListener(this);
        add(b2);
    
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/car.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,80,500,300);
        add(l1);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(300,150,980,500);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == b1){
             
             String name = t1.getText();
             String age = t2.getText();
             String car = t3.getText();
             String model = t4.getText();
             String location = t5.getText();
            
             
             String gender = null;
             
             if(r1.isSelected()){
                 gender = "Male";
             }else if (r2.isSelected()){
                 gender = "Female";
             }
        
             String available = null;
             if(r1.isSelected()){
                 available = "Available";
             }else if (r2.isSelected()){
                 available = "Reserved";
             }
             
             conn c = new conn();
        
             String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+available+"','"+location+"')";
             try{
                 c.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null,"New Driver Added");
                 this.setVisible(false);
             }catch(Exception e){
                 System.out.println(e);
             }
         }else if(ae.getSource() == b2){
             this.setVisible(false);
         }
    }
    public static void main(String[] args){
        new AddDriver().setVisible(true);
    }
}
