package electricitybillingsystem;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class BillDetails extends JFrame{
    
    String meterno;
    BillDetails(String meterno){
        this.meterno = meterno;
        setLayout(null);
        
        JTable table = new JTable();
        String query = "select * from bill where METERNO='"+meterno+"';";
        try{
            Conn conn = new Conn();
           ResultSet rs = conn.s.executeQuery(query);
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,700,600);
        add(sp);
        
        getContentPane().setBackground(Color.WHITE);
        setTitle("Bill Details");
        setVisible(true);
        setResizable(false);
        setBounds(420,100,700,600);
    }
    
    public static void main(String args[]){
        new BillDetails("");
    }
    
}
