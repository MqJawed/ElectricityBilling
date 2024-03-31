package electricitybillingsystem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class PayBill extends JFrame implements ActionListener{
    
    String meterno;
    JButton back,create;
    Choice cmonth;
    PayBill(String meterno){
        this.meterno = meterno;
        setLayout(null);
        
        JLabel billpay = ImageAdder.scaledImgLabel("resources/bill.png", 500,400,Image.SCALE_DEFAULT);
        billpay.setBounds(450,80,350,350);
        add(billpay);
        
        JLabel head = new JLabel("Pay Bill");
        head.setFont(new Font("TimesRoman",Font.BOLD, 25));
        head.setBounds(200,10,350,30);
        head.setForeground(Color.BLACK);
        add(head);
        
        JLabel nm = new JLabel("Name :");
        nm.setFont(new Font("TimesRoman",Font.BOLD, 20));
        nm.setBounds(30,70,100,25);
        nm.setForeground(Color.BLACK);
        add(nm);
        
        JLabel nmfield = new JLabel();
        nmfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        nmfield.setBounds(250,70,200,25);
        nmfield.setForeground(Color.BLUE);
        add(nmfield);
        
        JLabel mtr = new JLabel("MeterNo.");
        mtr.setFont(new Font("TimesRoman",Font.BOLD, 20));
        mtr.setBounds(30,120,200,25);
        mtr.setForeground(Color.BLACK);
        add(mtr);
        
        JLabel mtrfield = new JLabel();
        mtrfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        mtrfield.setBounds(250,120,100,25);
        mtrfield.setForeground(Color.BLUE);
        add(mtrfield);
        
        JLabel month = new JLabel("Month");
        month.setFont(new Font("TimesRoman",Font.BOLD, 20));
        month.setBounds(30,170,100,25);
        month.setForeground(Color.BLACK);
        add(month);
        
        cmonth = new Choice();
        cmonth.setFont(new Font("TimesRoman",Font.PLAIN, 18));
        cmonth.setBounds(250,170,160,25);
        cmonth.setForeground(Color.BLUE);
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
        add(cmonth);
        
        JLabel unit = new JLabel("Unit");
        unit.setFont(new Font("TimesRoman",Font.BOLD, 20));
        unit.setBounds(30,220,100,25);
        unit.setForeground(Color.BLACK);
        add(unit);
        
        JLabel unitfield = new JLabel();
        unitfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        unitfield.setBounds(250,220,100,25);
        unitfield.setForeground(Color.BLUE);
        add(unitfield);
        
        JLabel tb = new JLabel("Total Bill");
        tb.setFont(new Font("TimesRoman",Font.BOLD, 20));
        tb.setBounds(30,270,150,25);
        tb.setForeground(Color.BLACK);
        add(tb);
        
        JLabel tbfield = new JLabel();
        tbfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        tbfield.setBounds(250,270,100,25);
        tbfield.setForeground(Color.BLUE);
        add(tbfield);
        
        JLabel status = new JLabel("Status");
        status.setFont(new Font("TimesRoman",Font.BOLD, 20));
        status.setBounds(30,320,200,25);
        status.setForeground(Color.BLACK);
        add(status);
        
        JLabel stfield = new JLabel();
        stfield.setFont(new Font("Raleway",Font.PLAIN, 18));
        stfield.setBounds(250,320,100,25);
        stfield.setForeground(Color.BLUE);
        add(stfield);
        
        String query = "select METERNO,CUSTOMERNAME from newcustomer where METERNO='"+meterno+"';";
        try{
            Conn conn = new Conn();
           ResultSet rs = conn.s.executeQuery(query);
           while(rs.next()){
               nmfield.setText(rs.getString("CUSTOMERNAME"));
               mtrfield.setText(rs.getString("METERNO"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cmonth.addItemListener(new ItemListener(){
            
            @Override
            public void itemStateChanged(ItemEvent ie){
                String query = "select UNITS,TOTALBILL,STATUS from bill where METERNO='"+meterno+"' and MONTH='"+cmonth.getSelectedItem()+"';";
                try{
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery(query);
                    while(rs.next()){
                               unitfield.setText(rs.getString("UNITS"));
                               tbfield.setText(rs.getString("TOTALBILL"));
                               stfield.setText(rs.getString("STATUS"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        back = new JButton("Cancel");
        back.setFont(new Font("Raleway",Font.BOLD,18));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBorder(new LineBorder(Color.WHITE ,2));
        back.setBounds(90,400,120,30);
        back.addActionListener(this);
        add(back);
        
        create = new JButton("Pay");
        create.setFont(new Font("Raleway",Font.BOLD,18));
        create.setForeground(Color.WHITE);
        create.setBackground(Color.BLACK);
        create.setBorder(new LineBorder(Color.WHITE ,2));
        create.setBounds(290,400,120,30);
        create.addActionListener(this);
        add(create);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(350,130,800,500);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);            
        }else{
            String check = null;
            String query0 = "select STATUS from bill where METERNO = '"+meterno+"' and MONTH = '"+cmonth.getSelectedItem()+"';";
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query0);
                while(rs.next()){
                    check = rs.getString("STATUS");
                }
                if(check.equals("Not Paid")){
                    String query = "update bill set STATUS = 'Paid' where METERNO = '"+meterno+"' and MONTH = '"+cmonth.getSelectedItem()+"';";    
                    try{
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(this, "Bill Paid Successfull");
                        setVisible(false);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Already Paid");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        new PayBill("");
    }
}
