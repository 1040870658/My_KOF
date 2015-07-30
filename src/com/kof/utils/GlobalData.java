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
			"ͷ��",
			"��Ƶ",
			"����",
			"���",
			"���",
			"ר��",
			"����",
			"ת��",
			"����",
			"Ӣ��",
			"����",
			"�¼�",
			"���",
			"����",
	};
	public static int sub_main_num = subMain.length;
}
