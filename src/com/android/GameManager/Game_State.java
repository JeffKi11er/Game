package com.android.GameManager;

import com.android.Character.Girl;
import com.android.ExtraImage.imageLoading;
import com.android.Game.Game;
import com.android.Title.Title;
import com.android.room_map.Room_chan;
import study.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Game_State extends State {
    //private BufferedImage image;
    private Room_chan room_chan;
    private imageLoading loading;
    private SpriteSheet spiteSheet;
    protected Girl girl;

    public Game_State(Game game) {
        super(game);
        girl = new Girl(game, 100, 100);
        room_chan = new Room_chan("gameBreakBrick/src/text/map.txt");
    }

    @Override
    public void tick() {
        room_chan.tick();
        girl.tick();
    }
    @Override
    public void render(Graphics graphics) {
        //image = imageLoading.loadImage("/map/fonHospitalOperate.png");
        //spiteSheet = new SpriteSheet(image);
        //graphics.drawImage(spiteSheet.crop(0,0,30,45),0,0,null);
        //graphics.drawImage(image,0,0,null);
        room_chan.render(graphics);
        girl.render(graphics);
        Title.titles[0].reder(graphics, 0, 0);
    }
}
