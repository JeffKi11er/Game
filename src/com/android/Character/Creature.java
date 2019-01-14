package com.android.Character;

import java.awt.*;

public abstract class Creature extends Entity {
    public static final int DEFAULT_HEALTH = 10;
    protected int health;
    protected float speed;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 60;
    public static final int DEFAULT_CREATURE_HEIGHT = 90;
    protected float x_Move;
    protected float y_Move;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getX_Move() {
        return x_Move;
    }

    public void setX_Move(float x_Move) {
        this.x_Move = x_Move;
    }

    public float getY_Move() {
        return y_Move;
    }

    public void setY_Move(float y_Move) {
        this.y_Move = y_Move;
    }

    public Creature(float _x, float _y, int width, int height) {
        super(_x, _y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        x_Move = 0;
        y_Move = 0;
    }

    //take
    public void move() {
        _x += x_Move;
        _y += y_Move;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics graphics) {

    }
}
