package com.kof.subfragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kof.R;
import com.kof.utils.Holder;
import com.kof.utils.SubMainHolder;
import com.kof.view.IssueAdapter;

public class SubFragmentMainHotnews extends SubFragmentMain{

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		layout = inflater.inflate(R.layout.sub_fragment_host_news, null);
		ViewPager viewPager = (ViewPager) layout.findViewById(R.id.vp_issue);
		setUpViewPager(viewPager, inflater);
		return layout;
	}

	@Override
	protected Holder setUpDataHolder() {
		// TODO Auto-generated method stub
		return new SubMainHolder(getActivity(), R.layout.item_list);
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
