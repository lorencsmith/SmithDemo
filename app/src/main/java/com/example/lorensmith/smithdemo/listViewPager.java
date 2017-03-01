package com.example.lorensmith.smithdemo;

/**
 * Created by Loren Smith on 2/22/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.lorensmith.smithdemo.adapter.ViewPagerAdapter;
import com.example.lorensmith.smithdemo.adapter.fragment.SpaceFragment;
import com.example.lorensmith.smithdemo.adapter.fragment.earthFragment;
import com.example.lorensmith.smithdemo.adapter.fragment.galaxyFragment;

import java.util.ArrayList;

//import android.widget.TabLayout;

public class listViewPager extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        initial();
    }

    private void initial() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        fragmentList.add(new earthFragment());
        fragmentList.add(new galaxyFragment());
        fragmentList.add(new SpaceFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}