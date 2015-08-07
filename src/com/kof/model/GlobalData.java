package com.kof.model;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;

import com.example.kof.*;
import com.kof.fragment.FragmentData;
import com.kof.fragment.FragmentGroup;
import com.kof.fragment.FragmentMain;
import com.kof.fragment.FragmentMatch;
import com.kof.subfragment.SubFragmentMain;
public class GlobalData {
	private GlobalData(){
	}
	private static DisplayMetrics displayMetrics;
	public static int DISPLAY_NUM = 5;
	private static final int NUM = 4;
	public static int num_of_fragments = NUM;
	
	public static int getScreenWidth(Context context){
		displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.widthPixels;
	}
	public static int getScreenHeight(Context context){
		displayMetrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		return displayMetrics.heightPixels;
	}
	public static String[] fragment_tags = { 	
		"tag_1",
		"tag_2",
		"tag_3",
		"tag_4"
	};
	public static Class[] fragment_class = {
		FragmentMain.class,
		FragmentMatch.class,
		FragmentGroup.class,
		FragmentData.class
	};
	public static int[] tab_layouts ={
		R.layout.tab_main,
		R.layout.tab_match,
		R.layout.tab_group,
		R.layout.tab_data
	};
	public static String[] subMain={
			"头条",
			"视频",
			"集锦",
			"深度",
			"足彩",
			"专题",
			"闲情",
			"转会",
			"国内",
			"英超",
			"西甲",
			"德甲",
			"意甲",
			"其他",
	};
	public static int sub_main_num = subMain.length;
	
	private static List<Fragment> fragments = new ArrayList<Fragment>();
	public static List<Fragment> getFragments(){
		for(int i = 0;i < sub_main_num;i++){
			fragments.add(new SubFragmentMain());
		}
		return fragments;
	}
	
	private static String[] mStrings = { "Abbaye de Belloc",
			"Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
			"Acorn" };
	private static int[] imgId = { R.drawable.news_1, R.drawable.news_2,
			R.drawable.news_3, R.drawable.news_4, R.drawable.news_5,
			R.drawable.news_6 };

}
