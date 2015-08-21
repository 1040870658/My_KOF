package com.kof.subfragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kof.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kof.activity.CustomApplication;
import com.kof.adapter.SubMainHotnewsAdapter;
import com.kof.model.DataHolder;
import com.kof.model.GlobalData;
import com.kof.model.SubMainDataHolder;
import com.kof.net.HotNewsUpdateTask;
import com.kof.utils.Holder;
import com.kof.utils.SubMainHolder;

public class SubFragmentMainHotnews extends SubFragmentMain {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		adapter = new SubMainHotnewsAdapter(getActivity(),(SubMainDataHolder) dataHolder);
		CustomApplication.getRefWatcher(getActivity()).watch(this);
		return super.onCreateView(inflater, container, savedInstanceState);
	}


	@Override
	protected void setUpDataHolder() {
		// TODO Auto-generated method stub
		this.dataHolder = new SubMainDataHolder();
	}


	@Override
	protected Holder setUpHolder() {
		// TODO Auto-generated method stub
		return new SubMainHolder(getActivity(), R.layout.item_list);
	}


	@Override
	protected AsyncTask<Void, Void, String> runRefreshTask(
			PullToRefreshListView listView) {
		// TODO Auto-generated method stub
		return new HotNewsUpdateTask(mPullToRefreshListView,(SubMainDataHolder) dataHolder,adapter);
	}

	
	
}
