package com.example.matt.motivator2;

import static java.lang.Math.sqrt;

/**
 * Created by Matt on 23-09-2017.
 */

public class LvlSys {
    private int lvl;
    private int xp;
    private int xp_next;

    public LvlSys(){

    }

    private void ClacLvl(int xp){
        lvl = (int) sqrt((xp-250)/100);
    }

    public int getLvl(){
        ClacLvl(xp);
        return lvl;
    }

    private void CalcNextLvl(int lvl){
        xp_next = 100*lvl*lvl+250;
    }

    public int getXpNext(){
        CalcNextLvl(lvl+1);
        return xp_next;
    }

    public int getXpRemaning(){
       int remaning = getXpNext() - xp;
        return remaning;
    }

    public void addXp(int newXp){
        xp = xp+newXp;
    }

    public int getXp(){
        return xp;
    }

    public void setXp(int xp){
        this.xp = xp;
    }
}
