package com.example.matt.motivator2;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    final int mode = Activity.MODE_PRIVATE;
    final String userPreferences= "UserPreferences";

    Controller controller = Controller.getController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadXp();

        /*
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        */

            // Create the adapter that will return a fragment for each of the three
            // primary sections of the activity.
            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

            // Set up the ViewPager with the sections adapter.
            viewPager = (ViewPager) findViewById(R.id.viewPager);
            viewPager.setAdapter(mSectionsPagerAdapter);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));

            mSectionsPagerAdapter.notifyDataSetChanged();


    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    InsertDataView insertData = new InsertDataView();
                    return insertData;
                case 1:
                    OverviewMainFragment overview_main = new OverviewMainFragment();
                    return overview_main;
                case 2:
                    AchievementsView achievements = new AchievementsView();
                    return achievements;
                case 3:
                    SetGoals setGoals = new SetGoals();
                    return setGoals;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Indtast";
                case 1:
                    return "Overblik";
                case 2:
                    return "AchievementsView";
                case 3:
                    return "SetGols";

            }
            return null;
        }


    }

    private void loadXp(){
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(userPreferences,mode);
           controller.setXp(sharedPreferences.getInt("xp", 0));

    }
}
