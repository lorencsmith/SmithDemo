package com.example.lorensmith.smithdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.lorensmith.smithdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Loren Smith on 2/15/2017.
 */

public class CustomDialog extends Dialog {

    @OnClick(R.id.dialog_ok)
    public void okClick(){
        listener.onClickListener();
        dismiss();
    }

    private ICustomDialogEventListener listener;

    public interface ICustomDialogEventListener{
        public void onClickListener();
    }

    public CustomDialog(@NonNull Context context, ICustomDialogEventListener ICustomDialogEventListener) {
        super(context, R.style.dialog);
        this.listener = ICustomDialogEventListener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);
    }
}
