package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener
{
    JButton back;
   
    ViewPackage(String username)
  {
      setBounds(450,200,1000,550);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel t=new JLabel("VIEW PACKAGE DETAILS");
      t.setBounds(60,0,300,30);
      t.setFont(new Font("Tahoma",Font.BOLD,20));
      add(t);
      
      JLabel us=new JLabel("Username");
      us.setBounds(30,50,150,25);
      add(us);
      
      JLabel u=new JLabel();
      u.setBounds(220,50,150,25);
      add(u);
      
      JLabel p=new JLabel("Package");
      p.setBounds(30,90,150,25);
      add(p);
      
      JLabel lp=new JLabel();
      lp.setBounds(220,90,150,25);
      add(lp);
      
      JLabel po=new JLabel("Total Persons");
      po.setBounds(30,130,150,25);
      add(po);
      
      JLabel lpo=new JLabel();
      lpo.setBounds(220,130,150,25);
      add(lpo);
      
      JLabel id=new JLabel("Id");
      id.setBounds(30,170,150,25);
      add(id);
      
      JLabel lid=new JLabel();
      lid.setBounds(220,170,150,25);
      add(lid);
      
      JLabel no=new JLabel("Number");
      no.setBounds(30,210,150,25);
      add(no);
      
      JLabel lno=new JLabel();
      lno.setBounds(220,210,150,25);
      add(lno);
      
      JLabel ph=new JLabel("Phone");
      ph.setBounds(30,250,150,25);
      add(ph);
      
      JLabel lph=new JLabel();
      lph.setBounds(220,250,150,25);
      add(lph);
      
      JLabel pr=new JLabel("Price");
      pr.setBounds(30,290,150,25);
      add(pr);
      
      JLabel lpr=new JLabel();
      lpr.setBounds(220,290,150,25);
      add(lpr);
      
      back=new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.setBounds(130, 360, 100, 25);
      back.addActionListener(this);
      add(back);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
      Image i2 = i1.getImage().getScaledInstance(500, 400,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(450,20,500,400);
      add(image);
      
      try{
           Connect c =new Connect();
           String query ="select * from bookpackage where username='"+username+"'";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next())
           {
              u.setText(rs.getString("username"));
              lp.setText(rs.getString("package"));
              lpo.setText(rs.getString("persons"));
              lid.setText(rs.getString("id"));
              lno.setText(rs.getString("number"));
              lph.setText(rs.getString("phone"));
              lpr.setText(rs.getString("price"));
              
           }
       }catch (Exception e)
       {
           
       }
   
      
      setVisible(true);
  }
   public void actionPerformed(ActionEvent ae){
       setVisible(false);
   }
    
   public static void main(String[] args){
       new ViewPackage("Arshi");
   }
}
