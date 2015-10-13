package com.kof.net;

import android.util.Log;
import android.widget.Adapter;
import android.widget.BaseAdapter;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kof.adapter.SubMainAdapter;
import com.kof.model.SubMainDataHolder;

public class HotNewsUpdateTask extends LoadingTask{

	private SubMainDataHolder dataHolder;
	private SubMainAdapter adapter;
	public HotNewsUpdateTask(PullToRefreshListView mPullToRefreshListView) {
		super(mPullToRefreshListView);
		// TODO Auto-generated constructor stub
	}
	public HotNewsUpdateTask(PullToRefreshListView mPullToRefreshListView,SubMainDataHolder dataHolder,SubMainAdapter adapter){
		super(mPullToRefreshListView);
		this.dataHolder = dataHolder;
		this.adapter = adapter;
	}
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		dataHolder.addImage("http://img.dongqiudi.com/uploads9/allimg/150920/521-1509201403550-L.jpg!litpic");
		dataHolder.addTitle("news");
		adapter.notifyDataSetChanged();
		mPullToRefreshListView.onRefreshComplete();
		super.onPostExecute(result);
	}
}
