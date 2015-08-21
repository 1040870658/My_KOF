package com.kof.subfragment;

import java.text.ParseException;
import java.util.Date;

import com.kof.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kof.adapter.SubMainAdapter;
import com.kof.model.DataHolder;
import com.kof.model.SubMainDataHolder;
import com.kof.net.LoadingTask;
import com.kof.utils.DateManager;
import com.kof.utils.Holder;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public abstract class SubFragmentMain extends Fragment{

	protected PullToRefreshListView mPullToRefreshListView;
	protected DateManager dateManager;
	protected Activity fatherActivity;
	protected SubMainAdapter adapter;
	protected Holder holder;
	protected View layout;
	protected DataHolder dataHolder;
	protected int layoutResource;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		fatherActivity =getActivity();
		this.layoutResource = R.layout.sub_fragment_main;
		this.holder = setUpHolder();
		setUpDataHolder();
		adapter = new SubMainAdapter(fatherActivity,(SubMainDataHolder) dataHolder);
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if(layout == null){
			layout = inflater.inflate(layoutResource, null);
			setUpPullToRefresh(layout);
		}
		 ViewGroup parent = (ViewGroup) layout.getParent();  
		 if(parent!=null){
			 parent.removeView(layout);
		 }
		return layout;
	}
	protected String generateUpdateLabel(){
		SharedPreferences sharedPreferences = fatherActivity.getPreferences(fatherActivity.MODE_PRIVATE);
		dateManager = new DateManager(new Date(System.currentTimeMillis()), "MM月dd日 HH:mm");
		String lastDateString = dateManager.getFromshare(sharedPreferences, 
				fatherActivity.getResources().getString(R.string.update_date));
		boolean isToday = false;
		String updateLabel = "最后更新:";
		try {
			isToday = dateManager.isToday(lastDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			isToday = false;
		}
		if(isToday){
			dateManager.setFormat("HH:mm");
			updateLabel = updateLabel + "今天 "+dateManager.getDateString();
		}
		else{
			updateLabel += dateManager.getDateString();
		}
		dateManager.setFormat("MM月dd日");
		dateManager.insertToshare(sharedPreferences, 
				fatherActivity.getResources().getString(R.string.update_date));
		return updateLabel;
	}
	
	protected void setUpPullToRefresh(View layout){
		mPullToRefreshListView = (PullToRefreshListView) layout.findViewById(R.id.pull_refresh_list);
		mPullToRefreshListView.getLoadingLayoutProxy().setLastUpdatedLabel(generateUpdateLabel());
		mPullToRefreshListView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
		mPullToRefreshListView.getLoadingLayoutProxy().setReleaseLabel("松开立即刷新");
		mPullToRefreshListView.getLoadingLayoutProxy().setRefreshingLabel("懂球帝正在刷新");
		mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				runRefreshTask(mPullToRefreshListView).execute();
			}
		});
//		adapter = new SubMainAdapter(new SubMainHolder(fatherActivity), fatherActivity, R.layout.item_list);
		ListView actualListView = mPullToRefreshListView.getRefreshableView();
		actualListView.setAdapter(adapter);
	}
	public void setLayoutResource(int resource){
		this.layoutResource = resource;
	}
	protected  AsyncTask<Void, Void, String> runRefreshTask(PullToRefreshListView listView){
		return new LoadingTask(mPullToRefreshListView);
	}
		
	protected abstract Holder setUpHolder();
	protected abstract void setUpDataHolder();
}
