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
	
	private static List<Fragment> fragments = new ArrayList<Fragment>();
	public static List<Fragment> getFragments(){
		if(0 == fragments.size()){
		fragments.add(new SubFragmentMainHotnews());//ͷ��
		
		fragments.add(new SubFragmentMainHotnews());//��Ƶ
		
		fragments.add(new SubFragmentMainHotnews());//����
		
		fragments.add(new SubFragmentMainHotnews());//���
		
		fragments.add(new SubFragmentMainHotnews());//���
		
		fragments.add(new SubFragmentMainHotnews());//ר��
		
		fragments.add(new SubFragmentMainHotnews());//����
		
		fragments.add(new SubFragmentMainHotnews());//ת��
		
		fragments.add(new SubFragmentMainHotnews());//����
		
	
		
fragments.add(new SubFragmentMainHotnews());//���
		
		fragments.add(new SubFragmentMainHotnews());//ר��
		
		fragments.add(new SubFragmentMainHotnews());//����
		
		fragments.add(new SubFragmentMainHotnews());//ת��
		
		fragments.add(new SubFragmentMainHotnews());//����
//		fragments.add(new SubFragmentEA());//Ӣ��
//		
//		fragments.add(new SubFragmentSA());//����
//		
//		fragments.add(new SubFragmentGA());//�¼�
//		
//		fragments.add(new SubFragmentIA());//���
//		
//		fragments.add(new SubFragmentOther());//����
		}
		return fragments;
	}

}
