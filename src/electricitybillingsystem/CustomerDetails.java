package electricitybillingsystem;
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

public class CustomerDetails extends JFrame implements ActionListener{
    
    JButton print;
    JTable table;
    CustomerDetails(){
        
        print = new JButton("Print");
        print.setFont(new Font("TimesRoman",Font.BOLD,16));
        print.setForeground(Color.WHITE);
        print.setBackground(Color.BLACK);
        print.setBorder(new LineBorder(Color.CYAN,3));
        print.addActionListener(this);
        add(print,"South");
        
        table = new JTable();
        String query = "select METERNO,CUSTOMERNAME,ADDRESS,CITY,STATE,EMAIL,MOBILE from newcustomer";
        try{
            Conn conn = new Conn();
           ResultSet rs = conn.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table);
        add(sp);
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("Customer Details");
        setVisible(true);
        setResizable(false);
        setBounds(120,100,1200,600);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
       try{
                table.print();
            }catch(PrinterException e){
                e.printStackTrace();
            }
        }
    
    public static void main(String args[]){
        new CustomerDetails();
    } 
}
