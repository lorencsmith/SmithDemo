package com.example.lorensmith.smithdemo.adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * Created by Loren Smith on 2/1/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter implements ListAdapter {

    private ArrayList<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    public void setContent(ArrayList<Fragment> fragmentList){
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position){
        return fragmentList.get(position);
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getCount(){
        return fragmentList.size();
    }
    @Override
    public CharSequence getPageTitle(int position){
        return fragmentList.get(position).getClass().getName();
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position){
        return super.instantiateItem(container, position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
