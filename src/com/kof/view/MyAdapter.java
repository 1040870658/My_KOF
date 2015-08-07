package com.kof.view;

import java.util.Set;

import com.example.kof.R;
import com.kof.model.GlobalData;
import com.kof.utils.Holder;
import com.kof.utils.HolderFactory;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class MyAdapter extends BaseAdapter {
	Holder holder;
	View layoutView;
	Activity activity;
	int resid;
	protected HolderFactory holderFactory;
	protected abstract View setUpConvertView();
	public MyAdapter(Holder holder,Activity activity) {
		this.holder = holder;
		this.activity = activity;
		this.resid = holder.getResid();
		holderFactory = new HolderFactory(activity);
		layoutView = activity.getLayoutInflater().inflate(resid, null);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (null == convertView) {
			
			convertView = setUpConvertView();
			holder.setUp(convertView);
			convertView.setTag(holder);
		}
		else{
			holder = (Holder) convertView.getTag();
		}
		holder.refreshData(position);
		return convertView;
	}
	public void setHolder(Holder holder){
		this.holder = holder;
	}
	public void setResid(int resid){
		this.resid = resid;
	}
}
