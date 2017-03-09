package com.example.lorensmith.smithdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lorensmith.smithdemo.bean.Book;
import com.example.lorensmith.smithdemo.dialog.Quiz4Dialog;
import com.example.lorensmith.smithdemo.util.UtilLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements View.OnTouchListener {

    private ImageButton bt1;
    private ImageButton bt2;
    private ImageButton bt3;
    private ImageButton bt4;
    private GestureDetector mGestureDetector;
    private int checkedID;

    @BindView(R.id.main_fl)
    FrameLayout fl;

    @OnClick(R.id.bt2)
    public void button2Click() {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivityForResult(intent, 2);

    }

    @OnClick(R.id.bt4)
    public void buttonClick4() {
        Intent intent = new Intent(this, ListViewScroll.class);
        startActivity(intent);
    }

    @OnClick(R.id.orange_button)
    public void orangeClick() {
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }

    @OnClick(R.id.main_timer)
    public void timeClick() {
        toActivity(TimerActivity.class);
    }

    @OnClick(R.id.main_animation)
    public void toAnimation() {
        toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.main_animator)
    public void toAnimator() {
        toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.Quiz4)
    public void toQuiz4() { quiz4Dialog();}

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
    }

    private void initialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt2 = (ImageButton) findViewById(R.id.bt2);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt4 = (ImageButton) findViewById(R.id.bt4);
    }

    private void initialListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Loren");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button2 was clicked", Toast.LENGTH_LONG).show();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                startActivityForResult(intent, 3);
//                    Intent intent = new Intent(v.getContext(), ListViewActivity.class);
//                    startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                String message = data.getStringExtra("message");
                toastShort("From ViewPager");
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            default:
        }
    }

    public void onClick(View v) {
//                Toast.makeText(v.getContext(),"Button2 was clicked", Toast.LENGTH_LONG).show();
        toastLong("Button 2 was clicked");
        UtilLog.logD("testD", "Toast");
//                Log.d("testD", "Toast");
//                Log.e("testE", "Toast");
//                Log.i("testI", "Toast");
//                Log.v("testV", "Toast");
//                Log.w("testW", "Toast");

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return mGestureDetector.onTouchEvent(event);
    }
    /*onDown ->onShowPress->onLongPress*/
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        public boolean onDown(MotionEvent e) {
//            UtilLog.logD("MyGesture", "onDown");
            toastShort("onDownPress");
            return true;
        }
        public void onShowPress(MotionEvent e){
//            UtilLog.logD("MyGesture", "onShowPress");
            toastShort("onShowPress");
        }
        public void onLongPress(MotionEvent e){
//            UtilLog.logD("MyGesture", "onLongPress");
            toastShort("onLongPress");
        }
        public boolean onSingleTapUp(MotionEvent e){
//            UtilLog.logD("MyGesture","onSingleTap");
            toastShort("onSingleTapUp");
            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e){
//            UtilLog.logD("MyGesture","onSingleTapConfirmed");
            toastShort("onSingleTapConfirmed");
            return true;
        }
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
            UtilLog.logD("MyGesture", "onScroll:" +(e2.getX()-e1.getX())+ "  " + distanceX );
            toastShort("onScroll");
            return true;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
//            UtilLog.logD("MyGesture","onFling");
            toastShort("onFling");
            return true;
        }
        public boolean onDoubleTap(MotionEvent e){
//            UtilLog.logD("MyGesture","onDoubleTap");
            toastShort("onDoubleTap");
            return true;
        }
        public boolean onDoubleTapEvent(MotionEvent e){
//            UtilLog.logD("MyGesture","onDoubleTapEvent");
            toastShort("onDoubleTapEvent");
            return true;
        }
    }
    private void quiz4Dialog() {
        final Quiz4Dialog dialog = new Quiz4Dialog(this, new Quiz4Dialog.Quiz4DialogEventListener() {

            @Override
            public void onClickListener () {
                Intent intent = new Intent();
                intent.putExtra("message", "Dialog");
                setResult(RESULT_OK, intent);

            }
        });
        dialog.show();
    }
}

