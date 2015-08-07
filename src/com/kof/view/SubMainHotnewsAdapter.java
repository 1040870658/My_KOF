package com.kof.view;

import java.util.ArrayList;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kof.R;
import com.kof.utils.Holder;

public class SubMainHotnewsAdapter extends SubMainAdapter{

	public SubMainHotnewsAdapter(Holder holder, Activity activity) {
		super(holder, activity);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewPager viewPager = (ViewPager) activity.getLayoutInflater().inflate(R.layout.sub_fragment_host_news, null);
		setUpViewPager(viewPager, activity.getLayoutInflater());
		if(position == 0){
			Log.e("ps", position+"");
			convertView = viewPager;
			return convertView;
		}
		return super.getView(position, convertView, arg2);
	}
	private void setUpViewPager(ViewPager viewPager,LayoutInflater inflater){
		ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
		ImageView imageView_1 = (ImageView) inflater.inflate(R.layout.issue, null);
		imageView_1.setBackgroundResource(R.drawable.issue_1);
		
		ImageView imageView_2 = (ImageView) inflater.inflate(R.layout.issue, null);
		imageView_2.setBackgroundResource(R.drawable.issue_2);
		
		ImageView imageView_3 = (ImageView) inflater.inflate(R.layout.issue, null);
		imageView_3.setBackgroundResource(R.drawable.issue_3);
		
		ImageView imageView_4 = (ImageView) inflater.inflate(R.layout.issue, null);
		imageView_4.setBackgroundResource(R.drawable.issue_4);
		
		ImageView imageView_5 = (ImageView) inflater.inflate(R.layout.issue, null);
		imageView_5.setBackgroundResource(R.drawable.issue_5);
		
		imageViews.add(imageView_1);
		imageViews.add(imageView_2);
		imageViews.add(imageView_3);
		imageViews.add(imageView_4);
		imageViews.add(imageView_5);
		
		IssueAdapter issueAdapter = new IssueAdapter(imageViews);
		viewPager.setAdapter(issueAdapter);
	}
}
