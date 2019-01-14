package com.android.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;

public class Utils {
    //bunch of function can access any tiles of game
    public static String loadFileLikesString(String path) {
        StringBuilder stringBuilder = new StringBuilder(path);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();//convert everything that we append to string for us to upload file
    }
    public static int  parseInt(String number){
        try{
           return Integer.parseInt(number);
        }catch (NumberFormatException e){//in case input is not number
            return 0;
        }
    }
}
