package com.kof.subfragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kof.R;
import com.kof.utils.Holder;
import com.kof.utils.SubMainHolder;
import com.kof.view.IssueAdapter;
import com.kof.view.SubMainHotnewsAdapter;

public class SubFragmentMainHotnews extends SubFragmentMain{

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		layout = inflater.inflate(R.layout.sub_fragment_host_news, null);
		
		
		layout = inflater.inflate(R.layout.sub_fragment_main, null);
		adapter = new SubMainHotnewsAdapter(new SubMainHolder(getActivity(), R.layout.item_list), getActivity());
		return layout;
	}

	@Override
	protected Holder setUpDataHolder() {
		// TODO Auto-generated method stub
		return new SubMainHolder(getActivity(), R.layout.item_list);
	}

	
}
