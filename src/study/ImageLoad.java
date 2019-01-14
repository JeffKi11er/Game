package study;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageLoad {
    public static BufferedImage loading(String path){
        try
        {
            return ImageIO.read(ImageLoad.class.getResource(path));
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
