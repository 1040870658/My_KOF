package com.kof.net;

import com.handmark.pulltorefresh.library.PullToRefreshListView;

import android.os.AsyncTask;

public class LoadingTask extends AsyncTask<Void, Void, String>{

	private PullToRefreshListView mPullToRefreshListView;
	public LoadingTask(PullToRefreshListView mPullToRefreshListView){
		super();
		this.mPullToRefreshListView = mPullToRefreshListView; 
	}
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		mPullToRefreshListView.onRefreshComplete();
		super.onPostExecute(result);
	}
	
	
}
