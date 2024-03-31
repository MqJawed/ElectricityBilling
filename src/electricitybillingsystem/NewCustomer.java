package electricitybillingsystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class NewCustomer extends JFrame implements ActionListener{
    
    JTextField nmfield,mtrfield,adfield,ctfield,stfield,emfield,phfield;
    JButton create, back;
    int meterrandom;
    NewCustomer(){
        
        meterrandom = ThreadLocalRandom.current().nextInt(100000,1000000);
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setLayout(null);
        add(panel);
        
        JLabel imgl = ImageAdder.scaledImgLabel("resources/hicon1.jpg", 200, 400, Image.SCALE_DEFAULT);
        add(imgl,"West");
        
        JLabel head = new JLabel("New Customer");
        head.setFont(new Font("TimesRoman",Font.BOLD, 25));
        head.setBounds(165,10,250,30);
        head.setForeground(Color.BLACK);
        panel.add(head);
        
        JLabel nm = new JLabel("Customer Name");
        nm.setFont(new Font("TimesRoman",Font.BOLD, 20));
        nm.setBounds(30,90,200,25);
        nm.setForeground(Color.BLACK);
        panel.add(nm);
        
        nmfield = new JTextField();
        nmfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        nmfield.setBounds(250,87,250,25);
        nmfield.setForeground(Color.BLACK);
        panel.add(nmfield);
        
        JLabel mtr = new JLabel("MeterNo.");
        mtr.setFont(new Font("TimesRoman",Font.BOLD, 20));
        mtr.setBounds(30,140,200,25);
        mtr.setForeground(Color.BLACK);
        panel.add(mtr);
        
        mtrfield = new JTextField();
        mtrfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        mtrfield.setBounds(250,137,250,25);
        mtrfield.setForeground(Color.BLACK);
        mtrfield.setText(meterrandom+"");
        mtrfield.setEditable(false);
        panel.add(mtrfield);
        
        JLabel address = new JLabel("Address");
        address.setFont(new Font("TimesRoman",Font.BOLD, 20));
        address.setBounds(30,190,200,25);
        address.setForeground(Color.BLACK);
        panel.add(address);
        
        adfield = new JTextField();
        adfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        adfield.setBounds(250,187,250,25);
        adfield.setForeground(Color.BLACK);
        panel.add(adfield);
        
        JLabel city = new JLabel("City");
        city.setFont(new Font("TimesRoman",Font.BOLD, 20));
        city.setBounds(30,240,200,25);
        city.setForeground(Color.BLACK);
        panel.add(city);
        
        ctfield = new JTextField();
        ctfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        ctfield.setBounds(250,237,250,25);
        ctfield.setForeground(Color.BLACK);
        panel.add(ctfield);
        
        JLabel state = new JLabel("State");
        state.setFont(new Font("TimesRoman",Font.BOLD, 20));
        state.setBounds(30,290,200,25);
        state.setForeground(Color.BLACK);
        panel.add(state);
        
        stfield = new JTextField();
        stfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        stfield.setBounds(250,287,250,25);
        stfield.setForeground(Color.BLACK);
        panel.add(stfield);
        
        JLabel email = new JLabel("Email ID");
        email.setFont(new Font("TimesRoman",Font.BOLD, 20));
        email.setBounds(30,340,200,25);
        email.setForeground(Color.BLACK);
        panel.add(email);
        
        emfield = new JTextField();
        emfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        emfield.setBounds(250,337,250,25);
        emfield.setForeground(Color.BLACK);
        panel.add(emfield);
        
        JLabel phone = new JLabel("MobileNo.");
        phone.setFont(new Font("TimesRoman",Font.BOLD, 20));
        phone.setBounds(30,390,200,25);
        phone.setForeground(Color.BLACK);
        panel.add(phone);
        
        phfield = new JTextField();
        phfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        phfield.setBounds(250,387,250,25);
        phfield.setForeground(Color.BLACK);
        panel.add(phfield);
        
        back = new JButton("Cancel");
        back.setFont(new Font("Raleway",Font.BOLD,18));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(110,450,120,30);
        back.addActionListener(this);
        panel.add(back);
        
        create = new JButton("Next");
        create.setFont(new Font("Raleway",Font.BOLD,18));
        create.setForeground(Color.WHITE);
        create.setBackground(Color.BLACK);
        create.setBounds(300,450,120,30);
        create.addActionListener(this);
        panel.add(create);
        
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setBounds(340,100,750,600);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == back){
           setVisible(false);
       }else{
           String scust = nmfield.getText();
           String smeter = mtrfield.getText();
           String sadd = adfield.getText();
           String scity = ctfield.getText();
           String sstate = stfield.getText();
           String semail = emfield.getText();
           String smobile = phfield.getText();
           
           String query = "insert into newcustomer values('"+smeter+"', '"+scust+"', '"
+sadd+"', '"+scity+"', '"+sstate+"', '"+semail+"', '"+smobile+"',null,null);";
           try{
               Conn conn = new Conn();
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(this, "NewCustomer Created Successfully");
               setVisible(false);
               new MeterInfo(smeter);
           }catch(Exception e){
               e.printStackTrace();
           }
       }
    }
    
    public static void main(String args[]){
        new NewCustomer();
    }
    
}
