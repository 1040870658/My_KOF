package com.kof.subfragment;

import java.text.ParseException;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kof.R;
import com.kof.activity.NewsActivity;
import com.kof.adapter.SubMainAdapter;
import com.kof.model.SubMainDataHolder;
import com.kof.net.LoadMoreTask;
import com.kof.net.LoadingTask;
import com.kof.utils.DataRefreshHandler;
import com.kof.utils.DateManager;

public abstract class SubFragmentMain extends Fragment{

	protected PullToRefreshListView mPullToRefreshListView;
	protected LoadingTask loadingTask;
	protected LoadMoreTask loadMoreTask;
	private Intent intent;
	protected DataRefreshHandler dataRefreshHandler;
	protected DateManager dateManager;
	protected Activity fatherActivity;
	protected SubMainAdapter adapter;
	protected View layout;
	protected SubMainDataHolder dataHolder;
	protected int layoutResource;
	protected int count = 2;
	protected String dataURL = "http://www.dongqiudi.com/archives/1?page=";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.e("onCreate", this.getClass().getName());
		fatherActivity =getActivity();
		this.layoutResource = R.layout.sub_fragment_main;
		setUpDataHolder();
	//	adapter = new SubMainAdapter(fatherActivity,dataHolder);
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.e("onCreateView", this.getClass().getName());
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
		mPullToRefreshListView.getLoadingLayoutProxy().setReleaseLabel("松开立即刷新");
		mPullToRefreshListView.getLoadingLayoutProxy().setRefreshingLabel("懂球帝正在刷新");
		mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				if(refreshView.isShownHeader()){
					String url = dataURL+1;
					mPullToRefreshListView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
					loadingTask = (LoadingTask) runRefreshTask(mPullToRefreshListView);
					loadingTask.setURL(url);
					loadingTask.execute();
				}
				if(refreshView.isShownFooter()){
					String url = dataURL+count;
					mPullToRefreshListView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
					loadMoreTask = new LoadMoreTask(mPullToRefreshListView, fatherActivity, url, dataRefreshHandler, dataHolder);
					loadMoreTask.setURL(url);
					loadMoreTask.execute();
					count++;
				}
			}
		});
//		adapter = new SubMainAdapter(new SubMainHolder(fatherActivity), fatherActivity, R.layout.item_list);
		ListView actualListView = mPullToRefreshListView.getRefreshableView();
		actualListView.setAdapter(adapter);
		actualListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Bundle info = new Bundle();
				Log.e("position", id+"");
				info.putString("id", adapter.getDataHolder().getId().get((int)id));
				intent = new Intent();
				intent.putExtra("news", info);
				intent.setClass(fatherActivity, NewsActivity.class);
				startActivity(intent);
			}
		});
	}
	public void setLayoutResource(int resource){
		this.layoutResource = resource;
	}
	protected  AsyncTask<Void, Void, String> runRefreshTask(PullToRefreshListView listView){
		return new LoadingTask(mPullToRefreshListView,fatherActivity,dataURL+1,dataRefreshHandler,dataHolder);
	}
		
	protected abstract void setUpDataHolder();
	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.e("onActivityCreated", this.getClass().getName());
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		Log.e("onAttach", this.getClass().getName());
		super.onAttach(activity);
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.e("onDestroy", this.getClass().getName());
		super.onDestroy();
	}
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		Log.e("onDetach", this.getClass().getName());
		super.onDetach();
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		Log.e("onPause", this.getClass().getName());
		super.onPause();
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		Log.e("onStart", this.getClass().getName());
//		CustomApplication.getRefWatcher(fatherActivity).watch(this);
		super.onStart();
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		Log.e("onStop", this.getClass().getName());
		super.onStop();
	}
	
}
