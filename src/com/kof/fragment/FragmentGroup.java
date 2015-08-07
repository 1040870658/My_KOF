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

	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_group, null);
	}


}
