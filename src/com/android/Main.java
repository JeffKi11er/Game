package com.android;

import com.android.Display.Display;
import com.android.Game.Game;
import com.android.mainFrame.Frame;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game game = new Game("Strange Neighborhood",800,600);
        game.start();
    }
}
