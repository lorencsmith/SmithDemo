package com.example.lorensmith.smithdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lorensmith.smithdemo.util.UtilLog;


public class MainActivity extends BaseActivity {

    private ImageButton bt1;
    private ImageButton bt2;
    private ImageButton bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        intialListener();
    }
    private void initialView(){
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt2 = (ImageButton) findViewById(R.id.bt2);
        bt3 = (ImageButton) findViewById(R.id.bt3);
    }

    private void intialListener(){
        bt1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(v.getContext(),"Button2 was clicked", Toast.LENGTH_LONG).show();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                    toActivity(ListViewActivity.class);
//                    Intent intent = new Intent(v.getContext(), ListViewActivity.class);
//                    startActivity(intent);

            }
        });
    }
            public void onClick(View v){
//                Toast.makeText(v.getContext(),"Button2 was clicked", Toast.LENGTH_LONG).show();
                toastLong("Button 2 was clicked");
                UtilLog.logD("testD", "Toast");
                Log.d("testD", "Toast");
//                Log.e("testE", "Toast");
//                Log.i("testI", "Toast");
//                Log.v("testV", "Toast");
//                Log.w("testW", "Toast");

            }


}


