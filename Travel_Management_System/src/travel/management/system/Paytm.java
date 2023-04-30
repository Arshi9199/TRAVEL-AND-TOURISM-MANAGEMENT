
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Paytm extends JFrame implements ActionListener{
    
    Paytm()
    {
     setBounds(500,200,800,600); 
     
     JEditorPane j = new JEditorPane();
        j.setEditable(false);   

        try {
            j.setPage("https://paytm.com/rent-payment");
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load,Error 404</html>");
        } 
        
        JScrollPane scrollPane = new JScrollPane(j);     
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
       // setPreferredSize(new Dimension(800,600));
        
        JButton b=new JButton("Back");
        b.setBounds(610, 20, 80, 40);
        b.addActionListener(this);
        j.add(b);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Payment();
        }
    
     public static void main(String[] args)
    {
        new Paytm();
    }
}
