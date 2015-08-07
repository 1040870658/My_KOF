package com.kof.subfragment;

import com.example.kof.R;
import com.kof.utils.Holder;
import com.kof.utils.SubMainHolder;

public class SubFragmentFA extends SubFragmentMain{

	@Override
	protected Holder setUpDataHolder() {
		// TODO Auto-generated method stub
		return new SubMainHolder(getActivity(),R.layout.item_list);
	}
	
}
