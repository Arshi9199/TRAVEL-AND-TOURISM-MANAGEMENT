package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ForgetPassword extends JFrame implements ActionListener
{ 
    JTextField tu,tn,tq,tans,tp;
    JButton s,r,b;
    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
       Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(580,70,200,200);
       add(image);
       
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        JLabel un =new JLabel("Username");
        un.setBounds(40,20,100,25);
        un.setFont(new Font("Times New Roman ",Font.BOLD,14));
        p1.add(un);
        
        tu= new JTextField();
        tu.setBounds(220,20,150,25);
        tu.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tu);
        
        s = new JButton("Search");
        s.setBackground(Color.GRAY);
        s.setForeground(Color.WHITE);
        s.setBounds(380,20,100,25);
        s.addActionListener( this);
        p1.add(s);
        
        JLabel n =new JLabel("Name");
        n.setBounds(40,60,100,25);
        n.setFont(new Font("Times New Roman ",Font.BOLD,14));
        p1.add(n);
        
        tn= new JTextField();
        tn.setBounds(220,60,150,25);
        tn.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tn);
        
        JLabel qu =new JLabel("Security Question");
        qu.setBounds(40,100,150,25);
        qu.setFont(new Font("Times New Roman ",Font.BOLD,14));
        p1.add(qu);
        
        tq= new JTextField();
        tq.setBounds(220,100,150,25);
        tq.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tq);
        
        JLabel ans =new JLabel("Answer");
        ans.setBounds(40,140,150,25);
        ans.setFont(new Font("Times New Roman ",Font.BOLD,14));
        p1.add(ans);
        
        tans= new JTextField();
        tans.setBounds(220,140,150,25);
        tans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tans);
        
        r = new JButton("Retrieve");
        r.setBackground(Color.GRAY);
        r.setForeground(Color.WHITE);
        r.setBounds(380,140,100,25);
        r.addActionListener( this);
        p1.add(r);
        
        JLabel pw =new JLabel("Answer");
        pw.setBounds(40,180,150,25);
        pw.setFont(new Font("Times New Roman ",Font.BOLD,14));
        p1.add(pw);
        
        tp= new JTextField();
        tp.setBounds(220,180,150,25);
        tp.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tp);
        
        b = new JButton("Back");
        b.setBackground(Color.GRAY);
        b.setForeground(Color.WHITE);
        b.setBounds(150,230,100,25);
        b.addActionListener(this);
        p1.add(b);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource()==s){
           try{
               String query="select * from account where username='"+tu.getText()+"'";
               Connect c= new Connect();
               
               ResultSet rs = c.s.executeQuery(query);
               while(rs.next()){
                   tn.setText(rs.getString("name"));
                   tq.setText(rs.getString("security"));
               }
           }catch(Exception e){
               e.printStackTrace();
           }
            
            }else if (ae.getSource()==r){
                try{
               String query="select * from account where answer='"+tans.getText()+"' AND username ='"+tu.getText()+"'";
               Connect c= new Connect();
               
               ResultSet rs = c.s.executeQuery(query);
               while(rs.next()){
                   tp.setText(rs.getString("password"));
                  }
           }catch(Exception e){
               e.printStackTrace();
           }
            
            }else{
                setVisible(false);
                new Login();
            }
    }
    public static void main(String[] args){
        new ForgetPassword();
    }
}

    
