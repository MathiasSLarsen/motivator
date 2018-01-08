package com.example.matt.motivator2;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AchievementsView extends Fragment {

    Controller controller = Controller.getController();

    final int mode = Activity.MODE_PRIVATE;
    final String userPreferences= "UserPreferences";
    ArrayAdapter arrayAdapter;


    String[] goalNameArray = controller.getGoalNameArray();
    ArrayList<Boolean> goalArray = new ArrayList<Boolean>();
    ArrayList<ActiveGoals> activeGoalsArray = new ArrayList<ActiveGoals>();
    ArrayList<Integer> imageArray = controller.getImageArray();
    ArrayList<String> meetGoalArray = new ArrayList<String>();
    ArrayList<Boolean> achiveArray = new ArrayList<Boolean>();
    int xpToNext = controller.getXpNext();

    public AchievementsView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        loadGoals();
        System.out.println("hvor langt er denne ayyay"+ goalArray.size());
        populateMeetGoalArray();
        System.out.println("hvor lang er meetgoal"+meetGoalArray.size());
        populateActiveArrays();
        System.out.println("hvor lang er activearray"+activeGoalsArray.size());

        View view = inflater.inflate(R.layout.fragment_achievements, container, false);


        arrayAdapter = new ArrayAdapter(getActivity(), R.layout.achive_element, R.id.achiveTextView ,activeGoalsArray){
            @Override
            public View getView(final int position, View cachedView, ViewGroup parent){
                View view = super.getView(position, cachedView, parent);

                TextView achiveTextview = view.findViewById(R.id.achiveTextView);
                achiveTextview.setText(activeGoalsArray.get(position).metGoalDecpt);

                final ImageView imageView = view.findViewById(R.id.achiveImageButton);
                imageView.setImageResource(activeGoalsArray.get(position).getImage());

                ProgressBar progressBar = view.findViewById(R.id.achiveProgressBar);
                progressBar.setMax(activeGoalsArray.get(position).getNextWayPoint());
                progressBar.setProgress(activeGoalsArray.get(position).getProgress());


                return view;
            }
        };


        final ListView listview = view.findViewById(R.id.achiveListView);
        listview.setAdapter(arrayAdapter);
        //ViewGroup viewGroup = (ViewGroup) view;
        //viewGroup.addView(listview);
        // Inflate the layout for this fragment
        return view;
    }

    private void loadGoals(){
        for (int i = 0; i<goalNameArray.length;i++){
            SharedPreferences sharedPreferences = getContext().getSharedPreferences(userPreferences,mode);
            goalArray.add(sharedPreferences.getBoolean(goalNameArray[i], false));
        }
    }

    private void populateActiveArrays(){
        for (int i = 0; i<goalArray.size(); i++){
            if (goalArray.get(i)==true){
                activeGoalsArray.add(new ActiveGoals(imageArray.get(i), meetGoalArray.get(i), 2));

            }
        }
    }

    private void populateMeetGoalArray(){
        meetGoalArray.add(getContext().getString(R.string.CandyMeetGoal));
        meetGoalArray.add(getContext().getString(R.string.FoodMeetGoal));
        meetGoalArray.add(getContext().getString(R.string.SodaMeetGoal));
        meetGoalArray.add(getContext().getString(R.string.FastMeetGoal));
        meetGoalArray.add(getContext().getString(R.string.CigeMeetGoal));
        meetGoalArray.add(getContext().getString(R.string.VapeMeetGoal));
        meetGoalArray.add(getContext().getString(R.string.Over100MeetGoal));
        meetGoalArray.add(getContext().getString(R.string.Over200MeetGoal));
        meetGoalArray.add(getContext().getString(R.string.Over300MeetGoal));
        meetGoalArray.add(getContext().getString(R.string.Over400MeetGoal));
        meetGoalArray.add(getContext().getString(R.string.Over500MeetGoal));
        meetGoalArray.add(getContext().getString(R.string.Workout1MeetGoal));
        meetGoalArray.add(getContext().getString(R.string.Workout2MeetGoal));
        meetGoalArray.add(getContext().getString(R.string.Workout3MeetGoal));
        meetGoalArray.add(getContext().getString(R.string.Workout4MeetGoal));
    }



}
