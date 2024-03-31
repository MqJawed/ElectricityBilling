package electricitybillingsystem;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

    JButton login,cancel,signup;
    JTextField unfield;
    JPasswordField pwfield;
    JComboBox cb;
    String meterno;
    Login() {

        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel head = new JLabel("QJ ELECTRIC SUPPLY CORPORATION");
        head.setFont(new Font("Serif",Font.BOLD,28));
        head.setBounds(30,10,600,40);
        head.setForeground(Color.BLUE);
        add(head);
        
        ImageIcon tempimg = new ImageIcon(ClassLoader.getSystemResource("resources/second.jpg"));
        Image image = tempimg.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(image);
        JLabel limg = new JLabel(img);
        limg.setBounds(30,80,200,200);
        add(limg);
        
        JLabel un = new JLabel("Username");
        un.setFont(new Font("TimesRoman",Font.BOLD, 20));
        un.setBounds(250,100,150,20);
        un.setForeground(Color.DARK_GRAY);
        add(un);
        
        unfield = new JTextField();
        unfield.setFont(new Font("TimesRoman",Font.PLAIN, 20));
        unfield.setBounds(400,95,200,30);
        unfield.setForeground(Color.DARK_GRAY);
        add(unfield);
        
        JLabel pw = new JLabel("Password");
        pw.setFont(new Font("TimesRoman",Font.BOLD, 20));
        pw.setBounds(250,150,150,20);
        pw.setForeground(Color.DARK_GRAY);
        add(pw); 

        pwfield = new JPasswordField();
        pwfield.setFont(new Font("TimesRoman",Font.PLAIN, 20));
        pwfield.setBounds(400,145,200,30);
        pwfield.setForeground(Color.DARK_GRAY);
        add(pwfield);

        JLabel lin = new JLabel("Login AS");
        lin.setFont(new Font("TimesRoman",Font.BOLD, 20));
        lin.setBounds(250,200,150,22);
        lin.setForeground(Color.DARK_GRAY);
        add(lin); 

        cb = new JComboBox();
        cb.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        cb.setBounds(400,195,200,25);
        cb.setForeground(Color.DARK_GRAY);
        cb.addItem("Select");
        cb.addItem("Admin");
        cb.addItem("Customer");
        add(cb);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("resources/login.png"));
        Image logimg = i1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(logimg);
        login = new JButton("Login",i2);
        login.setFont(new Font("Raleway",Font.BOLD,18));
        login.setForeground(Color.BLACK);
        login.setBounds(250,250,150,25);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("resources/signup.png"));
        Image sigimg = i11.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(sigimg);
        signup = new JButton("Signup",i22);
        signup.setFont(new Font("Raleway",Font.BOLD,18));
        signup.setForeground(Color.BLACK);
        signup.setBounds(450,250,150,25);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon ican = new ImageIcon(ClassLoader.getSystemResource("resources/cancel.jpg"));
        Image canimg = ican.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel", new ImageIcon(canimg));
        cancel.setFont(new Font("Raleway",Font.BOLD,18));
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(350,300,150,25);
        cancel.addActionListener(this);
        add(cancel);
        
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 420);
        setLocation(375, 190);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            System.exit(0);
        }else if(ae.getSource() == signup){
            new Signup();
        }else if(ae.getSource() == login){
            String sus = unfield.getText();
            String spass = pwfield.getText();
            String slin = cb.getSelectedItem().toString();
            try{
                Conn conn = new Conn();
                String query;
                if(slin.equals("Admin")){
                    query = "select USERNAME, PASSWORD from adminlogin where USERNAME='"+sus+"' and PASSWORD='"+spass+"';";
                    ResultSet rs = conn.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Project(cb.getSelectedItem().toString(),"");
                    }else{
                        JOptionPane.showMessageDialog(this,"Invalid Credintials");
                        unfield.setText("");
                        pwfield.setText("");
                    }                 
                }else{
                    query = "select METERNO, USERNAME, PASSWORD from newcustomer where USERNAME='"+sus+"' and PASSWORD='"+spass+"';";
                    ResultSet rs = conn.s.executeQuery(query);
                    if(rs.next()){
                        meterno = rs.getString("METERNO");
                        setVisible(false);
                        new Project(cb.getSelectedItem().toString(),meterno);
                    }else{
                        JOptionPane.showMessageDialog(this,"Invalid Credintials");
                        unfield.setText("");
                        pwfield.setText("");
                    } 
                    
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new Login();
    }

}
