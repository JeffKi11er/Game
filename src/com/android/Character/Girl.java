package com.android.Character;

import com.android.ExtraImage.imageLoading;
import com.android.Game.Game;
import com.android.Manager.Assests;
import study.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Girl extends Creature {
    //private BufferedImage image;
    //private imageLoading loading;
    //private SpriteSheet spiteSheet;

    private Game game;

    public Girl(Game game, float _x, float _y) {
        super(_x, _y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;// need to access keyManager
    }

    @Override
    public void tick() {
        getInput();
        move();
    }
    private void getInput(){
        x_Move = 0;
        y_Move = 0;

        if(game.getKeyManager().up){
            y_Move = -speed;
        }
        if(game.getKeyManager().down){
            y_Move = speed;
        }
        if(game.getKeyManager().left){
            x_Move = -speed;
        }
        if(game.getKeyManager().right){
            x_Move = speed;
        }
    }
    @Override
    public void render(Graphics graphics) {

        //image = imageLoading.loadImage("/map/napa3.png");
        //spiteSheet = new SpriteSheet(image);
        graphics.drawImage(Assests.player,(int) _x, (int) _y,width,height, null);
    }
}
