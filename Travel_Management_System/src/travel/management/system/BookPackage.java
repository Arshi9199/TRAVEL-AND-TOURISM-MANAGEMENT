package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener
{
    Choice cpackage;
    JTextField tfp;
    String username;
    JLabel u,lid,lno,lph,ltp;
    JButton cp,bp,b;
    BookPackage(String username) 
    {
      this.username=username;
      setBounds(450,180,1100,625);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null); 
      
      JLabel t=new JLabel("BOOK PACKAGE");
      t.setBounds(100,10,200,30);
      t.setFont(new Font("Tahoma",Font.BOLD,20));
      add(t);
      
      JLabel us=new JLabel("Username");
      us.setFont(new Font("Tahoma",Font.PLAIN,16));
      us.setBounds(40,70,100,20);
      add(us);
      
      u=new JLabel();
      u.setFont(new Font("Tahoma",Font.PLAIN,16));
      u.setBounds(250,70,200,20);
      add(u);
      
      JLabel sp=new JLabel("Select Package");
      sp.setFont(new Font("Tahoma",Font.PLAIN,16));
      sp.setBounds(40,110,150,20);
      add(sp);
      
      cpackage= new Choice();
      cpackage.add("GOLD package");
      cpackage.add("SILVER package");
      cpackage.add("BRONZE package");
      cpackage.setBounds(250,110,200,20);
      add(cpackage);
      
      JLabel tno=new JLabel("Total persons ");
      tno.setFont(new Font("Tahoma",Font.PLAIN,16));
      tno.setBounds(40,150,150,25);
      add(tno);
      
      tfp=new JTextField("1");
      tfp.setBounds(250,150,200,25);
      add(tfp);
      
      JLabel id=new JLabel("Id");
      id.setFont(new Font("Tahoma",Font.PLAIN,16));
      id.setBounds(40,190,150,20);
      add(id);
      
      lid=new JLabel();
      lid.setBounds(250,190,200,25);
      add(lid);
      
      JLabel no=new JLabel("Number");
      no.setFont(new Font("Tahoma",Font.PLAIN,16));
      no.setBounds(40,230,150,25);
      add(no);
      
      lno=new JLabel();
      lno.setBounds(250,230,150,25);
      add(lno);
      
      JLabel ph=new JLabel("Phone number");
      ph.setFont(new Font("Tahoma",Font.PLAIN,16));
      ph.setBounds(40,270,150,20);
      add(ph);
      
      lph=new JLabel();
      lph.setBounds(250,270,200,25);
      add(lph);
      
      JLabel tp=new JLabel("Total Price");
      tp.setFont(new Font("Tahoma",Font.PLAIN,16));
      tp.setBounds(40,310,150,25);
      add(tp);
      
      ltp=new JLabel();
      ltp.setBounds(250,310,150,25);
      add(ltp);
      
      try{
           Connect c=new Connect(); 
           String query ="select * from customer where username='"+username+"'";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next()){
               u.setText(rs.getString("username"));
               lid.setText(rs.getString("id"));
               lno.setText(rs.getString("number"));
               lph.setText(rs.getString("phone"));
           } 
        }catch (Exception e){
            e.printStackTrace();
        }
        
        cp=new JButton("CheckPrice");
        cp.setBackground(Color.BLACK);
        cp.setForeground(Color.WHITE);
        cp.setBounds(60, 380, 120, 25);
        cp.addActionListener(this);
        add(cp);
      
        bp=new JButton("BookPackage");
        bp.setBackground(Color.BLACK);
        bp.setForeground(Color.WHITE);
        bp.setBounds(200, 380, 120, 25);
        bp.addActionListener(this);
        add(bp);
      
        b=new JButton("Back");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(340, 380, 120, 25);
        b.addActionListener(this);
        add(b);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(550,50,500,300);
        add(Image);
       
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==cp)
        {
            String pack=cpackage.getSelectedItem();
            int cost=0;
            if(pack.equals("GOLD package"))
            {
              cost+=12000;   
            }else if (pack.equals("SILVER package"))
            {
              cost+=25000;   
            }else
            {
             cost+=32000;  
            } 
            int persons=Integer.parseInt(tfp.getText());
            cost*=persons;
            ltp.setText("Rs "+ cost);
         
        }else if(ae.getSource()==bp)
        {
            try{
               Connect c= new Connect();
               c.s.executeUpdate("insert into bookpackage values('"+u.getText()+"','"+cpackage.getSelectedItem()+"','"+tfp.getText()+"','"+lid.getText()+"','"+lno.getText()+"','"+lph.getText()+"','"+ltp.getText()+"')");
               JOptionPane.showMessageDialog(null, "Package Booked Successfully");
               setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else
        {
          setVisible(false);  
        }
    }   
    
    public static void main(String[] args)
     {
         new BookPackage("Arshi");
     }
}
