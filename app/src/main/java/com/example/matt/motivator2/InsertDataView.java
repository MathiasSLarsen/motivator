package com.example.matt.motivator2;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
//import android.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertDataView extends Fragment {
    Controller controller = Controller.getController();

    final int mode = Activity.MODE_PRIVATE;
    final String userPreferences= "UserPreferences";
    ArrayAdapter arrayAdapter;

    int newXP;

    String[] goalNameArray = controller.getGoalNameArray();
    ArrayList<Boolean> goalArray = new ArrayList<Boolean>();
    ArrayList<ActiveGoals> activeGoalsArray = new ArrayList<ActiveGoals>();
    ArrayList<Integer> imageArray = controller.getImageArray();
    ArrayList<String> meetGoalArray = new ArrayList<String>();
    ArrayList<Boolean> achiveArray = new ArrayList<Boolean>();




    public InsertDataView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadGoals();
        System.out.println("hvor langt er denne ayyay"+ goalArray.size());
        populateMeetGoalArray();
        System.out.println("hvor lang er meetgoal"+meetGoalArray.size());
        populateActiveArrays();
        System.out.println("hvor lang er activearray"+activeGoalsArray.size());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_data, container, false);

        arrayAdapter = new ArrayAdapter(getActivity(), R.layout.achievement_input_layout2, R.id.ActivetextView, meetGoalArray) {
            @Override
            public View getView(final int position, View cachedView, ViewGroup parent) {
                View view = super.getView(position, cachedView, parent);

                final ImageView imageView = view.findViewById(R.id.ActiveImageView);
                imageView.setImageResource(activeGoalsArray.get(position).getImage());

                final TextView activeText = view.findViewById(R.id.ActivetextView);
                activeText.setText(activeGoalsArray.get(position).getMetGoalDecpt());

                final CheckBox checkBox = view.findViewById(R.id.ActivecheckBox);
                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        boolean isChecked = checkBox.isChecked();
                        if (isChecked) {
                            achiveArray.add(true);
                        } else {
                            achiveArray.add(false);
                        }
                    }
                });
                return view;
            }
        };


        final ListView listview = view.findViewById(R.id.insertDatalistView);
        listview.setAdapter(arrayAdapter);
        //ViewGroup viewGroup = (ViewGroup) view;
        //viewGroup.addView(listview);
        // Inflate the layout for this fragment
        final EditText kcalInput = view.findViewById(R.id.KcalInput);

        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i =0; i<achiveArray.size(); i++){
                    if (achiveArray.get(i)==true){
                        newXP = newXP +50;
                    }
                    newXP = newXP + Integer.parseInt(kcalInput.getText().toString());
                }
                System.out.println("newxp = "+newXP);
                controller.addXp(newXP);
                System.out.println("totalXp is = " +controller.getXp());
                savexp(controller.getXp());

            }
        });
        return view;
    }

    private void loadGoals(){
        for (int i = 0; i<goalNameArray.length;i++){
            SharedPreferences sharedPreferences = getContext().getSharedPreferences(userPreferences,mode);
            goalArray.add(sharedPreferences.getBoolean(goalNameArray[i], false));
        }
    }

    private void savexp(int xp){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(userPreferences,mode);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("xp", controller.getXp());
        editor.commit();
    }

    private void populateActiveArrays(){
        for (int i = 0; i<goalArray.size(); i++){
            if (goalArray.get(i)==true){
                activeGoalsArray.add(new ActiveGoals(imageArray.get(i), meetGoalArray.get(i)));
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

