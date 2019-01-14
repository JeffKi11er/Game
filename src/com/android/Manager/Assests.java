package com.android.Manager;

import com.android.ExtraImage.imageLoading;
import study.ImageLoad;
import study.SpriteSheet;

import java.awt.image.BufferedImage;

public class Assests {

    public static final int width = 70, height = 68;
    public static final int Width = 60, Height = 90;

    public static BufferedImage player, table, picture, ghost, desk, door, kichen, television, tolet, eyes,candle,floor;
    //load anything in the game and only call once
    //public static BufferedImage
    public static void init(){
        SpriteSheet spriteSheet3 = new SpriteSheet(imageLoading.loadImage("/map/ezgif.com-crop.png"));
        SpriteSheet spriteSheet = new SpriteSheet(imageLoading.loadImage("/map/hallKartina_strip6.png"));
        SpriteSheet spriteSheet1 = new SpriteSheet(imageLoading.loadImage("/map/napa3.png"));
        SpriteSheet spriteSheet2 = new SpriteSheet(imageLoading.loadImage("/map/svecha_strip6.png"));
        player = spriteSheet1.crop(0,0,Width,Height);
        candle = spriteSheet2.crop(32,0,35,58);
        floor = spriteSheet3.crop(0,0,width,height);

    }
}
