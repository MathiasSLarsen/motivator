package com.example.matt.motivator2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Matt on 07-11-2017.
 */

public class Controller {

    private LvlSys lvlSys = new LvlSys();
    private static final Controller controller = new Controller();

    ArrayList<Integer> imageArray = new ArrayList<Integer>();
    String[] goalNameArray = {"candy","food","soda","fast","cigi","vape","over100","over200","over300","over400","over500","workout","workout2","workout3", "workout4"};




    private Controller(){
        //populateMeetGoalArray();
    }

    public static Controller getController(){
        return controller;
    }


    public int getLvl(){
        return lvlSys.getLvl();
    }
    public int getXpNext(){
        return lvlSys.getXpNext();
    }
    public int getXp(){
        return lvlSys.getXp();
    }
    public int getXpRemaning(){
        return lvlSys.getXpRemaning();
    }
    public void addXp (int xp){
        lvlSys.addXp(xp);
    }

    private void populateImageArray(){
        imageArray.add(R.drawable.candy);
        imageArray.add(R.drawable.food);
        imageArray.add(R.drawable.soda);
        imageArray.add(R.drawable.faste);
        imageArray.add(R.drawable.cigi);
        imageArray.add(R.drawable.vape);
        imageArray.add(R.drawable.over100);
        imageArray.add(R.drawable.over200);
        imageArray.add(R.drawable.over300);
        imageArray.add(R.drawable.over400);
        imageArray.add(R.drawable.over500);
        imageArray.add(R.drawable.workout);
        imageArray.add(R.drawable.workout2);
        imageArray.add(R.drawable.workout3);
        imageArray.add(R.drawable.workout4);
    }

    public ArrayList getImageArray(){
        populateImageArray();
        return imageArray;
    }

    public String[] getGoalNameArray(){
            return goalNameArray;
    }


//    private void populateDecriptionArray(){
//        decriptionArray.add(Resources.getSystem().getString(R.string.CandyDecription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.FoodDecription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.SodaDecription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.FastDecription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.CigiDecription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.VapeDecription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.Over100Decription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.Over200Decription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.Over300Decription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.Over400Decription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.Over500Decription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.WorkoutDecription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.Workout2Decription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.Workout3Decription));
//        decriptionArray.add(Resources.getSystem().getString(R.string.Workout4Decription));
//    }
//    public ArrayList getDecriptionArray(){
//        populateDecriptionArray();
//        return decriptionArray;
//    }
}


