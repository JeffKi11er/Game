package study;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GlobalRunning extends JPanel implements Runnable {
    private game game;
    Thread thread;
    public boolean running = false;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private BufferedImage testImage;
    private SpriteSheet imageLoad;
    public void init (){
        game = new game();
        testImage = ImageLoad.loading("/map/bigSkull.png");
        imageLoad = new SpriteSheet(testImage);
    }
    @Override
    public void run() {
        init();
        while (running) {
            tick();
            render();
        }
        stop();
    }

    private void tick() {
    }//update every thing in game

    private void render() {
        bufferStrategy = game.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            game.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0,0,800,600);
        //drawing
        //graphics.drawImage(testImage,0,0,null);
        graphics.drawImage(imageLoad.crop(0,0,60,100),0,0,null);
        //graphics.fillRect(0,0,800,600);
        //end draw
        bufferStrategy.show();
        graphics.dispose();
    }//draw everything in game

    private synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
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
