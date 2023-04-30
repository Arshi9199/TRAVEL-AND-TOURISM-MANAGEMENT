
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener
{
    JLabel un,tname;
    JComboBox comboid;
    JTextField tn,tc,ta,tp,te,tfid,tfg;
    JRadioButton rm,rf;
    JButton add,back;
    
    UpdateCustomer(String username)
    {
        setBounds(500,200,850,750);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel t=new JLabel("UPDATE CUSTOMER DETAILS");
        t.setBounds(50,0,300,25);
        t.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(t);
        
        
        JLabel us=new JLabel("Username");
        us.setBounds(30,50,150,25);
        add(us);
        
        un=new JLabel();
        un.setBounds(220,50,150,25);
        add(un);
        
        JLabel id=new JLabel("Id");
        id.setBounds(30,90,150,25);
        add(id);
        
        tfid=new JTextField();
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);
        
        JLabel n=new JLabel("Number");
        n.setBounds(30,130,150,25);
        add(n);
        
        tn=new JTextField();
        tn.setBounds(220, 130, 150, 25);
        add(tn);
        
        JLabel name=new JLabel("Name");
        name.setBounds(30,170,150,25);
        add(name);
        
        tname=new JLabel();
        tname.setBounds(220, 170, 150, 25);
        add(tname);
        
        JLabel g=new JLabel("Gender");
        g.setBounds(30,210,150,25);
        add(g);
        
        tfg=new JTextField();
        tfg.setBounds(220, 210, 150, 25);
        add(tfg);
        
        JLabel co=new JLabel("Country");
        co.setBounds(30,250,150,25);
        add(co);
        
        tc=new JTextField();
        tc.setBounds(220, 250, 150, 25);
        add(tc);
        
        JLabel a=new JLabel("Address");
        a.setBounds(30,290,150,25);
        add(a);
        
        ta=new JTextField();
        ta.setBounds(220, 290, 150, 25);
        add(ta);
        
        JLabel em=new JLabel("Email");
        em.setBounds(30,330,150,25);
        add(em);
        
        te=new JTextField();
        te.setBounds(220, 330, 150, 25);
        add(te);
        
        JLabel p=new JLabel("Phone Number");
        p.setBounds(30,370,150,25);
        add(p);
        
        tp=new JTextField();
        tp.setBounds(220, 370, 150, 25);
        add(tp);
        
        add=new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(320, 640,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(400,30,320,640);
        add(Image);
        
        try{
           Connect c=new Connect(); 
           ResultSet rs = c.s.executeQuery("select * from customer where username='"+username+"'" );
           while(rs.next()){
               un.setText(rs.getString("username"));
               tname.setText(rs.getString("name"));
               tfid.setText(rs.getString("id"));
               tn.setText(rs.getString("number"));
               tfg.setText(rs.getString("gender"));
               tc.setText(rs.getString("country"));
               ta.setText(rs.getString("address"));
               te.setText(rs.getString("email"));
               tp.setText(rs.getString("phone"));
           } 
        }catch (Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username=un.getText();
            String id=tfid.getText();
            String number = tn.getText();
            String name = tname.getText();
            String gender= tfg.getText();
            String country =tc.getText();
            String address =ta.getText();
            String email=te.getText();
            String phone=tp.getText();
            
            try{
                Connect c=new Connect();
                String query ="update customer set username ='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',email='"+email+"',phone='"+phone+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Detail Updated Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            }else{
            setVisible(false);
        }
            
    }
    
    public static void main(String[] args)
    {
        new UpdateCustomer("Arshi");
    }
}
