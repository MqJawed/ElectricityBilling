package electricitybillingsystem;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class ImageAdder {
    
    public static JLabel scaledImgLabel(String resourcename,int width, int height, int scaling){
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource(resourcename));
        Image img = ic.getImage().getScaledInstance(width, height, scaling);
        ImageIcon newic = new ImageIcon(img);
        JLabel imgLabel = new JLabel(newic);
        return imgLabel;
   
    }

    public static ImageIcon scaledImgIcon(String resourcename,int width, int height, int scaling){
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource(resourcename));
        Image img = ic.getImage().getScaledInstance(width, height, scaling);
        ImageIcon newic = new ImageIcon(img);
        return newic;
   
    } 
}
