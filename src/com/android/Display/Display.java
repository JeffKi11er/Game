package com.android.Display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;

    private int width ;
    private int height ;
    private String title;

    public Display(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);//computer can work just forcus itself

        frame.add(canvas);
        frame.pack();
    }
    public Canvas getCanvas(){
        return canvas;//access canvas to draw by render
    }
    public JFrame getFrame(){return frame;}
}
