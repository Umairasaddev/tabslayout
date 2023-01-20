package com.example.tabslayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager viewPager;

    private ExploreFragment exploreFragment;
    private FlightFragment flightFragment;
    private TravelFragment travelFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        exploreFragment = new ExploreFragment();
        travelFragment = new TravelFragment();
        flightFragment = new FlightFragment();

        //first things is
        tabLayout.setupWithViewPager(viewPager);

    ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
//we need to add all fragments to view pager


        viewPagerAdapter.addFragment(exploreFragment,"Explore");
        viewPagerAdapter.addFragment(flightFragment,"Flights");
        viewPagerAdapter.addFragment(travelFragment,"Travel");
        viewPager.setAdapter(viewPagerAdapter);


        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_explore_24);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_flight_24);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_card_travel_24);

    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments  = new ArrayList<>();// so we store the fragments in this list and
        private List<String> fragmentsTitle = new ArrayList<>();//the titles will be stored in this list


        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }
        public void addFragment(Fragment fragment,String title){
            fragments.add(fragment);
            fragmentsTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);//if we get the utem and pass the position it will return the fragment
        }

        @Override
        public int getCount() {
            return fragments.size();//dynamically  jitni fragments add hon g yeh un ka size get kar ly gaa
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentsTitle.get(position);
        }
    }

}