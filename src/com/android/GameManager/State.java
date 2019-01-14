package com.android.GameManager;

import com.android.Game.Game;

import java.awt.*;

public abstract class State {

    private static State currentState = null;// call what state that we want <tick>& <render> in game
    public  static  void setState(State state){
        currentState = state;
    }
    public static State getState(){
        return currentState;
    }
    public abstract void tick();
    public abstract void render(Graphics graphics);

    protected Game game;
    public State(Game game) {
        this.game = game;
    }
}
