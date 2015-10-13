package com.kof.model;

import java.util.LinkedList;
import java.util.List;
public class SubMainDataHolder{
	
	private LinkedList<String> tListItems;
	private LinkedList<String> sListItems;
	private LinkedList<String> imageURLs;
	
	public SubMainDataHolder(){
		tListItems = new LinkedList<String>();
		sListItems = new LinkedList<String>();
		imageURLs = new LinkedList<String>();
	}
	public List<String> getTitleSet(){
		return tListItems;
	}
	public List<String> getSummarySet(){
		return sListItems;
	}
	public List<String> getImgSet(){
		return imageURLs;
	}
	public int getLength(){
		return tListItems.size();
	}
	public void addTitle(String title){
		tListItems.add(title);
	}
	public void addDescription(String description){
		sListItems.add(description);
	}
	public void addImage(String url){
		imageURLs.add(url);
	}
}
