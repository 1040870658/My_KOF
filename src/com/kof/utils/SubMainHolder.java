package com.kof.utils;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kof.R;
import com.kof.model.GlobalData;
import com.kof.model.SubMainDataHolder;

public class SubMainHolder implements Holder{

	public TextView headTextView;
	public TextView summaryTextView;
	public ImageView imageView;
	private SubMainDataHolder subMainDataHolder;
	private Context context;
	private List<String> mListItems;
	private List<String> sListItems;
	private int[] iListItems;
	public SubMainHolder(Context context){
		this.context = context;
		subMainDataHolder = new SubMainDataHolder();
		mListItems = subMainDataHolder.getTitleSet();
		sListItems = subMainDataHolder.getSummarySet();
	    iListItems = subMainDataHolder.getImgSet();
	}
	@Override
	public void setUp(View convertView) {
		// TODO Auto-generated method stub
		headTextView = (TextView) convertView.findViewById(R.id.tv_title);
		summaryTextView = (TextView) convertView.findViewById(R.id.tv_summary);
		imageView = (ImageView) convertView.findViewById(R.id.iv_title);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				GlobalData.getScreenWidth(context)/4,
				GlobalData.getScreenHeight(context)/8);
		params.addRule(RelativeLayout.CENTER_VERTICAL);
		imageView.setLayoutParams(params);
	}

	@Override
	public void refreshData(int position) {
		// TODO Auto-generated method stub
		
		headTextView.setText(mListItems.get(position));
		summaryTextView.setText(sListItems.get(position));
		imageView.setImageResource(iListItems[position]);
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return mListItems.size();
	}

}
