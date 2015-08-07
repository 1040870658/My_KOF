package com.kof.fragment;

import java.text.ParseException;
import java.util.Date;

import com.example.kof.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.kof.net.LoadingTask;
import com.kof.utils.DateManager;
import com.kof.utils.SubMainHolder;
import com.kof.view.MyAdapter;
import com.kof.view.SubMainAdapter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class FragmentGroup extends Fragment{

	
	private PullToRefreshListView mPullToRefreshListView;
	private DateManager dateManager;
	private Activity fatherActivity;
	private MyAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		fatherActivity =getActivity();
		View layout = inflater.inflate(R.layout.sub_fragment_main, null);
		
		mPullToRefreshListView = (PullToRefreshListView) layout.findViewById(R.id.pull_refresh_list);
		setUpPullToRefresh();
		adapter = new SubMainAdapter(new SubMainHolder(fatherActivity), fatherActivity, R.layout.item_list);
		mPullToRefreshListView.setAdapter(adapter);
		return layout;
	}
	private String generateUpdateLabel(){
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
	
	private void setUpPullToRefresh(){
		mPullToRefreshListView.getLoadingLayoutProxy().setLastUpdatedLabel(generateUpdateLabel());
		mPullToRefreshListView.getLoadingLayoutProxy().setPullLabel("下拉刷新");
		mPullToRefreshListView.getLoadingLayoutProxy().setReleaseLabel("松开立即刷新");
		mPullToRefreshListView.getLoadingLayoutProxy().setRefreshingLabel("懂球帝正在刷新");
		mPullToRefreshListView.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				new LoadingTask(mPullToRefreshListView).execute();
			}
		});
	}

}
