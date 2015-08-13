package com.kof.activity;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Application;

public class CustomApplication extends Application{

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		ImageLoaderConfiguration configuration = new ImageLoaderConfiguration
				.Builder(this)
				.threadPoolSize(3)
				.build();
		ImageLoader.getInstance().init(configuration);
		super.onCreate();
	}
	
}
