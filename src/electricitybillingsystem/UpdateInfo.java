package electricitybillingsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class UpdateInfo extends JFrame implements ActionListener{
    String meterno;
    JButton back, create;
    JTextField nmfield,adfield,ctfield,stfield,userfield,passfield,emfield,phfield;
    JPasswordField opassfield;
    UpdateInfo(String meterno){
        
        this.meterno = meterno;
        setLayout(null);
        
        JLabel viewcust2 = ImageAdder.scaledImgLabel("resources/update.png", 200,250,Image.SCALE_DEFAULT);
        viewcust2.setBounds(500,220,200,250);
        add(viewcust2);
        
        JLabel head = new JLabel("Update Information");
        head.setFont(new Font("TimesRoman",Font.BOLD, 25));
        head.setBounds(200,10,350,30);
        head.setForeground(Color.BLACK);
        add(head);
        
        JLabel nm = new JLabel("Name :");
        nm.setFont(new Font("TimesRoman",Font.BOLD, 20));
        nm.setBounds(30,70,100,25);
        nm.setForeground(Color.BLACK);
        add(nm);
        
        nmfield = new JTextField();
        nmfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        nmfield.setBounds(150,70,210,25);
        nmfield.setForeground(Color.BLUE);
        add(nmfield);
        
        JLabel mtr = new JLabel("MeterNo.");
        mtr.setFont(new Font("TimesRoman",Font.BOLD, 20));
        mtr.setBounds(30,120,200,25);
        mtr.setForeground(Color.BLACK);
        add(mtr);
        
        JLabel mtrfield = new JLabel(meterno);
        mtrfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        mtrfield.setBounds(150,120,100,25);
        mtrfield.setForeground(Color.BLUE);
        add(mtrfield);
        
        JLabel address = new JLabel("Address");
        address.setFont(new Font("TimesRoman",Font.BOLD, 20));
        address.setBounds(30,170,200,25);
        address.setForeground(Color.BLACK);
        add(address);
        
        adfield = new JTextField();
        adfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        adfield.setBounds(150,170,580,25);
        adfield.setForeground(Color.BLUE);
        add(adfield);
        
        JLabel city = new JLabel("City");
        city.setFont(new Font("TimesRoman",Font.BOLD, 20));
        city.setBounds(30,220,100,25);
        city.setForeground(Color.BLACK);
        add(city);
        
        ctfield = new JTextField();
        ctfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        ctfield.setBounds(150,220,250,25);
        ctfield.setForeground(Color.BLUE);
        add(ctfield);
        
        JLabel state = new JLabel("State");
        state.setFont(new Font("TimesRoman",Font.BOLD, 20));
        state.setBounds(30,270,100,25);
        state.setForeground(Color.BLACK);
        add(state);
        
        stfield = new JTextField();
        stfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        stfield.setBounds(150,270,250,25);
        stfield.setForeground(Color.BLUE);
        add(stfield);
        
        JLabel user = new JLabel("Username");
        user.setFont(new Font("TimesRoman",Font.BOLD, 20));
        user.setBounds(30,320,150,25);
        user.setForeground(Color.BLACK);
        add(user);
        
        userfield = new JTextField();
        userfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        userfield.setBounds(250,320,250,25);
        userfield.setForeground(Color.BLUE);
        add(userfield);
        
        JLabel pass = new JLabel("New Password");
        pass.setFont(new Font("TimesRoman",Font.BOLD, 20));
        pass.setBounds(30,370,200,25);
        pass.setForeground(Color.BLACK);
        add(pass);
        
        passfield = new JTextField();
        passfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        passfield.setBounds(250,370,250,25);
        passfield.setForeground(Color.BLUE);
        add(passfield);
        
         JLabel opass = new JLabel("Old Password");
        opass.setFont(new Font("TimesRoman",Font.BOLD, 20));
        opass.setBounds(30,420,200,25);
        opass.setForeground(Color.BLACK);
        add(opass);
        
        opassfield = new JPasswordField();
        opassfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        opassfield.setBounds(250,420,250,25);
        opassfield.setForeground(Color.BLUE);
        add(opassfield);
        
        JLabel email = new JLabel("Email ID:");
        email.setFont(new Font("TimesRoman",Font.BOLD, 20));
        email.setBounds(380,70,110,25);
        email.setForeground(Color.BLACK);
        add(email);
        
        emfield = new JTextField();
        emfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        emfield.setBounds(500,70,230,25);
        emfield.setForeground(Color.BLUE);
        add(emfield);
        
        JLabel phone = new JLabel("MobileNo.");
        phone.setFont(new Font("TimesRoman",Font.BOLD, 20));
        phone.setBounds(380,120,120,25);
        phone.setForeground(Color.BLACK);
        add(phone);
        
        phfield = new JTextField();
        phfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        phfield.setBounds(500,120,230,25);
        phfield.setForeground(Color.BLUE);
        add(phfield);
        
        back = new JButton("Cancel");
        back.setFont(new Font("Raleway",Font.BOLD,18));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBorder(new LineBorder(Color.WHITE ,2));
        back.setBounds(50,470,120,30);
        back.addActionListener(this);
        add(back);
        
        create = new JButton("Submit");
        create.setFont(new Font("Raleway",Font.BOLD,18));
        create.setForeground(Color.WHITE);
        create.setBackground(Color.BLACK);
        create.setBorder(new LineBorder(Color.WHITE ,2));
        create.setBounds(250,470,120,30);
        create.addActionListener(this);
        add(create);
        
        getContentPane().setBackground(Color.CYAN);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setBounds(375,80,750,600);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == back){
            
            setVisible(false);
            
        }else{
            
            String oldpass = null;
            String query = "select PASSWORD from newcustomer where METERNO='"+meterno+"';";
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while(rs.next()){
                    oldpass = rs.getString("PASSWORD");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            if(oldpass.equals(opassfield.getText())){
                String query2 = "update newcustomer set CUSTOMERNAME = '"+nmfield.getText()+"', ADDRESS='"+adfield.getText()+"', CITY='"+ctfield.getText()+"', STATE='"+stfield.getText()+"', EMAIL='"+emfield.getText()+"', MOBILE='"+phfield.getText()+"', USERNAME='"+userfield.getText()+"', PASSWORD='"+passfield.getText()+"' where METERNO = '"+meterno+"';";
                try{
                    Conn conn = new Conn();
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(this, "Successfull");
                    setVisible(false);
                    new ViewInformation(meterno);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
            
        }
        
    }
    
    public static void main(String args[]){
        new UpdateInfo("");
    }
    
}
