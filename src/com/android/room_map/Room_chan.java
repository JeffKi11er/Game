package com.android.room_map;

import com.android.Title.Title;
import com.android.utils.Utils;

import java.awt.*;

public class Room_chan {
    private int width;
    private int height;
    private int spawnX;
    private int spawnY;

    private int[][] tiles;

    public Room_chan(String path) {
        roomLoad(path);
    }

    //possible to load entire room
    private void roomLoad(String path) {
        /*width = 5;
        height = 5;
        tiles = new int[width][height];//[x_coordinate] [y_coordinate]
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = 0;//titles id*/
        // }
        String file = Utils.loadFileLikesString(path);
        //split up every single number index to convert to number, add to string array that we can access separately
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }


    //get the exact title of arrays
    public Title getTitle(int x, int y) {
        Title title = Title.titles[tiles[x][y]];//Titles.titles just a array 2 dimension, take a position likes in construction
        if (title == null)
            return Title.floorTitle;
        return title;
    }

    public void tick() {

    }

    public void render(Graphics graphics) {
        //loop to load every single titles in titles array
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTitle(x, y).reder(graphics, x * Title.TITLE_WIDTH, y * Title.TITLE_HEIGHT);//need to convert int to pixel,since we render in term of pixels
                //and our tiles are 64x64 pixel in size, title[][] used coordinates not pixel
            }

        }
    }
}

