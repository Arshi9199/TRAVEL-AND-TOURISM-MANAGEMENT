package travel.management.system;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {

    JButton login,s,f;
    JTextField tu,tp;
    Login() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
       
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);
        
        JLabel us = new JLabel("Username");
        us.setBounds(60,20,100,25);
        us.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        p2.add(us);
        
        tu=new JTextField();
        tu.setBounds(60,60,300,30);
        tu.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tu);
        
        JLabel p = new JLabel("Password");
        p.setBounds(60,110,100,25);
        p.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        p2.add(p);
        
        tp=new JPasswordField();
        tp.setBounds(60,150,300,30);
        tp.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tp);
        
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener( this);
        p2.add(login);
       
        s = new JButton("Signup");
        s.setBounds(230,200,130,30);
        s.setBackground(new Color(133,193,233));
        s.setForeground(Color.WHITE);
        s.setBorder(new LineBorder(new Color(133,193,233)));
        s.addActionListener( this);
        p2.add(s);
       
        f= new JButton("Forgot Password");
        f.setBounds(130,250,130,30);
        f.setBackground(new Color(133,193,233));
        f.setForeground(Color.WHITE);
        f.setBorder(new LineBorder(new Color(133,193,233)));
        f.addActionListener( this);
        p2.add(f);
       
        JLabel text= new JLabel("Trouble in Login...");
        text.setBounds(300,255,150,20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        setVisible(true);
    }
      public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==login){
            try{
               String username=tu.getText();
               String password=tp.getText();
               
               String query="select *from account where username='"+username+"' AND password ='"+password+"'";
               Connect c= new Connect();
               ResultSet rs =c.s.executeQuery(query);
               if(rs.next()){//true or false
                   setVisible(false);
                   new Loading(username);
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect username or password");
               }
            }catch(Exception e){
                e.printStackTrace();
            }
           }else if (ae.getSource()==s){
                setVisible(false);
                new Signup();
               }else{
                setVisible(false);
                new ForgetPassword();
            }
    }
    public static void main(String[] args) {
        new Login();
    }

}
