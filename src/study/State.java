package study;

import java.awt.*;

public abstract class State {
    public State(){

    }
    public abstract void render(Graphics graphics);
    public abstract void tick();
}
