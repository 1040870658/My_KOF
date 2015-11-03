package com.kof.activity;

import com.kof.BuildConfig;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
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
				.memoryCache(new LruMemoryCache(10*1024))
				.memoryCacheExtraOptions(48, 60)
				.diskCacheSize((int) (Runtime.getRuntime().maxMemory()/5))
				.threadPoolSize(3)
				.denyCacheImageMultipleSizesInMemory()
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
