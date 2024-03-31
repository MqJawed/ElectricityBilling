package electricitybillingsystem;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class GenerateBill extends JFrame {
    
    Choice cmonth;
    JTextArea area;
    JButton bill;
    String meterno;
    GenerateBill(String meterno){
        
        this.meterno = meterno;
        JPanel panel = new JPanel();
        
        JLabel head = new JLabel("Generate Bill\t");
        head.setFont(new Font("TimesRoman",Font.BOLD, 18));
        head.setSize(150,30);
        head.setForeground(Color.BLACK);
        add(head);
        
        JLabel meternumber = new JLabel(meterno);
        meternumber.setFont(new Font("TimesRoman",Font.BOLD, 16));
        meternumber.setForeground(Color.BLUE);
        meternumber.setSize(100,30);
        add(meternumber);
        
        cmonth = new Choice();
        cmonth.setFont(new Font("TimesRoman",Font.BOLD, 14));
        cmonth.setSize(120,20);
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
        
        area = new JTextArea(50,15);
        area.setText("\n\n\t...........Click on the..........\n\tButton below to generate\n\t Bill For the given month");
        area.setFont(new Font("Senserif",Font.ITALIC,16));
        area.setEditable(false);

        
        JScrollPane pane  = new JScrollPane(area);
        
        bill = new JButton("Generate");
        bill.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent ae){
                
                area.setText("\n            Calcutta Electricity Supply Corporation\n            Bill Generated for the month of "+cmonth.getSelectedItem()+" 2024");
                String query1 = "select * from newcustomer where METERNO = '"+meterno+"';";
                String query2 = "select * from meterinfo where METERNO = '"+meterno+"';";
                String query3 = "select * from tax";
                String query4 = "select * from bill where METERNO = '"+meterno+"' and MONTH = '"+cmonth.getSelectedItem()+"';";                
                try{
                    
                    Conn conn = new Conn();
                    ResultSet rs = conn.s.executeQuery(query1);
                    while(rs.next()){
                        area.append("\n\n\tMeterNo :\t"+rs.getString("METERNO"));                        
                        area.append("\n\tCustName :\t"+rs.getString("CUSTOMERNAME"));
                        area.append("\n\tAddress :\t"+rs.getString("ADDRESS"));
                        area.append("\n\tCity :\t"+rs.getString("CITY"));
                        area.append("\n\tState :\t"+rs.getString("STATE"));
                        area.append("\n\tEmail :\t"+rs.getString("EMAIL"));
                        area.append("\n\tPhone :\t"+rs.getString("MOBILE"));
                        area.append("\n---------------------------------------------------------------------------------");
                        
                    }
                    rs = conn.s.executeQuery(query2);
                    while(rs.next()){
                        area.append("\n\n\tMeterNo :\t"+rs.getString("METERNO"));                        
                        area.append("\n\tMeterLoc :\t"+rs.getString("METERLOCATION"));
                        area.append("\n\tMeterType:\t"+rs.getString("METERTYPE"));
                        area.append("\n\tPhaseCode :\t"+rs.getString("PHASECODE"));
                        area.append("\n\tBillType :\t"+rs.getString("BILLTYPE"));
                        area.append("\n---------------------------------------------------------------------------------");
                        
                    }
                    rs = conn.s.executeQuery(query3);
                    while(rs.next()){
                        area.append("\n\n\tUnitCharge :\t"+rs.getString("cost_per_unit"));                        
                        area.append("\n\tMeterRent :\t"+rs.getString("meter_rent"));
                        area.append("\n\tService :\t"+rs.getString("service_charge"));
                        area.append("\n\tSeviceTax :\t"+rs.getString("service_tax"));
                        area.append("\n\tCess :\t"+rs.getString("swacch_bharat_cess"));
                        area.append("\n\tFixedTax:\t"+rs.getString("fixed_tax"));
                        area.append("\n---------------------------------------------------------------------------------");
                        
                    }
                    rs = conn.s.executeQuery(query4);
                    while(rs.next()){
                        area.append("\n\n\tMonth :\t"+cmonth.getSelectedItem());                        
                        area.append("\n\tUnits :\t"+rs.getString("UNITS"));
                        area.append("\n\tTotalCharge :\t"+rs.getString("TOTALBILL"));
                        area.append("\n\tPaymentStat :\t"+rs.getString("STATUS"));
                        area.append("\n---------------------------------------------------------------------------------");
                        area.append("\n\n\tTotalPayable:\t"+rs.getString("TOTALBILL"));                        
                    }                  
                    bill.setEnabled(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        panel.add(head);
        panel.add(meternumber);
        panel.add(cmonth);
        add(panel,"North"); 
        
        add(pane,"Center");
        add(bill,"South");
        
        setVisible(true);
        setResizable(false);
        setSize(500,700);
        setLocation(500,30);        
        
    }
    public static void main(String args[]){
        new GenerateBill("");
    }
}
