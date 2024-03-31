package electricitybillingsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.sql.*;


public class Signup extends JFrame implements ActionListener {
    
        JButton create,back;
        JComboBox cb;
        JTextField meterfield,unfield,nmfield,passfield;
        JLabel meter;

    
    Signup(){
        
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,650,420);
        panel.setBackground(Color.WHITE);
        panel.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY,3),"CreateAccount",TitledBorder.LEADING, TitledBorder.TOP,null,Color.DARK_GRAY));
        add(panel);
        
        ImageIcon tempimg = new ImageIcon(ClassLoader.getSystemResource("resources/signupImage.png"));
        Image image = tempimg.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(image);
        JLabel limg = new JLabel(img);
        limg.setBounds(450,140,200,200);
        panel.add(limg);
        
        JLabel sin = new JLabel("Create Account as");
        sin.setFont(new Font("TimesRoman",Font.BOLD, 16));
        sin.setBounds(40,50,180,18);
        sin.setForeground(Color.DARK_GRAY);
        panel.add(sin); 
        
        cb = new JComboBox();
        cb.setFont(new Font("TimesRoman",Font.PLAIN, 14));
        cb.setBounds(230,50,200,20);
        cb.setForeground(Color.DARK_GRAY);
        cb.addItem("Select");
        cb.addItem("Customer");
        cb.addItem("Admin");
        panel.add(cb);
        
        meter = new JLabel("");
        meter.setFont(new Font("TimesRoman",Font.BOLD, 16));
        meter.setBounds(40,100,180,18);
        meter.setForeground(Color.DARK_GRAY);
        panel.add(meter);
        meterfield = new JTextField();
        meterfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        meterfield.setBounds(230,97,200,25);
        meterfield.setForeground(Color.DARK_GRAY);
        
        
        cb.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
                if(cb.getSelectedItem()== "Admin"){
                    meter.setText("");
                    panel.remove(meterfield);
                    nmfield.setEditable(true);
                }else if(cb.getSelectedItem() == "Customer"){
                    meter.setText("MeterNo");
                    panel.add(meterfield);
                    nmfield.setEditable(false);

                }
            }
        });
        
        meterfield.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe){
                
            }
            @Override
            public void focusLost(FocusEvent fe){
                
                String query = "select CUSTOMERNAME from newcustomer where METERNO='"+meterfield.getText()+"';";
                try{
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery(query);
                    
                    while(rs.next()){
                        nmfield.setText(rs.getString("CUSTOMERNAME"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }
        
        });
        
        JLabel un = new JLabel("Username");
        un.setFont(new Font("TimesRoman",Font.BOLD, 16));
        un.setBounds(40,150,180,18);
        un.setForeground(Color.DARK_GRAY);
        panel.add(un);
        
        unfield = new JTextField();
        unfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        unfield.setBounds(230,147,200,25);
        unfield.setForeground(Color.DARK_GRAY);
        panel.add(unfield);
        
        JLabel nm = new JLabel("Name");
        nm.setFont(new Font("TimesRoman",Font.BOLD, 16));
        nm.setBounds(40,200,180,18);
        nm.setForeground(Color.DARK_GRAY);
        panel.add(nm);
        
        nmfield = new JTextField();
        nmfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        nmfield.setBounds(230,197,200,25);
        nmfield.setForeground(Color.BLACK);
        panel.add(nmfield);
        
        JLabel passlabel = new JLabel("Password");
        passlabel.setFont(new Font("TimesRoman",Font.BOLD, 16));
        passlabel.setBounds(40,250,180,18);
        passlabel.setForeground(Color.DARK_GRAY);
        panel.add(passlabel);
        
        passfield = new JTextField();
        passfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        passfield.setBounds(230,247,200,25);
        passfield.setForeground(Color.DARK_GRAY);
        panel.add(passfield);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway",Font.BOLD,18));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(150,300,120,25);
        back.addActionListener(this);
        panel.add(back);
        
        create = new JButton("Create");
        create.setFont(new Font("Raleway",Font.BOLD,18));
        create.setForeground(Color.WHITE);
        create.setBackground(Color.BLACK);
        create.setBounds(310,300,120,25);
        create.addActionListener(this);
        panel.add(create);
        
                
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setSize(650, 420);
//        setLocation(375, 190);
        setBounds(375,190,650,420);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }else if(ae.getSource() == create){
            String type = cb.getSelectedItem().toString();
            String meternumber = meterfield.getText();
            String user = unfield.getText();
            String name = nmfield.getText();
            String password = passfield.getText();

            try{
                Conn conn = new Conn();
                if(type.equals("Customer")){
                    String query = "update newcustomer set USERNAME='"+user+"',PASSWORD='"+password+"' where METERNO= '"+meternumber+"';";
                    conn.s.executeUpdate(query);
                }else{
                    String query = "insert into adminlogin values('"+user+"', '"+name+"', '"+password+"');";
                    conn.s.executeUpdate(query);
                }
                JOptionPane.showMessageDialog(this, "Account Created Successfull");
                setVisible(false);
                new Login();
            }catch (Exception e){
               e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new Signup();
    }
    
}
