package com.kof.utils;

import android.os.Handler;
import android.os.Message;
import android.widget.Adapter;
import android.widget.BaseAdapter;

public class DataRefreshHandler extends Handler{

	private BaseAdapter adapter;
	public DataRefreshHandler(BaseAdapter adapter){
		this.adapter = adapter;
	}
	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		adapter.notifyDataSetChanged();
		super.handleMessage(msg);
	}
	
}
