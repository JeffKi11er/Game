package com.android.SpriteSheet;

import java.awt.image.BufferedImage;

public class Sheet_Sprite {
    private BufferedImage sheet;

    public Sheet_Sprite(BufferedImage sheet) {
        this.sheet = sheet;
    }
    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x,y,width,height);
    }
}
