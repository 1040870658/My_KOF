package com.kof.subfragment;

import android.os.AsyncTask;

import com.kof.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kof.model.SubMainDataHolder;
import com.kof.net.LoadingTask;
import com.kof.utils.Holder;
import com.kof.utils.SubMainHolder;

public class SubFragmentEA extends SubFragmentMain{

	@Override
	protected void setUpDataHolder() {
		// TODO Auto-generated method stub
		dataHolder = new SubMainDataHolder();
	}

	@Override
	protected Holder setUpHolder() {
		// TODO Auto-generated method stub
		return new SubMainHolder(getActivity(), R.layout.item_list);
	}

}
