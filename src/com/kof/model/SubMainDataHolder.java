package com.kof.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.kof.R;
public class SubMainDataHolder extends DataHolder{
	
	private String[] mStrings = { "Abbaye de Belloc",
			"Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
			"Acorn","曼城3-0西布朗，亚亚图雷梅开二度","news"};
	private int[] imgId = { R.drawable.news_1, R.drawable.news_2,
			R.drawable.news_3, R.drawable.news_4, R.drawable.news_5,
			R.drawable.news_6,R.drawable.news_7 };
	private LinkedList<String> mListItems;
	private LinkedList<String> sListItems;
	private LinkedList<String> imageURLs;
	
	public SubMainDataHolder(){
		mListItems = new LinkedList<String>();
		sListItems = new LinkedList<String>();
		imageURLs = new LinkedList<String>();
		sListItems.addAll(Arrays.asList(mStrings));
		mListItems.addAll(Arrays.asList(mStrings));
		for(int item : imgId){
			imageURLs.add("drawable://"+item);
		}
		imageURLs.add("http://img.dongqiudi.com/uploads8/allimg/150820/526-150R0043024419-lp.jpg!cover");
	}
	public List<String> getTitleSet(){
		return mListItems;
	}
	public List<String> getSummarySet(){
		return sListItems;
	}
	public List<String> getImgSet(){
		return imageURLs;
	}
	public int getLength(){
		return mListItems.size();
	}
	public void addTitle(String title){
		mListItems.addFirst(title);
		sListItems.addFirst(title);
	}
	public void addImage(String url){
		imageURLs.addFirst(url);
	}
}
