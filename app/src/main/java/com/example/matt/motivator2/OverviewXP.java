package com.example.matt.motivator2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewXP extends Fragment {

    private TextView lvlTextView;
    private ProgressBar lvlProgressBar;
    private TextView remaning;
    Controller controller = Controller.getController();

    public OverviewXP() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview_xp, container, false);
        return view;

    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //set lvl text
       lvlTextView = view.findViewById(R.id.Lvl);
       lvlTextView.setText(getString(R.string.Lvl)+ " " + controller.getLvl());

       //set progressbar for lvl
       lvlProgressBar = view.findViewById(R.id.lvlProgress);
       lvlProgressBar.setMax(controller.getXpNext());
       lvlProgressBar.setProgress(controller.getXp());

       remaning = view.findViewById(R.id.remaning);
       remaning.setText(controller.getXpRemaning() + " " + getString(R.string.XPRemaning));
    }

    @Override
    public void onResume() {
        super.onResume();
        lvlTextView.setText(getString(R.string.Lvl)+ " " + controller.getLvl());
        lvlProgressBar.setMax(controller.getXpNext());
        lvlProgressBar.setProgress(controller.getXp());
        remaning.setText(controller.getXpRemaning() + " " + getString(R.string.XPRemaning));
    }
}
