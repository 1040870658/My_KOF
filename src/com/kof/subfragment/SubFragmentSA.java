package com.kof.subfragment;

import com.kof.R;
import com.kof.model.SubMainDataHolder;
import com.kof.utils.Holder;
import com.kof.utils.SubMainHolder;

public class SubFragmentSA extends SubFragmentMain{

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
