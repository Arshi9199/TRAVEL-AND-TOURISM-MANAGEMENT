
package travel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener
{
    Choice chotel,cac,cf;
    JTextField tfp,dfp;
    String username;
    JLabel u,lid,lno,lph,ltp;
    JButton cp,bp,b;
    BookHotel(String username) 
    {
      this.username=username;
      setBounds(450,180,1150,625);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null); 
      
      JLabel t=new JLabel("BOOK HOTEL");
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
      
      JLabel sp=new JLabel("Select Hotel");
      sp.setFont(new Font("Tahoma",Font.PLAIN,16));
      sp.setBounds(40,110,150,20);
      add(sp);
      
      chotel= new Choice();
      chotel.setBounds(250,110,200,20);
      add(chotel);
      
      try{
          Connect c= new Connect();
          ResultSet rs= c.s.executeQuery("select * from hotel");
          while(rs.next()) {
             chotel.add(rs.getString("name")); 
          }
      }catch(Exception e){
          e.printStackTrace();
      }
      
      
      JLabel tno=new JLabel("Total persons ");
      tno.setFont(new Font("Tahoma",Font.PLAIN,16));
      tno.setBounds(40,150,150,25);
      add(tno);
      
      tfp=new JTextField("1");
      tfp.setBounds(250,150,200,25);
      add(tfp);
      
      JLabel dno=new JLabel("No Of Days");
      dno.setFont(new Font("Tahoma",Font.PLAIN,16));
      dno.setBounds(40,190,150,25);
      add(dno);
      
      dfp=new JTextField("1");
      dfp.setBounds(250,190,200,25);
      add(dfp);
      
      JLabel ac=new JLabel("AC / Non-AC");
      ac.setFont(new Font("Tahoma",Font.PLAIN,16));
      ac.setBounds(40,230,150,25);
      add(ac);
      
      cac= new Choice();
      cac.add("AC");
      cac.add("Non-AC");
      cac.setBounds(250,230,200,20);
      add(cac);
      
      JLabel f=new JLabel("Food Included");
      f.setFont(new Font("Tahoma",Font.PLAIN,16));
      f.setBounds(40,270,150,25);
      add(f);
      
      cf= new Choice();
      cf.add("Yes");
      cf.add("No");
      cf.setBounds(250,270,200,20);
      add(cf);
      
      JLabel id=new JLabel("Id");
      id.setFont(new Font("Tahoma",Font.PLAIN,16));
      id.setBounds(40,310,150,20);
      add(id);
      
      lid=new JLabel();
      lid.setBounds(250,310,200,25);
      add(lid);
      
      JLabel no=new JLabel("Number");
      no.setFont(new Font("Tahoma",Font.PLAIN,16));
      no.setBounds(40,350,150,25);
      add(no);
      
      lno=new JLabel();
      lno.setBounds(250,350,150,25);
      add(lno);
      
      JLabel ph=new JLabel("Phone number");
      ph.setFont(new Font("Tahoma",Font.PLAIN,16));
      ph.setBounds(40,390,150,20);
      add(ph);
      
      lph=new JLabel();
      lph.setBounds(250,390,200,25);
      add(lph);
      
      JLabel tp=new JLabel("Total Price");
      tp.setFont(new Font("Tahoma",Font.PLAIN,16));
      tp.setBounds(40,430,150,25);
      add(tp);
      
      ltp=new JLabel();
      ltp.setBounds(250,430,150,25);
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
        cp.setBounds(60, 490, 120, 25);
        cp.addActionListener(this);
        add(cp);
      
        bp=new JButton("Book Hotel");
        bp.setBackground(Color.BLACK);
        bp.setForeground(Color.WHITE);
        bp.setBounds(200, 490, 120, 25);
        bp.addActionListener(this);
        add(bp);
      
        b=new JButton("Back");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(340, 490, 120, 25);
        b.addActionListener(this);
        add(b);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(500,50,600,300);
        add(Image);
       
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==cp)
        {
            try{
            Connect c=new Connect(); 
            ResultSet rs = c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
            while(rs.next()){
               int cost=Integer.parseInt(rs.getString("costperperson"));
               int food=Integer.parseInt(rs.getString("foodincluded"));
               int ac=Integer.parseInt(rs.getString("acroom"));
               
               int p=Integer.parseInt(tfp.getText());
               int days=Integer.parseInt(dfp.getText());
               
               String acs=cac.getSelectedItem();
               String fs=cf.getSelectedItem();
               
               if(p*days >0){
                   int total=0;
                   total+=acs.equals("AC") ? ac : 0;
                   total+=fs.equals("Yes") ? food : 0;
                   total +=cost;
                   total= total * p * days;
                   ltp.setText("Rs "+ total);
                }else{
                   JOptionPane.showMessageDialog(null, "Please enter valid number");
               }
               
            }
        }catch (Exception e){
            e.printStackTrace();
        }
         
        }else if(ae.getSource()==bp)
        {
            try{
               Connect c= new Connect();
               c.s.executeUpdate("insert into bookhotel values('"+u.getText()+"','"+chotel.getSelectedItem()+"','"+tfp.getText()+"','"+dfp.getText()+"','"+cac.getSelectedItem()+"','"+cf.getSelectedItem()+"','"+lid.getText()+"','"+lno.getText()+"','"+lph.getText()+"','"+ltp.getText()+"')");
               JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
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
         new BookHotel("Arshi");
     }
}
