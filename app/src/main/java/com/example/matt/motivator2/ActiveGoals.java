package com.example.matt.motivator2;

/**
 * Created by Matt on 04-01-2018.
 */

public class ActiveGoals {

    int image;
    String metGoalDecpt;
    int progress;
    int[] wayPoint = {3,5,7,10};

    public ActiveGoals(int image, String metGoalDecpt, int progress){
        this.image = image;
        this.metGoalDecpt = metGoalDecpt;
        this.progress = progress;
    }

    public String getMetGoalDecpt() {
        return metGoalDecpt;
    }

    public int getImage() {
        return image;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getNextWayPoint() {
        int next =0;
        for (int i = 0; i<wayPoint.length; i++){
            if (progress<wayPoint[i]){
                next = wayPoint[i];
                break;
            }
        }
        return next;
    }


}
