package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener
{
   JButton c,b;
   JTextField tu,tn,tp,tans;
   Choice security;
    Signup()
    {
     setBounds(350,200,900,360);
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     JPanel p1= new JPanel();
     p1.setBackground(new Color(133,193,233));
     p1.setBounds(0,0,500,400);
     p1.setLayout(null);
     add(p1);
//USERNAME     
     JLabel us = new JLabel("Username");
     us.setFont(new Font("Times New Roman ",Font.BOLD,14));
     us.setBounds(50,20,125,25);
     p1.add(us);
     
     tu= new JTextField();
     tu.setBounds(190,20,180,25);
     tu.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tu);
     
//NAME
     JLabel n = new JLabel("Name");
     n.setFont(new Font("Times New Roman ",Font.BOLD,14));
     n.setBounds(50,60,125,25);
     p1.add(n);
     
     tn= new JTextField();
     tn.setBounds(190,60,180,25);
     tn.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tn);
//PASSWORD
     JLabel pw = new JLabel("Password");
     pw.setFont(new Font("Times New Roman ",Font.BOLD,14));
     pw.setBounds(50,100,125,25);
     p1.add(pw);
     
     tp= new JTextField();
     tp.setBounds(190,100,180,25);
     tp.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tp);
//SECURITY QUESTION
     JLabel sc = new JLabel("Security Question");
     sc.setFont(new Font("Times New Roman ",Font.BOLD,14));
     sc.setBounds(50,140,125,25);
     p1.add(sc);
     
    security=new Choice();
    security.add("What is Your Country Name? ");
    security.add("What is your School Name? ");
    security.add("What is National Animal?");
    security.add("Your Favourite Colour?");
    security.setBounds(190,140,180,25);
    p1.add(security);
     
//ANSWER
     JLabel ans = new JLabel("Answer");
     ans.setFont(new Font("Times New Roman ",Font.BOLD,14));
     ans.setBounds(50,180,125,25);
     p1.add(ans);
     
     tans= new JTextField();
     tans.setBounds(190,180,180,25);
     tans.setBorder(BorderFactory.createEmptyBorder());
     p1.add(tans);
//BUTTONS 
     c = new JButton("Create");
     c.setBackground(Color.WHITE);
     c.setForeground(new Color(133,193,233));
     c.setFont(new Font("Times New Roman",Font.BOLD,14));
     c.setBounds(80,250,100,30);
     c.addActionListener(this);
     p1.add(c);
     
     b = new JButton("Back");
     b.setBackground(Color.WHITE);
     b.setForeground(new Color(133,193,233));
     b.setFont(new Font("Times New Roman",Font.BOLD,14));
     b.setBounds(250,250,100,30);
     b.addActionListener(this);
     p1.add(b);
     
     ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/s1.png"));
     Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
     ImageIcon i3= new ImageIcon(i2);
     JLabel image=new JLabel(i3);
     image.setBounds(580,50,250,250);
     add(image);
     
     
     
     
     setVisible(true);
     
    }
    
    public void  actionPerformed(ActionEvent ae)
    {
     if(ae.getSource()==c){
       String username = tu.getText();
       String name = tn.getText();
       String password = tp.getText();
       String question = security.getSelectedItem();
       String answer = tans.getText();
       
       String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
       try{
          Connect c= new Connect();
          c.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Account Created SuccessFully");
          
          setVisible(false);
          new Login();
       }catch (Exception e){
           e.printStackTrace();
       }
     } else if(ae.getSource()==b){
         setVisible(false);
         new Login();
         
     }  
    }
   
    public static void main(String[] args)
    {
        new Signup();
        
    }
    
}
