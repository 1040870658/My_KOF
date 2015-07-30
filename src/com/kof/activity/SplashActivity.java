package com.kof.activity;

import com.example.kof.R;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashActivity extends Activity{

	private int DELAY_TIME = 5000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		new Handler().postDelayed(new Runnable() {
			private ImageView imageView = (ImageView) findViewById(R.id.iv_splash);
			@Override
			public void run() {
				Intent intent = new Intent(SplashActivity.this,MainActivity.class);
				Animation animation = new AlphaAnimation(1, 0);
				animation.setDuration(1000);
				imageView.startAnimation(animation);
				startActivity(intent);
				SplashActivity.this.finish();
			}
		}, DELAY_TIME);
	}
	
}
