package com.example.lorensmith.smithdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lorensmith.smithdemo.adapter.ImageViewAdapter;
import com.example.lorensmith.smithdemo.adapter.ViewPagerAdapter;
import com.example.lorensmith.smithdemo.adapter.fragment.SpaceFragment;
import com.example.lorensmith.smithdemo.adapter.fragment.earthFragment;
import com.example.lorensmith.smithdemo.adapter.fragment.galaxyFragment;

import java.util.ArrayList;


/**
 * Created by Loren Smith on 2/20/2017.
 */

public class ListViewScroll extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listView;
    private ArrayList<String> imageList;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.image_view_pager);
        imageList = new ArrayList<String>();
        viewPager =(ViewPager) findViewById(R.id.view_pager);
        fragmentList.add(new earthFragment());
        fragmentList.add(new galaxyFragment());
        fragmentList.add(new SpaceFragment());
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);

        imageLister();
        initialView();
    }

    private void imageLister(){
        imageList.add("Item 1");
        imageList.add("Item 2");
        imageList.add("Item 3");
        imageList.add("Item 4");
        imageList.add("Item 5");
        imageList.add("Item 6");
        imageList.add("Item 7");
        imageList.add("Item 8");
        imageList.add("Item 9");
        imageList.add("Item 10");
        imageList.add("Item 11");
        imageList.add("Item 12");
        imageList.add("Item 13");
        imageList.add("Item 14");
        imageList.add("Item 15");
        imageList.add("Item 16");
        imageList.add("Item 17");
        imageList.add("Item 18");
        imageList.add("Item 19");
        imageList.add("Item 20");

    }
    private void initialView() {

        listView = (ListView) findViewById(R.id.image_list);
        View view = getLayoutInflater().inflate(R.layout.list_view_header, null);
        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);
        ImageViewAdapter listViewAdapter = new ImageViewAdapter(this, imageList);
//        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        Toast.makeText(this,"imageList was clicked at position: "+position, Toast.LENGTH_LONG).show();

//        Log.d("testListViewActivity", String.valueOf(position));
    }
}

