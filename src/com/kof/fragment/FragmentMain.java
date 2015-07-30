package com.kof.fragment;


import com.example.kof.*;
import com.kof.subfragment.SubFragmentMain;
import com.kof.utils.GlobalData;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabWidget;
import android.widget.TextView;

public class FragmentMain extends Fragment{

	public FragmentTabHost mTabHost;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_main,null);
		initView(view);
		TabWidget tabWidget = mTabHost.getTabWidget();
		int count = tabWidget.getChildCount();
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int screenWidth = displayMetrics.widthPixels;
		for(int i = 0;i < count;i++){
			tabWidget.getChildTabViewAt(i).setMinimumWidth(screenWidth/5);
		}
		
		return view;
	}
	
	private void initView(View view){
		mTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
		mTabHost.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);
		for(int i = 0;i < GlobalData.sub_main_num;i ++){
			View indicatorView = getIndicatorView(i);
			((TextView)indicatorView.findViewById(R.id.sub_text)).setText(GlobalData.subMain[i]);
			mTabHost.addTab(mTabHost.newTabSpec("sub_main_tab"+i).setIndicator(indicatorView), SubFragmentMain.class, null);
		}
	}
	private View getIndicatorView(int i){
		View indicator = getActivity().getLayoutInflater().inflate(R.layout.sub_main_tab, null);
		return indicator;
	}
}
