package com.kof.view;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.kof.R;
import com.kof.activity.MainActivity;
import com.kof.model.GlobalData;
import com.kof.utils.Holder;
import com.nostra13.universalimageloader.core.ImageLoader;

public class SubMainHotnewsAdapter extends SubMainAdapter {

	private View pagerView;
	private ViewPagerHolder viewPagerHolderholder;
	ImageHandler handler = new ImageHandler();
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
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return super.getItem(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub

		if (position == 0) {
			if (pagerView == null) {

				viewPagerHolderholder = new ViewPagerHolder(activity);
				pagerView = activity.getLayoutInflater().inflate(
						R.layout.sub_fragment_host_news, null);
				setUpViewPager(pagerView, viewPagerHolderholder.viewPager,
						activity.getLayoutInflater());
			} else {
				
			}
			handler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE,
					ImageHandler.MSG_DELAY);
			return pagerView;
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
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			// 配合Adapter的currentItem字段进行设置。
			@Override
			public void onPageSelected(int arg0) {
				handler.sendMessage(Message.obtain(handler,
						ImageHandler.MSG_PAGE_CHANGED, arg0, 0));
			}

			// 覆写该方法实现轮播效果的暂停和恢复
			@Override
			public void onPageScrollStateChanged(int arg0) {
				switch (arg0) {
				case ViewPager.SCROLL_STATE_DRAGGING:
					handler.sendEmptyMessage(ImageHandler.MSG_KEEP_SILENT);
					break;
				case ViewPager.SCROLL_STATE_IDLE:
					handler.sendEmptyMessageDelayed(
							ImageHandler.MSG_UPDATE_IMAGE,
							ImageHandler.MSG_DELAY);
					break;
				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
		});
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

	private class AsyncViewPagerLoader extends
			AsyncTask<Void, Void, IssueAdapter> {

		private ViewPager viewPager;

		public AsyncViewPagerLoader(ViewPager viewPager) {
			super();
			this.viewPager = viewPager;
		}

		@Override
		protected IssueAdapter doInBackground(Void... viewPager) {
			// TODO Auto-generated method stub

			ArrayList<View> relativeLayouts = new ArrayList<View>();
			RelativeLayout relativeLayout1 = (RelativeLayout) activity
					.getLayoutInflater().inflate(R.layout.pagerlayout, null);
			relativeLayout1.setBackgroundResource(R.drawable.issue_1);
			TextView textView1 = (TextView) relativeLayout1
					.findViewById(R.id.tv_pagerdesc);
			textView1.setText("辉煌,走进2002国足");

			RelativeLayout relativeLayout2 = (RelativeLayout) activity
					.getLayoutInflater().inflate(R.layout.pagerlayout, null);
			relativeLayout2.setBackgroundResource(R.drawable.issue_2);
			TextView textView2 = (TextView) relativeLayout2
					.findViewById(R.id.tv_pagerdesc);
			textView2.setText("秀恩爱,小猪和伊万齐出镜");

			RelativeLayout relativeLayout3 = (RelativeLayout) activity
					.getLayoutInflater().inflate(R.layout.pagerlayout, null);
			relativeLayout3.setBackgroundResource(R.drawable.issue_3);
			TextView textView3 = (TextView) relativeLayout3
					.findViewById(R.id.tv_pagerdesc);
			textView3.setText("不说足球,中国游泳神话");

			RelativeLayout relativeLayout4 = (RelativeLayout) activity
					.getLayoutInflater().inflate(R.layout.pagerlayout, null);
			relativeLayout4.setBackgroundResource(R.drawable.issue_4);
			TextView textView4 = (TextView) relativeLayout4
					.findViewById(R.id.tv_pagerdesc);
			textView4.setText("官方,萨拉赫加盟罗马");

			RelativeLayout relativeLayout5 = (RelativeLayout) activity
					.getLayoutInflater().inflate(R.layout.pagerlayout, null);
			relativeLayout5.setBackgroundResource(R.drawable.issue_5);
			TextView textView5 = (TextView) relativeLayout5
					.findViewById(R.id.tv_pagerdesc);
			textView5.setText("球色怡人,团团大法好");
			relativeLayouts.add(relativeLayout1);
			relativeLayouts.add(relativeLayout2);
			relativeLayouts.add(relativeLayout3);
			relativeLayouts.add(relativeLayout4);
			relativeLayouts.add(relativeLayout5);

			IssueAdapter issueAdapter = new IssueAdapter(relativeLayouts);
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

	private class ImageHandler extends Handler {

		/**
		 * 请求更新显示的View。
		 */
		protected static final int MSG_UPDATE_IMAGE = 1;
		/**
		 * 请求暂停轮播。
		 */
		protected static final int MSG_KEEP_SILENT = 2;
		
		/**
		 * 记录最新的页号，当用户手动滑动时需要记录新页号，否则会使轮播的页面出错。
		 * 例如当前如果在第一页，本来准备播放的是第二页，而这时候用户滑动到了末页，
		 * 则应该播放的是第一页，如果继续按照原来的第二页播放，则逻辑上有问题。
		 */
		protected static final int MSG_PAGE_CHANGED = 4;

		// 轮播间隔时间
		protected static final long MSG_DELAY = 3000;

		// 使用弱引用避免Handler泄露.这里的泛型参数可以不是Activity，也可以是Fragment等
		private int currentItem = 0;

		protected ImageHandler() {
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			ViewPager viewPager = (ViewPager) pagerView.findViewById(R.id.vp_issue);
			if (viewPager == null) {
				return;
			}
			if (activity == null) {
				// Activity已经回收，无需再处理UI了
				return;
			}
			// 检查消息队列并移除未发送的消息，这主要是避免在复杂环境下消息出现重复等问题。
			if (handler.hasMessages(MSG_UPDATE_IMAGE)) {
				handler.removeMessages(MSG_UPDATE_IMAGE);
			}
			switch (msg.what) {
			case MSG_UPDATE_IMAGE:
				currentItem++;
				if(currentItem >= 5)
					currentItem %= 5;
				viewPager.setCurrentItem(currentItem);
				// 准备下次播放
				handler.sendEmptyMessageDelayed(MSG_UPDATE_IMAGE, MSG_DELAY);
				break;
			case MSG_KEEP_SILENT:
				// 只要不发送消息就暂停了
				break;
			case MSG_PAGE_CHANGED:
				// 记录当前的页号，避免播放的时候页面显示不正确。
				currentItem = msg.arg1;
				break;
			default:
				break;
			}
		}
	}
}
