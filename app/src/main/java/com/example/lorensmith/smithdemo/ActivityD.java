package com.example.lorensmith.smithdemo;

import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Loren Smith on 3/1/2017.
 */

public class ActivityD extends BaseActivity {
    @OnClick(R.id.toA)
    public void toA(){
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }
    @OnClick(R.id.toB)
    public void toB(){
        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }
    @OnClick(R.id.toC)
    public void toC(){
        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }
    @OnClick(R.id.toA)
    public void toD(){
        Intent intent = new Intent(this, ActivityD.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_d);
        ButterKnife.bind(this);
    }
}
