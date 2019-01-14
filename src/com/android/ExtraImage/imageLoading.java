package com.android.ExtraImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class imageLoading {
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(imageLoading.class.getResource(path));//load image
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);//call it or image get useless
        }
        return null;// obediently return to null
    }
}
