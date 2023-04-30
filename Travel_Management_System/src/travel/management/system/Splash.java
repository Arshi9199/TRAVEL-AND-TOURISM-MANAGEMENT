package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable
{ 
    Thread thread;
    Splash()
    {
     //setSize(1200,600);
     //setLocation(200,100);
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash2.jpeg"));
     Image i2 =i1.getImage().getScaledInstance(1000,500, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
     JLabel image =new JLabel(i3);
     add(image);
     setVisible(true);
     thread = new Thread(this);
     thread.start();
    }
    public void run()
    {
      try{ 
         Thread.sleep(7000);
         new Login();
         setVisible(false);
      }catch(Exception e){
          
      }
    }
    public static void main(String[] args)
    {
            Splash frame = new Splash();
            int x=1;
            for(int i=1;i<=500;i++)
            {
                frame.setLocation(600-(x+i)/2,400-(i/4));
                frame.setSize(i*2,i);
                try
                {
                  Thread.sleep(5);
                }catch (Exception e){}
            }
    }
 }
