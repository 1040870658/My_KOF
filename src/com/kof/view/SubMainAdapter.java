package com.kof.view;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;

import com.kof.model.GlobalData;
import com.kof.utils.Holder;

public class SubMainAdapter extends MyAdapter{

	public SubMainAdapter(Holder holder, Activity activity) {
		super(holder, activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return holder.getLength();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected View setUpConvertView() {
		View convertView = activity.getLayoutInflater().inflate(resid, null);;
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				GlobalData.getScreenHeight(activity) / 7);
		convertView.setLayoutParams(lp);
		return convertView;
	}

	

}
