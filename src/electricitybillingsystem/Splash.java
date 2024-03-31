
package electricitybillingsystem;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Splash extends JFrame implements Runnable{
    
    Thread t;
    Splash(){
        
        setLayout(null);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("resources/elect.jpg"));
        Image im = ic.getImage();
        ImageIcon imc = new ImageIcon(ic.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT));
        JLabel limg = new JLabel(imc);
        limg.setBounds(0,0,900,600);
        add(limg);
        
        setUndecorated(true);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i = 1;i<= 300; i++){
            setSize(3*i, 2*i);
            setLocation(570-i,400-i);
            try{
                Thread.sleep(10);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
        t = new Thread(this);
        t.start();
        
    }
    @Override
    public void run(){
        
        try{
            Thread.sleep(3000);
            setVisible(false);
            new Login();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new Splash();
    }
    
}
