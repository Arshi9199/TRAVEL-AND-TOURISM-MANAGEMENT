package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener
{
    JButton back;
   
    ViewCustomer(String username)
  {
      setBounds(450,180,870,625);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
      JLabel us=new JLabel("Username");
      us.setBounds(30,50,150,25);
      add(us);
      
      JLabel u=new JLabel();
      u.setBounds(220,50,150,25);
      add(u);
      
      JLabel id=new JLabel("Id");
      id.setBounds(30,110,150,25);
      add(id);
      
      JLabel lid=new JLabel();
      lid.setBounds(220,110,150,25);
      add(lid);
      
      JLabel no=new JLabel("Number");
      no.setBounds(30,170,150,25);
      add(no);
      
      JLabel lno=new JLabel();
      lno.setBounds(220,170,150,25);
      add(lno);
      
      JLabel name=new JLabel("Name");
      name.setBounds(30,230,150,25);
      add(name);
      
      JLabel lname=new JLabel();
      lname.setBounds(220,230,150,25);
      add(lname);
      
      JLabel g=new JLabel("Gender");
      g.setBounds(30,290,150,25);
      add(g);
      
      JLabel lg=new JLabel();
      lg.setBounds(220,290,150,25);
      add(lg);
      
      JLabel co=new JLabel("Country");
      co.setBounds(500,50,150,25);
      add(co);
      
      JLabel lco=new JLabel();
      lco.setBounds(690,50,150,25);
      add(lco);
      
      JLabel ad=new JLabel("Address");
      ad.setBounds(500,110,150,25);
      add(ad);
      
      JLabel lad=new JLabel();
      lad.setBounds(690,110,150,25);
      add(lad);
      
      JLabel em=new JLabel("Email");
      em.setBounds(500,170,150,25);
      add(em);
      
      JLabel le=new JLabel();
      le.setBounds(690,170,150,25);
      add(le);
      
      JLabel pn=new JLabel("Phone Number");
      pn.setBounds(500,230,150,25);
      add(pn);
      
      JLabel lpn=new JLabel();
      lpn.setBounds(690,230,150,25);
      add(lpn);
      
      back=new JButton("Back");
      back.setBackground(Color.BLACK);
      back.setForeground(Color.WHITE);
      back.setBounds(350, 350, 100, 25);
      back.addActionListener(this);
      add(back);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
      Image i2 = i1.getImage().getScaledInstance(626, 201,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(20,400,600,200);
      add(image);
      
      ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
      Image i5 = i4.getImage().getScaledInstance(626, 201,Image.SCALE_DEFAULT);
      ImageIcon i6 = new ImageIcon(i5);
      JLabel image2 = new JLabel(i6);
      image2.setBounds(600,400,600,200);
      add(image2);
        
       try{
           Connect c =new Connect();
           String query ="select * from customer where username='"+username+"'";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next())
           {
              u.setText(rs.getString("username"));
              lid.setText(rs.getString("id"));
              lno.setText(rs.getString("number"));
              lname.setText(rs.getString("name"));
              lg.setText(rs.getString("gender"));
              lco.setText(rs.getString("country"));
              lad.setText(rs.getString("address"));
              le.setText(rs.getString("email"));
              lpn.setText(rs.getString("phone"));
              
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
       new ViewCustomer("Arshi");
   }
}
