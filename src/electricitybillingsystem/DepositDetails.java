package electricitybillingsystem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;
import net.proteanit.sql.DbUtils;

public class DepositDetails extends JFrame implements ActionListener{
    
    Choice meternumber, cmonth;
    JButton search,print,clear;
    JTable table;
    DepositDetails(){
        
        setLayout(null);
        
        JLabel meterno = new JLabel("Search by MeterNo.");
        meterno.setFont(new Font("Seriff",Font.BOLD,16));
        meterno.setBounds(25,25,180,20);
        add(meterno);
        
        meternumber = new Choice();
        meternumber.setFont(new Font("TimesRoman",Font.BOLD, 14));
        meternumber.setBounds(210,23,160,20);
        meternumber.setForeground(Color.BLACK);
        meternumber.setBackground(Color.WHITE);
        add(meternumber);
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
        
        JLabel month = new JLabel("Search by Month");
        month.setFont(new Font("Seriff",Font.BOLD,16));
        month.setBounds(400,25,160,20);
        add(month);
        
        cmonth = new Choice();
        cmonth.setFont(new Font("TimesRoman",Font.BOLD, 14));
        cmonth.setBounds(560,23,120,20);
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
        add(cmonth);
        
        search = new JButton("Search");
        search.setFont(new Font("TimesRoman",Font.BOLD,16));
        search.setForeground(Color.WHITE);
        search.setBackground(Color.BLACK);
        search.setBorder(new LineBorder(Color.CYAN,3));
        search.setBounds(25,70,100,25);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setFont(new Font("TimesRoman",Font.BOLD,16));
        print.setForeground(Color.WHITE);
        print.setBackground(Color.BLACK);
        print.setBorder(new LineBorder(Color.CYAN,3));
        print.setBounds(150,70,100,25);
        print.addActionListener(this);
        add(print);
        
        clear = new JButton("Clear");
        clear.setFont(new Font("TimesRoman",Font.BOLD,16));
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        clear.setBorder(new LineBorder(Color.CYAN,3));
        clear.setBounds(275,70,100,25);
        clear.addActionListener(this);
        add(clear);
        
        table = new JTable();
        String query = "select * from bill";
        try{
            Conn conn = new Conn();
           ResultSet rs = conn.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
//        table.setBounds(0,150,700,600);
//        table.setEnabled(false);
//        table.setDefaultEditor(Object.class, null);
//        add(table);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,120,700,600);
        add(sp);
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("Deposit Details");
        setVisible(true);
        setResizable(false);
        setBounds(420,100,700,600);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from bill where METERNO = '"+meternumber.getSelectedItem()+"' and MONTH = '"+cmonth.getSelectedItem()+"';";
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == print){            
            try{
                table.print();
            }catch(PrinterException e){
                e.printStackTrace();
            }
        }else{
            meternumber.select(0);
            cmonth.select(0);
            String query = "select * from bill";
        try{
            Conn conn = new Conn();
           ResultSet rs = conn.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        }
    }
    
    public static void main(String args[]){
        new DepositDetails();
    }
    
}
