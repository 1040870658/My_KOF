package com.kof.view;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kof.R;
import com.kof.model.GlobalData;
import com.kof.utils.Holder;

public class SubMainHotnewsAdapter extends SubMainAdapter {

	private AsyncViewPagerLoader asyncViewPagerLoader;
	public SubMainHotnewsAdapter(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return super.getCount() + 1;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub

		if (position == 0) {
			View layoutView;
			ViewPagerHolder viewPagerHolderholder = new ViewPagerHolder(
					activity);
			layoutView = activity.getLayoutInflater().inflate(
					R.layout.sub_fragment_host_news, null);
			setUpViewPager(layoutView, viewPagerHolderholder.viewPager,
					activity.getLayoutInflater());
			return layoutView;
		}
		return super.getView(position - 1, convertView, arg2);
	}

	private void setUpViewPager(View convertView, ViewPager viewPager,
			LayoutInflater inflater) {
		viewPager = (ViewPager) convertView.findViewById(R.id.vp_issue);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				GlobalData.getScreenHeight(activity) / 4);
		viewPager.setLayoutParams(lp);
		asyncViewPagerLoader = new AsyncViewPagerLoader(viewPager);
		asyncViewPagerLoader.execute();
	}

	static class ViewPagerHolder {

		public ViewPager viewPager;
		private Activity activity;

		public ViewPagerHolder(Activity activity) {
			this.activity = activity;
		}

	}
	private class AsyncViewPagerLoader extends AsyncTask<Void, Void, IssueAdapter>{

		private ViewPager viewPager;
		public AsyncViewPagerLoader(ViewPager viewPager){
			super();
			this.viewPager = viewPager;
		}
		@Override
		protected IssueAdapter doInBackground(Void... viewPager) {
			// TODO Auto-generated method stub
			

			ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
			ImageView imageView_1 = (ImageView) activity.getLayoutInflater().inflate(R.layout.issue,
					null);
			imageView_1.setBackgroundResource(R.drawable.issue_1);

			ImageView imageView_2 = (ImageView) activity.getLayoutInflater().inflate(R.layout.issue,
					null);
			imageView_2.setBackgroundResource(R.drawable.issue_2);

			ImageView imageView_3 = (ImageView) activity.getLayoutInflater().inflate(R.layout.issue,
					null);
			imageView_3.setBackgroundResource(R.drawable.issue_3);

			ImageView imageView_4 = (ImageView) activity.getLayoutInflater().inflate(R.layout.issue,
					null);
			imageView_4.setBackgroundResource(R.drawable.issue_4);

			ImageView imageView_5 = (ImageView) activity.getLayoutInflater().inflate(R.layout.issue,
					null);
			imageView_5.setBackgroundResource(R.drawable.issue_5);

			imageViews.add(imageView_1);
			imageViews.add(imageView_2);
			imageViews.add(imageView_3);
			imageViews.add(imageView_4);
			imageViews.add(imageView_5);

			IssueAdapter issueAdapter = new IssueAdapter(imageViews);
			return issueAdapter;
		}

		
		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
			ProgressDialog progressDialog = new ProgressDialog(activity);
			progressDialog.setMessage("loading...");
		}
		@Override
		protected void onPostExecute(IssueAdapter result) {
			viewPager.setAdapter(result);
		}
		
	}
}
