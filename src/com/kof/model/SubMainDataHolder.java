package com.kof.model;

import java.util.LinkedList;
import java.util.List;

import android.R.id;
public class SubMainDataHolder{
	
	private LinkedList<String> tListItems;
	private LinkedList<String> sListItems;
	private LinkedList<String> imageURLs;
	private LinkedList<String> idItems;
	
	public SubMainDataHolder(){
		tListItems = new LinkedList<String>();
		sListItems = new LinkedList<String>();
		imageURLs = new LinkedList<String>();
		idItems = new LinkedList<String>();
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
	public List<String> getId(){
		return idItems;
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
	public void addId(String id){
		idItems.add(id);
	}
	public void clear(){
		tListItems.clear();
		sListItems.clear();
		imageURLs.clear();
		idItems.clear();
	}
}
