package electricitybillingsystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MeterInfo extends JFrame implements ActionListener{
    
    JComboBox nmfield,adfield,ctfield,stfield;
    JButton create, back;
    String smeter;
    MeterInfo(String smeter){
        
        this.smeter = smeter;
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);
        panel.setLayout(null);
        add(panel);
        
        JLabel imgl = ImageAdder.scaledImgLabel("resources/hicon1.jpg", 200, 400, Image.SCALE_DEFAULT);
        add(imgl,"West");
        
        JLabel head = new JLabel("Meter Information");
        head.setFont(new Font("TimesRoman",Font.BOLD, 25));
        head.setBounds(145,10,270,30);
        head.setForeground(Color.BLACK);
        panel.add(head);
        
        JLabel nm = new JLabel("Meter Location");
        nm.setFont(new Font("TimesRoman",Font.BOLD, 20));
        nm.setBounds(30,90,200,25);
        nm.setForeground(Color.BLACK);
        panel.add(nm);
        
        nmfield = new JComboBox();
        nmfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        nmfield.setBounds(250,87,250,25);
        nmfield.setForeground(Color.BLACK);
        nmfield.addItem("Outside");
        nmfield.addItem("Inside");
        panel.add(nmfield);
        
        JLabel mtr = new JLabel("MeterNo.");
        mtr.setFont(new Font("TimesRoman",Font.BOLD, 20));
        mtr.setBounds(30,140,200,25);
        mtr.setForeground(Color.BLACK);
        panel.add(mtr);
        
       JLabel mtrfield = new JLabel(smeter);
        mtrfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        mtrfield.setBounds(250,137,250,25);
        mtrfield.setForeground(Color.BLACK);
        panel.add(mtrfield);
        
        JLabel address = new JLabel("Meter Type");
        address.setFont(new Font("TimesRoman",Font.BOLD, 20));
        address.setBounds(30,190,200,25);
        address.setForeground(Color.BLACK);
        panel.add(address);
        
        adfield = new JComboBox();
        adfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        adfield.setBounds(250,187,250,25);
        adfield.setForeground(Color.BLACK);
        adfield.addItem("Standard");
        adfield.addItem("Digital");
        adfield.addItem("Dial");
        adfield.addItem("Economy");
        panel.add(adfield);
        
        JLabel city = new JLabel("Phase code");
        city.setFont(new Font("TimesRoman",Font.BOLD, 20));
        city.setBounds(30,240,200,25);
        city.setForeground(Color.BLACK);
        panel.add(city);
        
        ctfield = new JComboBox();
        ctfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        ctfield.setBounds(250,237,250,25);
        ctfield.setForeground(Color.BLACK);
        ctfield.addItem("011");
        ctfield.addItem("022");
        ctfield.addItem("033");
        ctfield.addItem("044");
        ctfield.addItem("055");
        panel.add(ctfield);
        
        JLabel state = new JLabel("Bill Type");
        state.setFont(new Font("TimesRoman",Font.BOLD, 20));
        state.setBounds(30,290,200,25);
        state.setForeground(Color.BLACK);
        panel.add(state);
        
        stfield = new JComboBox();
        stfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        stfield.setBounds(250,287,250,25);
        stfield.setForeground(Color.BLACK);
        stfield.addItem("Normal");
        stfield.addItem("Industrial");
        stfield.addItem("Smart Meter");
        panel.add(stfield);
        
        JLabel email = new JLabel("Bill Date");
        email.setFont(new Font("TimesRoman",Font.BOLD, 20));
        email.setBounds(30,340,200,25);
        email.setForeground(Color.BLACK);
        panel.add(email);
        
        JLabel emfield = new JLabel("30 Days");
        emfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        emfield.setBounds(250,337,250,25);
        emfield.setForeground(Color.BLACK);
        panel.add(emfield);
        
        JLabel phone = new JLabel("NOTE");
        phone.setFont(new Font("TimesRoman",Font.BOLD, 20));
        phone.setBounds(30,390,200,25);
        phone.setForeground(Color.BLACK);
        panel.add(phone);
        
        JLabel phfield = new JLabel("By default bill is calculated for 30 days");
        phfield.setFont(new Font("TimesRoman",Font.PLAIN, 16));
        phfield.setBounds(180,387,350,25);
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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 420);
        setLocation(375, 190);
        setBounds(340,100,750,600);        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == back){
           setVisible(false);
       }else{
           String smloc = nmfield.getSelectedItem().toString();
           String smtype = adfield.getSelectedItem().toString();
           String spcode = ctfield.getSelectedItem().toString();
           String sbtype = stfield.getSelectedItem().toString();          
           String query = "insert into meterinfo values('"+smeter+"', '"+smloc+"', '"+smtype+"', '"+spcode+"', '"+sbtype+"');";
           try{
               Conn conn = new Conn();
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(this, "MeterInfo Created Successfully");
               setVisible(false);
            }catch(Exception e){
               e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new MeterInfo("");
    }
    
}
