package com.example.matt.motivator2;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SetGoals extends Fragment {

    ArrayList<String> decriptionArray = new ArrayList<String>();
    ArrayList<Integer> imageArray;
    ArrayList<Boolean> switchArray = new ArrayList<Boolean>();
    String[] goalNameArray;
    //String[] goalNameArray = {"candy","food","soda","fast","cigi","vape","over100","over200","over300","over400","over500","workout","workout2","workout3", "workout4"};
    ArrayAdapter arrayAdapter;
    final int mode = Activity.MODE_PRIVATE;
    final String userPreferences= "UserPreferences";
    //SharedPreferences sharedPreferences = getContext().getSharedPreferences(userPreferences,mode);
    SharedPreferences.Editor prefEditor;
    Controller controller = Controller.getController();


    public SetGoals() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goalNameArray = controller.getGoalNameArray();
        populateDecriptionArray();
        imageArray = controller.getImageArray();
        //populateImageArray();
        loadGoals();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_goals, container, false);


        arrayAdapter = new ArrayAdapter(getActivity(), R.layout.goal_layout, R.id.goalDecriptionText ,decriptionArray){
            @Override
            public View getView(final int position, View cachedView, ViewGroup parent){
                View view = super.getView(position, cachedView, parent);

                final ImageView imageView = view.findViewById(R.id.goalImageView);
                imageView.setImageResource(imageArray.get(position));

                final Switch swich = view.findViewById(R.id.goalSwitch);
                swich.setChecked(switchArray.get(position));


                swich.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        final boolean isChecked = swich.isChecked();
                        if (isChecked) {
                            switchArray.set(position,true);
                        }
                        else{
                            switchArray.set(position,false);
                        }
                    }
                });
                return view;
            }
        };


        final ListView listview = view.findViewById(R.id.listView2);
        listview.setAdapter(arrayAdapter);
        //ViewGroup viewGroup = (ViewGroup) view;
        //viewGroup.addView(listview);
        // Inflate the layout for this fragment
        return view;
    }



    private void populateDecriptionArray(){
        decriptionArray.add(getResources().getString(R.string.CandyDecription));
        decriptionArray.add(getResources().getString(R.string.FoodDecription));
        decriptionArray.add(getResources().getString(R.string.SodaDecription));
        decriptionArray.add(getResources().getString(R.string.FastDecription));
        decriptionArray.add(getResources().getString(R.string.CigiDecription));
        decriptionArray.add(getResources().getString(R.string.VapeDecription));
        decriptionArray.add(getResources().getString(R.string.Over100Decription));
        decriptionArray.add(getResources().getString(R.string.Over200Decription));
        decriptionArray.add(getResources().getString(R.string.Over300Decription));
        decriptionArray.add(getResources().getString(R.string.Over400Decription));
        decriptionArray.add(getResources().getString(R.string.Over500Decription));
        decriptionArray.add(getResources().getString(R.string.WorkoutDecription));
        decriptionArray.add(getResources().getString(R.string.Workout2Decription));
        decriptionArray.add(getResources().getString(R.string.Workout3Decription));
        decriptionArray.add(getResources().getString(R.string.Workout4Decription));
    }

    private void loadGoals(){
        for (int i = 0; i<goalNameArray.length;i++){
            SharedPreferences sharedPreferences = getContext().getSharedPreferences(userPreferences,mode);
            if (sharedPreferences.contains(goalNameArray[i])) {
                switchArray.add(sharedPreferences.getBoolean(goalNameArray[i], false));
            }
            else {
                switchArray.add(false);
            }
        }
    }

    private void saveGoals(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(userPreferences,mode);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i<goalNameArray.length; i++){
            editor.putBoolean(goalNameArray[i],switchArray.get(i));
        }
        editor.commit();
    }

    public void onPause() {
        super.onPause();
        saveGoals();
    }

}
