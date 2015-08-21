package com.kof.utils;
import com.kof.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashDialog extends Dialog {
    ImageView splashscreen;
    int splashTime = 4000;

    public SplashDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setCancelable(false);;
        getWindow().setWindowAnimations(R.anim.dialog_alpha);
        new Handler().postDelayed(new Runnable() {
        	
            @Override
            public void run() {
                cancel();
            }
        }, splashTime);

    }
}