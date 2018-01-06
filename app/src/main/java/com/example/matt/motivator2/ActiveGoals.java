package com.example.matt.motivator2;

/**
 * Created by Matt on 04-01-2018.
 */

public class ActiveGoals {

    int image;
    String metGoalDecpt;

    public ActiveGoals(int image, String metGoalDecpt){
        this.image = image;
        this.metGoalDecpt = metGoalDecpt;
    }

    public String getMetGoalDecpt() {
        return metGoalDecpt;
    }

    public int getImage() {
        return image;
    }
}
