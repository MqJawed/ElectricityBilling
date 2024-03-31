package electricitybillingsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import net.proteanit.sql.DbUtils;

public class ViewInformation extends JFrame {
    String meterno;
    ViewInformation(String meterno){
        
        this.meterno = meterno;
        setLayout(null);
        
        JLabel viewcust = ImageAdder.scaledImgLabel("resources/viewcustomer.jpg", 650,300,Image.SCALE_DEFAULT);
        viewcust.setBounds(50,300,650,300);
        add(viewcust);
        
        JLabel head = new JLabel("Cusotomer Information");
        head.setFont(new Font("TimesRoman",Font.BOLD, 25));
        head.setBounds(200,10,350,30);
        head.setForeground(Color.BLACK);
        add(head);
        
        JLabel nm = new JLabel("Name :");
        nm.setFont(new Font("TimesRoman",Font.BOLD, 20));
        nm.setBounds(30,70,100,25);
        nm.setForeground(Color.BLACK);
        add(nm);
        
        JLabel nmfield = new JLabel("name");
        nmfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        nmfield.setBounds(150,70,200,25);
        nmfield.setForeground(Color.BLUE);
        add(nmfield);
        
        JLabel mtr = new JLabel("MeterNo.");
        mtr.setFont(new Font("TimesRoman",Font.BOLD, 20));
        mtr.setBounds(30,120,200,25);
        mtr.setForeground(Color.BLACK);
        add(mtr);
        
        JLabel mtrfield = new JLabel("meter");
        mtrfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        mtrfield.setBounds(150,120,100,25);
        mtrfield.setForeground(Color.BLUE);
        add(mtrfield);
        
        JLabel address = new JLabel("Address");
        address.setFont(new Font("TimesRoman",Font.BOLD, 20));
        address.setBounds(30,170,200,25);
        address.setForeground(Color.BLACK);
        add(address);
        
        JLabel adfield = new JLabel("add");
        adfield.setFont(new Font("Ralway",Font.PLAIN, 18));
        adfield.setBounds(150,170,300,25);
        adfield.setForeground(Color.BLUE);
        add(adfield);
        
        JLabel city = new JLabel("City");
        city.setFont(new Font("TimesRoman",Font.BOLD, 20));
        city.setBounds(30,220,100,25);
        city.setForeground(Color.BLACK);
        add(city);
        
        JLabel ctfield = new JLabel("city");
        ctfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        ctfield.setBounds(150,220,100,25);
        ctfield.setForeground(Color.BLUE);
        add(ctfield);
        
        JLabel state = new JLabel("State");
        state.setFont(new Font("TimesRoman",Font.BOLD, 20));
        state.setBounds(30,270,100,25);
        state.setForeground(Color.BLACK);
        add(state);
        
        JLabel stfield = new JLabel("state");
        stfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        stfield.setBounds(150,270,100,25);
        stfield.setForeground(Color.BLUE);
        add(stfield);
        
        JLabel email = new JLabel("Email ID:");
        email.setFont(new Font("TimesRoman",Font.BOLD, 20));
        email.setBounds(380,70,110,25);
        email.setForeground(Color.BLACK);
        add(email);
        
        JLabel emfield = new JLabel("hewllo@gmail.com");
        emfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        emfield.setBounds(500,70,250,25);
        emfield.setForeground(Color.BLUE);
        add(emfield);
        
        JLabel phone = new JLabel("MobileNo.");
        phone.setFont(new Font("TimesRoman",Font.BOLD, 20));
        phone.setBounds(380,120,120,25);
        phone.setForeground(Color.BLACK);
        add(phone);
        
        JLabel phfield = new JLabel("9789897897");
        phfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        phfield.setBounds(500,120,200,25);
        phfield.setForeground(Color.BLUE);
        add(phfield);
        
        String query = "select METERNO,CUSTOMERNAME,ADDRESS,CITY,STATE,EMAIL,MOBILE from newcustomer where METERNO='"+meterno+"';";
        try{
            Conn conn = new Conn();
           ResultSet rs = conn.s.executeQuery(query);
           while(rs.next()){
               nmfield.setText(rs.getString("CUSTOMERNAME"));
               mtrfield.setText(rs.getString("METERNO"));
               adfield.setText(rs.getString("ADDRESS"));
               ctfield.setText(rs.getString("CITY"));
               stfield.setText(rs.getString("STATE"));
               emfield.setText(rs.getString("EMAIL"));
               phfield.setText(rs.getString("MOBILE"));

           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setResizable(false);
        setBounds(375,80,750,620);
        
    }
    
    public static void main(String args[]){
        new ViewInformation("");
    }
    
}
