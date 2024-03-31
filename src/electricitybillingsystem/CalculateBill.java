package electricitybillingsystem;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.sql.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CalculateBill extends JFrame implements ActionListener{
    
    Choice meternumber,cmonth;
    JTextField unitfield;
    JButton create, back;
    CalculateBill(){
        
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(null);
        add(panel);
        
        JLabel imgl = ImageAdder.scaledImgLabel("resources/hicon2.jpg", 300, 400, Image.SCALE_DEFAULT);
        add(imgl,"West");
        
        JLabel head = new JLabel("Calculate Bill");
        head.setFont(new Font("TimesRoman",Font.BOLD, 25));
        head.setBounds(165,10,250,30);
        head.setForeground(Color.WHITE);
        panel.add(head);
        
        JLabel nm = new JLabel("MeterNo.");
        nm.setFont(new Font("TimesRoman",Font.BOLD, 20));
        nm.setBounds(30,90,200,25);
        nm.setForeground(Color.WHITE);
        panel.add(nm);
        
        meternumber = new Choice();
        meternumber.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        meternumber.setBounds(250,87,250,25);
        meternumber.setForeground(Color.BLACK);
        meternumber.setBackground(Color.WHITE);
        meternumber.addItem("Select");
        try{
            Conn conn = new Conn();
            String query = "select * from newcustomer";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                meternumber.add(rs.getString("METERNO"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        panel.add(meternumber);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("TimesRoman",Font.BOLD, 20));
        name.setBounds(30,140,200,25);
        name.setForeground(Color.WHITE);
        panel.add(name);
        
        JLabel address = new JLabel("Address");
        address.setFont(new Font("TimesRoman",Font.BOLD, 20));
        address.setBounds(30,190,200,25);
        address.setForeground(Color.WHITE);
        panel.add(address);
        
        JLabel namefetch = new JLabel();
        namefetch.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        namefetch.setBounds(250,137,250,25);
        namefetch.setForeground(Color.WHITE);
        panel.add(namefetch);
        
        JLabel adfetched = new JLabel();
        adfetched.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        adfetched.setBounds(250,187,250,25);
        adfetched.setForeground(Color.WHITE);
        panel.add(adfetched);
        
//        meternumber.addItemListener((ItemEvent ie) -> {
//            try{
//                Conn conn = new Conn();
//                String query2 = "select * from newcustomer where METERNO='"+meternumber.getSelectedItem()+"';";
//                ResultSet rs2 = conn.s.executeQuery(query2);
//                while(rs2.next()){
//                    namefetch.setText(rs2.getString("CUSTOMERNAME"));
//                    adfetched.setText(rs2.getString("ADDRESS"));
//                }
//            }catch(Exception e){
//                e.printStackTrace();
//            }
//        });
        
        //ANONYMOUS CLASS
        meternumber.addItemListener(new ItemListener(){
           @Override
           public void itemStateChanged(ItemEvent ie){
               
               try{
                Conn conn = new Conn();
                String query2 = "select * from newcustomer where METERNO='"+meternumber.getSelectedItem()+"';";
                ResultSet rs2 = conn.s.executeQuery(query2);
                while(rs2.next()){
                    namefetch.setText(rs2.getString("CUSTOMERNAME"));
                    adfetched.setText(rs2.getString("ADDRESS"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }               
           }
        });
        
        
        JLabel unit = new JLabel("Unit Consumed");
        unit.setFont(new Font("TimesRoman",Font.BOLD, 20));
        unit.setBounds(30,240,200,25);
        unit.setForeground(Color.WHITE);
        panel.add(unit);
        
        unitfield = new JTextField();
        unitfield.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        unitfield.setBounds(250,237,250,25);
        unitfield.setForeground(Color.BLACK);
        panel.add(unitfield);
        
        JLabel month = new JLabel("Month");
        month.setFont(new Font("TimesRoman",Font.BOLD, 20));
        month.setBounds(30,290,200,25);
        month.setForeground(Color.WHITE);
        panel.add(month);
        
        cmonth = new Choice();
        cmonth.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        cmonth.setBounds(250,287,250,25);
        cmonth.setForeground(Color.BLACK);
        cmonth.setBackground(Color.WHITE);
        cmonth.addItem("Select");
        cmonth.addItem("January");
        cmonth.addItem("February");
        cmonth.addItem("March");
        cmonth.addItem("April");
        cmonth.addItem("May");
        cmonth.addItem("June");
        cmonth.addItem("July");
        cmonth.addItem("August");
        cmonth.addItem("September");
        cmonth.addItem("October");
        cmonth.addItem("November");
        cmonth.addItem("December");
        panel.add(cmonth);
        
        back = new JButton("Cancel");
        back.setFont(new Font("Raleway",Font.BOLD,18));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.CYAN);
        back.setBounds(110,400,120,30);
        back.addActionListener(this);
        panel.add(back);
        
        create = new JButton("Submit");
        create.setFont(new Font("Raleway",Font.BOLD,18));
        create.setForeground(Color.BLACK);
        create.setBackground(Color.CYAN);
        create.setBounds(300,400,120,30);
        create.addActionListener(this);
        panel.add(create);
        
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setBounds(300,100,850,600);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == back){
           setVisible(false);
       }else{
           
           int unit = Integer.parseInt(unitfield.getText());
           int totalbill = 0;
           String dbbill =null;
           int cost_per;
           String query = "select * from tax";
           try{
               Conn conn = new Conn();
               ResultSet rs = conn.s.executeQuery(query);
               while(rs.next()){
                   cost_per = Integer.parseInt(rs.getString("cost_per_unit"));
                   totalbill = unit*cost_per;
                   totalbill += Integer.parseInt(rs.getString("meter_rent"))+Integer.parseInt(rs.getString("service_charge"))+Integer.parseInt(rs.getString("service_tax"))+Integer.parseInt(rs.getString("swacch_bharat_cess"))+Integer.parseInt(rs.getString("fixed_tax"));         
                   dbbill = totalbill + "";
               }
               String query2 = "insert into bill values('"+meternumber.getSelectedItem()+"', '"+cmonth.getSelectedItem()+"', '"+unitfield.getText()+"', '"+dbbill+"', 'Not Paid');";
               conn.s.executeUpdate(query2);
               JOptionPane.showMessageDialog(this, "Calculated bill for\nMeterNo. "+meternumber.getSelectedItem()+" is\nRs "+dbbill);
               setVisible(false);
           }catch(Exception e){
               e.printStackTrace();
           }          
       }
    }
    
    public static void main(String args[]){
        new CalculateBill();
    }
    
}
