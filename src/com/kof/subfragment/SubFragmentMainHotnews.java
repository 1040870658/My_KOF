package com.kof.subfragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kof.R;
import com.kof.model.GlobalData;
import com.kof.utils.Holder;
import com.kof.utils.SubMainHolder;
import com.kof.view.SubMainHotnewsAdapter;

public class SubFragmentMainHotnews extends SubFragmentMain {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		layout = inflater.inflate(R.layout.sub_fragment_main, null);
		adapter = new SubMainHotnewsAdapter(getActivity());
		return layout;
	}


	@Override
	protected Holder setUpDataHolder() {
		// TODO Auto-generated method stub
		return new SubMainHolder(getActivity(), R.layout.item_list);
	}

	
	
}
