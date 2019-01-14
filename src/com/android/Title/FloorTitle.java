package com.android.Title;

import com.android.Manager.Assests;

import java.awt.image.BufferedImage;

public class FloorTitle extends Title {
    public FloorTitle( int id) {
        super(Assests.floor, id);
    }

    @Override
    public boolean getOracle() {
        return false;
    }
}
