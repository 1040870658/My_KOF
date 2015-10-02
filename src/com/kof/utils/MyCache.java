package com.kof.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class MyCache implements ImageCache{
	
	private LruCache<String, Bitmap> mCache;
	public MyCache(){
		int maxSize = 10 * 1024 * 1024;
		mCache = new LruCache<String, Bitmap>(maxSize){
			@Override
			protected int sizeOf(String key, Bitmap bitmap) {  
				 return bitmap.getRowBytes() * bitmap.getHeight();  
			}
		};
	}

	@Override
	public Bitmap getBitmap(String url) {
		// TODO Auto-generated method stub
		Log.e("get", url);
		return mCache.get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		// TODO Auto-generated method stub
		mCache.put(url, bitmap);
	}

}
