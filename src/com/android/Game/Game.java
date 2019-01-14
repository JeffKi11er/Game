package com.android.Game;

import com.android.Display.Display;
import com.android.ExtraImage.imageLoading;
import com.android.GameManager.Game_State;
import com.android.GameManager.Menu_State;
import com.android.GameManager.State;
import com.android.Manager.Assests;
import com.android.Manager.KeyManager;
import com.android.SpriteSheet.Sheet_Sprite;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {
    private boolean running = false;
    private Display display;
    private Thread thread;
    public String title = "Stranger neighborhood";
    public int width, height;
    //int x = 0;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    private State game_state;
    private State menu;

    //private BufferedImage testImage;
    private BufferedImage sprite_sheet;
    private Sheet_Sprite sheet_sprite;

    //Input keyManager
    private KeyManager keyManager;
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void init() {
        //testImage = imageLoading.loadImage("/map/bigSkull.png");//all file sources location must be use "/" below it
        //sprite_sheet = imageLoading.loadImage("/map/napa3.png");
        //sprite_sheet = imageLoading.loadImage("/map/d74q7tj-9576a9d8-a788-48e6-85aa-c4d63a4e8dbc.png");
        //sheet_sprite = new Sheet_Sprite(sprite_sheet);
        display = new Display(width, height, title);
        display.getFrame().addKeyListener(keyManager);
        Assests.init();

        game_state = new Game_State(this);//pass game object into state
        menu = new Menu_State(this);
        State.setState(game_state);
    }

    private void render() {
        //whatever it run, the same over and over again
        bufferStrategy = display.getCanvas().getBufferStrategy();//tell window to paint into screen
        if (bufferStrategy == null) {//buffer is hidden computer screen-> can't see move to other buffer and to actual screen
            display.getCanvas().createBufferStrategy(3);//don't do too much rather than 3
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        //before draw -> clear
        graphics.clearRect(0, 0, width, height);
        //draw
        //graphics.drawImage(sprite_sheet,0,0,null);
        //graphics.drawImage(sheet_sprite.crop(0, 0, 60, 100), x, 0, null);
        //graphics.drawImage(sheet_sprite.crop(0, 0, 30, 45), x, 0, null);
        graphics.drawImage(Assests.picture,50,60,null);
        if(State.getState() != null){
            State.getState().render(graphics);
        }
        ///coordinate system
        //end_draw
        bufferStrategy.show();
        graphics.dispose();
    }

    private void tick() {
      //  x += 1;
        keyManager.tick();//tick game class first

        if(State.getState() != null){
            State.getState().tick();
        }
    }

    @Override
    public void run() {
        init();
        //sprite move the same speed in every computer
        int fps = 60;//frame per seconds: tell how many time every seconds we want to <tick>&<render> to run/60*every single seconds
        double timePerTick = 1000000000 / fps;//1 billion nano seconds per seconds//maximum amount of time allowed to have to <tick>,<render> to archive 60* every seconds
        double delta = 0;//amount time we have until we call <tick>&<render>again
        long now;
        long lastTime = System.nanoTime();//return amount of time in nano seconds that computer are writing, return current time but nano seconds
        //create a frame counter see if this doing correctly, show how many times <tick> <render> are calling per seconds
        long timer = 0;//time get in 1 second
        int tick = 0;//how many <tick>,<render> called
        while (running) {
            now = System.nanoTime();//set current time of computer in nano seconds
            delta += (now - lastTime) / timePerTick;//now - lastTime (amount of time since we last call [now] divide to maximum amount of time allowed to have to <tick>,<render>)
            //add [delta] essentially how much time we have until we have to call <tick>,<render> again // tell computer will and will not call <tick> & <render>
            timer += now - lastTime;//add the amount of time that loop past, called last print
            lastTime = now;
            //check after we call to take <render>
            if (delta >= 1) {// have to take <tick> <render> to archive 60 seconds
                tick();
                render();
                tick++;
                delta--;
            }
            if (timer >= 1000000000) {
                //how many tick do after it last ruin
                System.out.println("Ticks and Frames: " + tick);
                tick = 0;
                timer = 0;
            }
        }
        stop();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
