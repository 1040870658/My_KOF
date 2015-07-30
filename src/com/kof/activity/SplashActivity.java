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
		Animation animation = new AlphaAnimation(0, 1);
		ImageView imageView = (ImageView) findViewById(R.id.iv_splash);
		imageView.setAnimation(animation);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				Intent intent = new Intent(SplashActivity.this,MainActivity.class);
				startActivity(intent);
				SplashActivity.this.finish();
			}
		}, DELAY_TIME);
	}
	
}
