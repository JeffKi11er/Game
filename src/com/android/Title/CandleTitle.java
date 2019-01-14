package com.android.Title;

import com.android.Manager.Assests;

import java.awt.image.BufferedImage;

public class CandleTitle extends Title {
    public CandleTitle( int id) {
        super(Assests.candle, id);
    }

    @Override
    public boolean getOracle() {
        return true;
    }
}
