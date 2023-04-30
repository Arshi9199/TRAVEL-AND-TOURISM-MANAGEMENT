package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener
{
    String username;
    JButton ap,vp,up,cp,bp,vb,c,n,a,p,vh,d,bh;
    Dashboard(String username)
    {
        this.username=username;
        //setBounds(0,0,1600,900);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1920,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Icon = new JLabel(i3);
        Icon.setBounds(5,0,70,70);
        p1.add(Icon);
         
        
        JLabel h = new JLabel("Dashboard");
        h.setBounds(80,10,300,40);
        h.setForeground(Color.WHITE);
        h.setFont(new Font("Times New Roman",Font.BOLD,30));
        p1.add(h);
        
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,320,1000);
        add(p2);
         
        
        ap = new JButton("Add Personal Details");
        ap.setBounds(0,0,320,50);
        ap.setBackground(new Color(0,0,102));
        ap.setForeground(Color.WHITE);
        ap.setFont(new Font("Times New Roman",Font.BOLD,20));
        ap.setMargin(new Insets(0,0,0,60));
        ap.addActionListener(this);
        p2.add(ap);
        
        up = new JButton("Update Personal Details");
        up.setBounds(0,50,320,50);
        up.setBackground(new Color(0,0,102));
        up.setForeground(Color.WHITE);
        up.setFont(new Font("Times New Roman",Font.BOLD,20));
        up.setMargin(new Insets(0,0,0,30));
        up.addActionListener(this);
        p2.add(up);
        
        vp = new JButton("View Details");
        vp.setBounds(0,100,320,50);
        vp.setBackground(new Color(0,0,102));
        vp.setForeground(Color.WHITE);
        vp.setFont(new Font("Times New Roman",Font.BOLD,20));
        vp.setMargin(new Insets(0,0,0,130));
        vp.addActionListener(this);
        p2.add(vp);
        
        /*JButton dp = new JButton("Delete Personal Details");
        dp.setBounds(0,150,320,50);
        dp.setBackground(new Color(0,0,102));
        dp.setForeground(Color.WHITE);
        dp.setFont(new Font("Times New Roman",Font.BOLD,20));
        dp.setMargin(new Insets(0,0,0,40));
        p2.add(dp);*/
        
        cp = new JButton("Check Package");
        cp.setBounds(0,150,320,50);
        cp.setBackground(new Color(0,0,102));
        cp.setForeground(Color.WHITE);
        cp.setFont(new Font("Times New Roman",Font.BOLD,20));
        cp.setMargin(new Insets(0,0,0,110));
        cp.addActionListener(this);
        p2.add(cp);
        
        bp = new JButton("Book Package");
        bp.setBounds(0,200,320,50);
        bp.setBackground(new Color(0,0,102));
        bp.setForeground(Color.WHITE);
        bp.setFont(new Font("Times New Roman",Font.BOLD,20));
        bp.setMargin(new Insets(0,0,0,120));
        bp.addActionListener(this);
        p2.add(bp);
        
        vb = new JButton("View Package Booking");
        vb.setBounds(0,250,320,50);
        vb.setBackground(new Color(0,0,102));
        vb.setForeground(Color.WHITE);
        vb.setFont(new Font("Times New Roman",Font.BOLD,20));
        vb.setMargin(new Insets(0,0,0,50));
        vb.addActionListener(this);
        p2.add(vb);
        
        vh = new JButton("View Hotels");
        vh.setBounds(0,300,320,50);
        vh.setBackground(new Color(0,0,102));
        vh.setForeground(Color.WHITE);
        vh.setFont(new Font("Times New Roman",Font.BOLD,20));
        vh.setMargin(new Insets(0,0,0,140));
        vh.addActionListener(this);
        p2.add(vh);
        
        bh = new JButton("Book Hotels");
        bh.setBounds(0,350,320,50);
        bh.setBackground(new Color(0,0,102));
        bh.setForeground(Color.WHITE);
        bh.setFont(new Font("Times New Roman",Font.BOLD,20));
        bh.setMargin(new Insets(0,0,0,135));
        bh.addActionListener(this);
        p2.add(bh);
        
        /*JButton vbh = new JButton("View Booked Hotel");
        vbh.setBounds(0,450,320,50);
        vbh.setBackground(new Color(0,0,102));
        vbh.setForeground(Color.WHITE);
        vbh.setFont(new Font("Times New Roman",Font.BOLD,20));
        vbh.setMargin(new Insets(0,0,0,75));
        p2.add(vbh);*/
        
        d = new JButton("Destination");
        d.setBounds(0,400,320,50);
        d.setBackground(new Color(0,0,102));
        d.setForeground(Color.WHITE);
        d.setFont(new Font("Times New Roman",Font.BOLD,20));
        d.setMargin(new Insets(0,0,0,140));
        d.addActionListener(this);
        p2.add(d);
        
        p = new JButton("Payment");
        p.setBounds(0,450,320,50);
        p.setBackground(new Color(0,0,102));
        p.setForeground(Color.WHITE);
        p.setFont(new Font("Times New Roman",Font.BOLD,20));
        p.setMargin(new Insets(0,0,0,160));
        p.addActionListener(this);
        p2.add(p);
        
        c = new JButton("Calculator");
        c.setBounds(0,500,320,50);
        c.setBackground(new Color(0,0,102));
        c.setForeground(Color.WHITE);
        c.setFont(new Font("Times New Roman",Font.BOLD,20));
        c.setMargin(new Insets(0,0,0,150));
        c.addActionListener(this);
        p2.add(c);
        
        n = new JButton("Notepad");
        n.setBounds(0,550,320,50);
        n.setBackground(new Color(0,0,102));
        n.setForeground(Color.WHITE);
        n.setFont(new Font("Times New Roman",Font.BOLD,20));
        n.setMargin(new Insets(0,0,0,165));
        n.addActionListener(this);
        p2.add(n);
        
        a = new JButton("About");
        a.setBounds(0,600,320,50);
        a.setBackground(new Color(0,0,102));
        a.setForeground(Color.WHITE);
        a.setFont(new Font("Times New Roman",Font.BOLD,20));
        a.setMargin(new Insets(0,0,0,185));
        a.addActionListener(this);
        p2.add(a);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(310,0,1650,1000);
        add(image);
        
        JLabel t = new JLabel("ARABS Travel And Tourism Management");
        t.setBounds(400,70,1200,70);
        t.setForeground(Color.WHITE);
        t.setFont(new Font("Times New Roman",Font.BOLD,50));
        image.add(t);
        
        
       
   
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==ap){
            new AddCustomer(username);
        }else if(ae.getSource()==vp){
            new ViewCustomer(username);
        }else if(ae.getSource()==up){
            new UpdateCustomer(username);
        }else if(ae.getSource()==cp){
            new CheckPackage();
        }else if(ae.getSource()==bp){
            new BookPackage(username);
        }else if(ae.getSource()==vb){
            new ViewPackage(username);
        }else if(ae.getSource()==c){
           try{
             Runtime.getRuntime().exec("calc.exe");
           }catch (Exception e){
               e.printStackTrace();
           } 
        }else if(ae.getSource()==n){
           try{
             Runtime.getRuntime().exec("notepad.exe");
           }catch (Exception e){
               e.printStackTrace();
           }  
        }else if(ae.getSource()==a){
            new About();
        }else if(ae.getSource()==p){
           new Payment(); 
        }else if(ae.getSource()==vh){
           new CheckHotel(); 
        }else if(ae.getSource()==d){
           new Destination(); 
        }else if(ae.getSource()==bh){
           new BookHotel(username); 
        }
    }
    
    public static void main(String[] args)
    {
        new Dashboard("");
    }


    
}
