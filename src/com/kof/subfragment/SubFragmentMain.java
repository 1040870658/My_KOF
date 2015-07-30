package com.kof.subfragment;

import com.example.kof.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SubFragmentMain extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		TextView tView = new TextView(getActivity());
		tView.setText("sub1");
		tView.setTextSize(24);
		tView.setGravity(Gravity.CENTER);
		return tView;
	}
	
}
