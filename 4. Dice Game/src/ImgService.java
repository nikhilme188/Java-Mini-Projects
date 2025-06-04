import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImgService {

    public static JLabel loadImage(String filePath){
        BufferedImage image;
        JLabel imageCointainer;
        try {
            InputStream inputStream=ImgService.class.getResourceAsStream(filePath);
            image=ImageIO.read(inputStream);
            imageCointainer=new JLabel(new ImageIcon(image));
            return imageCointainer;
        } catch (IOException e) {
            System.out.println("Error:"+e);
            return null;
        }
    }

    public static void updateImage(JLabel imageCointainer,String filePath){
        BufferedImage image;
        try {
            InputStream inputStream=ImgService.class.getResourceAsStream(filePath);
            image=ImageIO.read(inputStream);
            imageCointainer.setIcon(new ImageIcon(image));
        } catch (IOException e) {
            System.out.println("Error:"+e);
        }
    }
    
}
