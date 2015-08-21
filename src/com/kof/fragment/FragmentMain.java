package com.kof.fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.kof.R;
import com.kof.adapter.FragmentViewPageAdapter;
import com.kof.model.GlobalData;
import com.kof.subfragment.SubFragmentFA;
import com.kof.subfragment.SubFragmentMain;
import com.kof.subfragment.SubFragmentMainHotnews;

import android.R.integer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabWidget;
import android.widget.TextView;

public class FragmentMain extends Fragment {

	private int tab_count;
	private int screenWidth;
	private HorizontalScrollView horizontalScrollView;
	private View view;

	private ViewPager viewPager;

	private List<Fragment> fragments = new ArrayList<Fragment>();

	public FragmentTabHost mTabHost;

	private void initViewPager(View view) {
		viewPager = (ViewPager) view.findViewById(R.id.sub_main_pager);

		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				mTabHost.setCurrentTab(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		FragmentViewPageAdapter fragmentViewPageAdapter = new FragmentViewPageAdapter(
				getChildFragmentManager(), GlobalData.getFragments());
		viewPager.setAdapter(fragmentViewPageAdapter);
	}

	private void initView(View view) {
		mTabHost = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
		horizontalScrollView = (HorizontalScrollView) mTabHost
				.findViewById(R.id.tab_scroll);
		initViewPager(mTabHost);
		mTabHost.setup(getActivity(), getChildFragmentManager(),
				android.R.id.tabcontent);
		for (int i = 0; i < GlobalData.sub_main_num; i++) {
			View indicatorView;
			indicatorView = getIndicatorView(i);
			((TextView) indicatorView.findViewById(R.id.sub_text))
					.setText(GlobalData.subMain[i]);
			mTabHost.addTab(mTabHost.newTabSpec("sub_main_tab" + i)
					.setIndicator(indicatorView), SubFragmentMainHotnews.class,
					null);
		}

		mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String arg0) {
				// TODO Auto-generated method stub
				int currentTab = mTabHost.getCurrentTab();
				viewPager.setCurrentItem(currentTab);
				if (currentTab >= GlobalData.DISPLAY_NUM / 2) {
					horizontalScrollView.smoothScrollTo(
							(int) horizontalScrollView.getX()
									+ movingCount(currentTab),
							(int) horizontalScrollView.getY());
				}
			}
		});
	}

	private int movingCount(int offset) {
		return screenWidth / GlobalData.DISPLAY_NUM
				* (offset - GlobalData.DISPLAY_NUM / 2);
	}

	private View getIndicatorView(int i) {
		View indicator = getActivity().getLayoutInflater().inflate(
				R.layout.sub_main_tab, null);
		return indicator;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (view == null) {
			view = inflater.inflate(R.layout.fragment_main, null);
			initView(view);
			TabWidget tabWidget = mTabHost.getTabWidget();
			tab_count = tabWidget.getChildCount();
			screenWidth = GlobalData.getScreenWidth(getActivity());
			for (int i = 0; i < tab_count; i++) {
				tabWidget.getChildTabViewAt(i).setMinimumWidth(
						screenWidth / GlobalData.DISPLAY_NUM);
			}
		}
		ViewGroup parent = (ViewGroup) view.getParent();
		if(parent != null){
			parent.removeView(view);
		}
		return view;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		horizontalScrollView.smoothScrollTo((int) horizontalScrollView.getX()
				+ movingCount(mTabHost.getCurrentTab()),
				(int) horizontalScrollView.getY());
	}

}
