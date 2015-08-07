package com.kof.utils;

import android.view.View;

public interface Holder {
	void setUp(View convertView);
	void refreshData(int position);
	int getLength();
}
