package electricitybillingsystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Project extends JFrame implements ActionListener{
    
    String acctype ,meterno;
    Project(String acctype, String meterno){
        
        this.acctype = acctype;
        this.meterno = meterno;
        setLayout(null);

        JLabel limg = ImageAdder.scaledImgLabel("resources/elect2.jpg",1350, 750, Image.SCALE_DEFAULT);
        limg.setBounds(0,0,1350,750);
        add(limg);
        
        JMenuBar mb = new JMenuBar();
        setLayout(new FlowLayout());
        setJMenuBar(mb);
        
        JMenu master = new JMenu("Master");
        master.setForeground(Color.BLUE);
        
        
        JMenuItem newcust = new JMenuItem("New Customer");
        newcust.setFont(new Font("monospaced",Font.PLAIN,12));
        newcust.setMnemonic('N');
        newcust.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        ImageIcon newcustic = ImageAdder.scaledImgIcon("resources/icon1.png", 20, 20, Image.SCALE_DEFAULT);
        newcust.setIcon(newcustic);
        newcust.addActionListener(this);
        master.add(newcust);
        
        JMenuItem custdet = new JMenuItem("Customer Details");
        custdet.setFont(new Font("monospaced",Font.PLAIN,12));
        custdet.setMnemonic('C');
        custdet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        ImageIcon custdetic = ImageAdder.scaledImgIcon("resources/icon2.png", 20, 20, Image.SCALE_DEFAULT);
        custdet.setIcon(custdetic);
        custdet.addActionListener(this);
        master.add(custdet);
        
        JMenuItem depdet = new JMenuItem("Deposit Details");
        depdet.setFont(new Font("monospaced",Font.PLAIN,12));
        depdet.setMnemonic('D');
        depdet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        ImageIcon depdetic = ImageAdder.scaledImgIcon("resources/icon3.png", 20, 20, Image.SCALE_DEFAULT);
        depdet.setIcon(depdetic);
        depdet.addActionListener(this);
        master.add(depdet);
        
        JMenuItem calbill = new JMenuItem("Calculate Bill");
        calbill.setFont(new Font("monospaced",Font.PLAIN,12));
        calbill.setMnemonic('B');
        calbill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        ImageIcon calbillic = ImageAdder.scaledImgIcon("resources/icon5.png", 20, 20, Image.SCALE_DEFAULT);
        calbill.setIcon(calbillic);
        calbill.addActionListener(this);
        master.add(calbill);
        
        JMenu info = new JMenu("Information");
        info.setForeground(Color.GREEN);
        
        
        JMenuItem updatinfo = new JMenuItem("Update Information");
        updatinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        updatinfo.setMnemonic('U');
        updatinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        ImageIcon updatinfoic = ImageAdder.scaledImgIcon("resources/icon4.png", 20, 20, Image.SCALE_DEFAULT);
        updatinfo.setIcon(updatinfoic);
        updatinfo.addActionListener(this);
        info.add(updatinfo);
        
        JMenuItem viewinfo = new JMenuItem("View Information");
        viewinfo.setFont(new Font("monospaced",Font.PLAIN,12));
        viewinfo.setMnemonic('V');
        viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        ImageIcon viewinfoic = ImageAdder.scaledImgIcon("resources/icon6.png", 20, 20, Image.SCALE_DEFAULT);
        viewinfo.setIcon(viewinfoic);
        viewinfo.addActionListener(this);
        info.add(viewinfo);
        
        JMenu user = new JMenu("User");
        user.setForeground(Color.BLUE);
        
        
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,12));
        paybill.setMnemonic('P');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        ImageIcon paybillic = ImageAdder.scaledImgIcon("resources/icon4.png", 20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(paybillic);
        paybill.addActionListener(this);
        user.add(paybill);
        
        JMenuItem billdet = new JMenuItem("Bill Details");
        billdet.setFont(new Font("monospaced",Font.PLAIN,12));
        billdet.setMnemonic('L');
        billdet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        ImageIcon billdetic = ImageAdder.scaledImgIcon("resources/icon6.png", 20, 20, Image.SCALE_DEFAULT);
        billdet.setIcon(billdetic);
        billdet.addActionListener(this);
        user.add(billdet);
        
        JMenu report = new JMenu("Report");
        report.setForeground(Color.GREEN);
       
        
        JMenuItem genbill = new JMenuItem("Generate Bill");
        genbill.setFont(new Font("monospaced",Font.PLAIN,12));
        genbill.setMnemonic('G');
        genbill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        ImageIcon genbillic = ImageAdder.scaledImgIcon("resources/icon5.png", 20, 20, Image.SCALE_DEFAULT);
        genbill.setIcon(genbillic);
        genbill.addActionListener(this);
        report.add(genbill);
        
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,12));
        notepad.setMnemonic('E');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        ImageIcon notepadic = ImageAdder.scaledImgIcon("resources/icon12.png", 20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(notepadic);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,12));
        calculator.setMnemonic('O');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        ImageIcon calculatoric = ImageAdder.scaledImgIcon("resources/icon9.png", 20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(calculatoric);
        calculator.addActionListener(this);
        utility.add(calculator);
        
        JMenu mexit = new JMenu("Exit");
        mexit.setForeground(Color.RED);
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setFont(new Font("monospaced",Font.PLAIN,12));
        exit.setMnemonic('W');
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        ImageIcon exitic = ImageAdder.scaledImgIcon("resources/icon11.png", 20, 20, Image.SCALE_DEFAULT);
        exit.setIcon(exitic);
        exit.addActionListener(this);
        mexit.add(exit);
        
        if(acctype.equals("Admin")){
            mb.add(master);
        }else if(acctype.equals("Customer")){
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }        
        
        mb.add(utility);
        mb.add(mexit);
        
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String act = ae.getActionCommand();
        if(act.equals("New Customer")){
            new NewCustomer();
        }else if(act.equals("Customer Details")){
             new CustomerDetails();
        }else if(act.equals("Deposit Details")){
            new DepositDetails();
        }else if(act.equals("Calculate Bill")){
            new CalculateBill();
        }else if(act.equals("View Information")){
            new ViewInformation(meterno);
        }else if(act.equals("Update Information")){
            new UpdateInfo(meterno);
        }else if(act.equals("Bill Details")){
            new BillDetails(meterno);
        }else if(act.equals("Pay Bill")){
            new PayBill(meterno);
        }else if(act.equals("Generate Bill")){
            new GenerateBill(meterno);
        }else if(act.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("gnome-text-editor");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(act.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("gnome-calculator");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(act.equals("Exit")){
            setVisible(false);
            new Login();
        }
        
    }
    
    public static void main(String args[]){
        new Project("","");
    }    
}
