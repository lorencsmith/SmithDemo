package com.example.lorensmith.smithdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.RadioGroup;

import com.example.lorensmith.smithdemo.BaseActivity;
import com.example.lorensmith.smithdemo.DialogActivity;
import com.example.lorensmith.smithdemo.ListViewActivity;
import com.example.lorensmith.smithdemo.R;
import com.example.lorensmith.smithdemo.ViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Loren Smith on 3/8/2017.
 */

public class Quiz4Dialog extends Dialog {
    private int checkedID;
    @BindView(R.id.quiz_rdg)
    RadioGroup radioGroup;

    @OnClick(R.id.quiz_ok)
    public void clickOk(){
        switch(checkedID) {
            case R.id.quiz_rb1:
                toDialog();
                break;
            case R.id.quiz_rb2:
                toLV();
                break;
        }
    }

    private void toLV() {
        BaseActivity okLV = new BaseActivity();
        okLV.toActivity(ListViewActivity.class);
    }

    private void toDialog() {
        BaseActivity okDialog = new BaseActivity();
        okDialog.toActivity(DialogActivity.class);
    }

    @OnClick(R.id.quiz_cancel)
    public void clickCancel(){
        listener.onClickListener();
        BaseActivity cancel = new BaseActivity();
        cancel.toActivity(ViewPagerActivity.class);
    }
    private Quiz4Dialog.Quiz4DialogEventListener listener;

    public interface Quiz4DialogEventListener{
        public void onClickListener();
    }
    public Quiz4Dialog(@NonNull Context context, Quiz4DialogEventListener Quiz4DialogEventListener) {
        super(context, R.style.dialog);
        this.listener = Quiz4DialogEventListener;
    }
            @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz4_dialog);
        ButterKnife.bind(this);
    }
}
