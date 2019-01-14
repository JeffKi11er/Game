package com.android.mainPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements KeyListener, Runnable {
    private Thread thread;//separate each path of programs to make a small program -> have storage to other code
    private boolean running = false;//check whether the program run or not -> start with <false>
    public Panel() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    private void tick(){
        //update everything on the game
    }
    private void render(){
        //draw everything on game
    }
    private void init(){
        //display

        //update all variables, position of object,ect.
        //render(draw) everything to screen
    }// ready to run all graphic of the games
    @Override
    public void run() {//use for call "start" and "stop" method
        init();
        //game loop
        while(running){
            tick();
            render();
        }
        stop();
    }
    public synchronized void start(){//work directly with thread, can not be delayed by other methods
        //with if program is already running,
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try
        {
            thread.join();//close thread properly
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
