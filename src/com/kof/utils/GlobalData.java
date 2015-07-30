package com.kof.utils;

import android.support.v4.app.Fragment;

import com.example.kof.*;
import com.kof.fragment.FragmentData;
import com.kof.fragment.FragmentGroup;
import com.kof.fragment.FragmentMain;
import com.kof.fragment.FragmentMatch;
public class GlobalData {
	private GlobalData(){
	}
	private static final int NUM = 4;
	public static int num_of_fragments = NUM;
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
}
