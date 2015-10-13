package com.kof.model;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;

import com.kof.R;
import com.kof.fragment.FragmentData;
import com.kof.fragment.FragmentGroup;
import com.kof.fragment.FragmentMain;
import com.kof.fragment.FragmentMatch;
import com.kof.subfragment.SubFragmentEA;
import com.kof.subfragment.SubFragmentFA;
import com.kof.subfragment.SubFragmentGA;
import com.kof.subfragment.SubFragmentIA;
import com.kof.subfragment.SubFragmentMain;
import com.kof.subfragment.SubFragmentMainHotnews;
import com.kof.subfragment.SubFragmentOther;
import com.kof.subfragment.SubFragmentSA;
public class GlobalData {
	private GlobalData(){
	}
	private static DisplayMetrics displayMetrics;
	public static int DISPLAY_PAGER = 999;
	public static int DISPLAY_NUM = 5;
	public static int TEXT_TYPE = 0;
	public static int IMAGE_TYPE = 1;
	public static int currentType = TEXT_TYPE;
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
//	public static Class[] subFragment_classClasses={
//		SubFragmentMainHotnews.class,
//		
//	}
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
		if(0 == fragments.size()){
		fragments.add(new SubFragmentMainHotnews());//头条
		
		fragments.add(new SubFragmentMainHotnews());//视频
		
		fragments.add(new SubFragmentMainHotnews());//集锦
		
		fragments.add(new SubFragmentMainHotnews());//深度
		
		fragments.add(new SubFragmentMainHotnews());//足彩
		
		fragments.add(new SubFragmentMainHotnews());//专题
		
		fragments.add(new SubFragmentMainHotnews());//闲情
		
		fragments.add(new SubFragmentMainHotnews());//转会
		
		fragments.add(new SubFragmentMainHotnews());//国内
		
	
		
fragments.add(new SubFragmentMainHotnews());//足彩
		
		fragments.add(new SubFragmentMainHotnews());//专题
		
		fragments.add(new SubFragmentMainHotnews());//闲情
		
		fragments.add(new SubFragmentMainHotnews());//转会
		
		fragments.add(new SubFragmentMainHotnews());//国内
//		fragments.add(new SubFragmentEA());//英超
//		
//		fragments.add(new SubFragmentSA());//西甲
//		
//		fragments.add(new SubFragmentGA());//德甲
//		
//		fragments.add(new SubFragmentIA());//意甲
//		
//		fragments.add(new SubFragmentOther());//其他
		}
		return fragments;
	}

}
