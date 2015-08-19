package com.kof.adapter;

import java.util.List;

import com.example.kof.R;
import com.example.kof.R.color;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TextSettingAdapter extends BaseAdapter{

	private List<String> mListItems;
	private Context context;
	public TextSettingAdapter(List<String> mListItems,Context context){
		this.mListItems = mListItems;
		this.context = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		TextViewHolder textViewHolder;
		if(convertView == null){
			convertView = ((Activity)context).getLayoutInflater().inflate(R.layout.individual_item_layout,null);
			textViewHolder = new TextViewHolder();
			textViewHolder.textView = (TextView) convertView.findViewById(R.id.tv_individual_name);
			convertView.setTag(textViewHolder);
		}
		else{
			textViewHolder = (TextViewHolder) convertView.getTag();
		}
		textViewHolder.textView.setText(mListItems.get(position));
		return convertView;
	}
	private static class TextViewHolder{
		public TextView textView;
	}
}
