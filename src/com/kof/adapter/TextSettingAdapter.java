package com.kof.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kof.R;

import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TextSettingAdapter extends BaseAdapter{

	private Map<String,OnClickListener> map;
	private List<String> mListItems;
	private Context context;
	public TextSettingAdapter(List<String> mListItems,Context context){
		this.mListItems = mListItems;
		this.context = context;
		map = new HashMap<String,OnClickListener>();
		map.put(context.getResources().getString(R.string.share), new ShareListener());
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
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
			textViewHolder.textView.setOnClickListener( map.get(mListItems.get(position)));
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
	
	private void Share(){
		Intent shareIntent = new Intent();
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent.putExtra(Intent.EXTRA_TEXT, context.getResources().getString(R.string.fake_name));
		context.startActivity(Intent.createChooser(shareIntent, "ÍÆ¼ö¸øºÃÓÑ"));
	}

	private class ShareListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Share();
		}
		
	}
}
