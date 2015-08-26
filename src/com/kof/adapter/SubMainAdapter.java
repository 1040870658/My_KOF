package com.kof.adapter;

import java.net.HttpURLConnection;
import java.util.List;

import java.net.*;
import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kof.R;
import com.kof.model.DataHolder;
import com.kof.model.GlobalData;
import com.kof.model.SubMainDataHolder;
import com.kof.utils.Holder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class SubMainAdapter extends BaseAdapter {

	protected ListView mListView;
	protected ImageLoader auto_imageLoader;
	protected SubMainDataHolder dataHolder ;;
	protected Activity activity;
	private String imageUrl; 

	public SubMainAdapter(Activity activity,SubMainDataHolder dataHolder) {
		// TODO Auto-generated constructor stub
		this.activity = activity;
		auto_imageLoader =  ImageLoader.getInstance();
		this.dataHolder = dataHolder;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return dataHolder.getLength();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		SubMainHolder holder;
		if(mListView == null){
			mListView = (ListView)parent;
		}
		if (convertView == null || convertView.getTag() == null) {
			holder = new SubMainHolder(activity);
			convertView = setUpConvertView(holder);
			setUp(convertView,holder);
			convertView.setTag(holder);
		}
		else{
			holder = (SubMainHolder) convertView.getTag();
		}
		refreshData(holder,position);
		return convertView;
	}

	protected View setUpConvertView(SubMainHolder holder) {
		View convertView = activity.getLayoutInflater().inflate(holder.resid,
				null);
		;
		AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				GlobalData.getScreenHeight(activity) / 7);
		convertView.setLayoutParams(lp);
		return convertView;
	}

	public void setUp(View convertView,SubMainHolder holder) {
		// TODO Auto-generated method stub
		holder.headTextView = (TextView) convertView
				.findViewById(R.id.tv_title);
		holder.summaryTextView = (TextView) convertView
				.findViewById(R.id.tv_summary);
		holder.imageView = (ImageView) convertView.findViewById(R.id.iv_title);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
				GlobalData.getScreenWidth(activity) / 3,
				GlobalData.getScreenHeight(activity) / 8);
		params.addRule(RelativeLayout.CENTER_VERTICAL);
		holder.imageView.setLayoutParams(params);
	}

	public void refreshData(SubMainHolder holder, int position) {
		// TODO Auto-generated method stub
//		AsynImageLoader imageLoader = new AsynImageLoader(holder);
		imageUrl = dataHolder.getImgSet().get(position);
		holder.imageView.setTag(imageUrl);
		holder.imageView.setImageDrawable(null);
		if(holder.imageView.getTag()!=null && holder.imageView.getTag().equals(imageUrl))
			auto_imageLoader.displayImage(imageUrl, holder.imageView);
		holder.headTextView.setText(dataHolder.getTitleSet().get(position));
		holder.summaryTextView
				.setText(dataHolder.getSummarySet().get(position));

	}

	static class SubMainHolder {
		public int resid = R.layout.item_list;
		public TextView headTextView;
		public TextView summaryTextView;
		public ImageView imageView;
		private Activity activity;

		public SubMainHolder(Activity activity) {
			this.activity = activity;
		}

		public int getResid() {
			return resid;
		}
	}

	private class AsynImageLoader extends AsyncTask<String, Void, BitmapDrawable> {

		private SubMainHolder holder;
		public AsynImageLoader(SubMainHolder holder){
			this.holder = holder;
		}
		@Override
		protected BitmapDrawable doInBackground(String... params) {
			// TODO Auto-generated method stub
			String url = params[0];
			 BitmapDrawable drawable = new BitmapDrawable(activity.getResources(), downloadBitmap(url));  
			return drawable;
		}

		@Override
		protected void onPostExecute(BitmapDrawable result) {
			// TODO Auto-generated method stub
			ImageView imageView = (ImageView) mListView.findViewWithTag(imageUrl);  
			if (imageView != null && result != null) { 
				imageView.setImageDrawable(result);
			}
		}
		private Bitmap downloadBitmap(String imageUrl) {
			Bitmap bitmap = null;
			HttpURLConnection con = null;
			try {
				URL url = new URL(imageUrl);
				con = (HttpURLConnection) url.openConnection();
				con.setConnectTimeout(5 * 1000);
				con.setReadTimeout(10 * 1000);
				bitmap = BitmapFactory.decodeStream(con.getInputStream());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (con != null) {
					con.disconnect();
				}
			}
			return bitmap;
		}

	}
	
}
