package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener
{
    JLabel un,tname;
    JComboBox comboid;
    JTextField tn,tc,ta,tp,te;
    JRadioButton rm,rf;
    JButton add,back;
    
    AddCustomer(String username)
    {
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel us=new JLabel("Username");
        us.setBounds(30,50,150,25);
        add(us);
        
        un=new JLabel();
        un.setBounds(220,50,150,25);
        add(un);
        
        JLabel id=new JLabel("Id");
        id.setBounds(30,90,150,25);
        add(id);
        
        comboid= new JComboBox(new String[] {"Passport","Aadhar Card","Pan Card","Ration Card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
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
        
        rm=new JRadioButton("Male");
        rm.setBounds(220,210,70,25);
        rm.setBackground(Color.WHITE);
        add(rm);
        
        rf=new JRadioButton("Female");
        rf.setBounds(300,210,70,25);
        rf.setBackground(Color.WHITE);
        add(rf);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rm);
        bg.add(rf);
        
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
        
        add=new JButton("Add");
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(400,40,450,420);
        add(Image);
        
        try{
           Connect c=new Connect(); 
           ResultSet rs = c.s.executeQuery("select * from account where username='"+username+"'" );
           while(rs.next()){
               un.setText(rs.getString("username"));
               tname.setText(rs.getString("name"));
           } 
        }catch (Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username=un.getText();
            String id=(String)comboid.getSelectedItem();
            String number = tn.getText();
            String name = tname.getText();
            String gender= null;
            if(rm.isSelected()){
                gender="Male";
            }else{
                gender="Female";
            }
            String country =tc.getText();
            String address =ta.getText();
            String email=te.getText();
            String phone=tp.getText();
            
            try{
                Connect c=new Connect();
                String query ="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+email+"','"+phone+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Detail Added Successfully");
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
        new AddCustomer("Arshi");
    }
}
