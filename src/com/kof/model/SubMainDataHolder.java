package com.kof.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.example.kof.R;

public class SubMainDataHolder {
	
	private String[] mStrings = { "Abbaye de Belloc",
			"Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
			"Acorn","曼城3-0西布朗，亚亚图雷梅开二度"};
	private int[] imgId = { R.drawable.news_1, R.drawable.news_2,
			R.drawable.news_3, R.drawable.news_4, R.drawable.news_5,
			R.drawable.news_6,R.drawable.news_7 };
	private List<String> mListItems;
	private List<String> sListItems;
	
	public SubMainDataHolder(){
		mListItems = new LinkedList<String>();
		sListItems = new ArrayList<String>();
		sListItems.addAll(Arrays.asList(mStrings));
		mListItems.addAll(Arrays.asList(mStrings));
	}
	public List<String> getTitleSet(){
		return mListItems;
	}
	public List<String> getSummarySet(){
		return sListItems;
	}
	public int[] getImgSet(){
		return imgId;
	}
	public int getLength(){
		return mListItems.size();
	}
}
