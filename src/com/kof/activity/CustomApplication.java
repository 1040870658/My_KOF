package com.kof.activity;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import android.app.Application;
import android.content.Context;

public class CustomApplication extends Application{

	 private RefWatcher refWatcher;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		ImageLoaderConfiguration configuration = new ImageLoaderConfiguration
				.Builder(this)
				.threadPoolSize(3)
				.build();
		ImageLoader.getInstance().init(configuration);
		refWatcher = LeakCanary.install(this);
		super.onCreate();
	}
	public static RefWatcher getRefWatcher(Context context) {
        CustomApplication application = (CustomApplication) context
                .getApplicationContext();
        return application.refWatcher;
    }
}
