package com.android.Title;

import com.android.Manager.Assests;

import java.awt.image.BufferedImage;

public class PictureTitle extends Title {
    public PictureTitle( int id) {
        super(Assests.picture, id);
    }

    @Override
    public boolean getOracle() {
        return false;
    }
}
