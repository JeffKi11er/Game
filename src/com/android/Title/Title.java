package com.android.Title;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Title {
    public static Title[] titles = new Title[256];
    public static Title floorTitle = new FloorTitle(0);
    public static Title candleTitle = new CandleTitle(1);
    public static Title pictureTitle = new PictureTitle(2);
    protected BufferedImage texture;
    protected final int id;
    public static final int TITLE_WIDTH = 30;
    public static final int TITLE_HEIGHT = 30;

    public Title(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;
        titles[id] = this;//all title array has index are called
    }

    public boolean getOracle(){
        return false;
    }
    public void tick(){

    }
    public void reder(Graphics graphics, int x, int y){
        graphics.drawImage(texture,x,y,TITLE_WIDTH,TITLE_HEIGHT,null);
    }

    public int getId() {
        return id;
    }
}
