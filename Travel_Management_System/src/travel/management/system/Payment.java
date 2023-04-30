
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {
    JButton p,b;
    
    Payment()
    {
        
        setLayout(null);
        setBounds(600, 220, 800, 600);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);
      
        p=new JButton("Pay");
        p.setBounds(520, 0, 80, 40);
        p.addActionListener(this);
        image.add(p);
      
        b=new JButton("Back");
        b.setBounds(420, 0, 80, 40);
        b.addActionListener(this);
        image.add(b);
      
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==p){
          setVisible(false);
          new Paytm();
        }else{
        setVisible(false);
        }
    }
     
    public static void main(String[] args)
    {
        new Payment();
    }
}
