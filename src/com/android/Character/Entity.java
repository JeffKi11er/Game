package com.android.Character;

import java.awt.*;

public abstract class Entity {
    // public final int Left = 0;
    // public final int Right = 1;
    // public final int Up = 2;
    // public final int Down = 3;
    protected float _x;
    protected float _y;
    //protected int orient;
    //protected int speed = 1;
    protected int width;
    protected int height;


    public Entity(float _x, float _y, int width, int height) {
        this._x = _x;
        this._y = _y;
        this.width = width;
        this.height = height;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);
    /*public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, _x, _y, null);
    }*/

    /*public void move() {
        switch (orient) {
            case Left:
                _x -= speed;
            case Right:
                _x += speed;
            case Up:
                _y -= speed;
            case Down:
                _y += speed;

        }
    }*/
}
