package com.kof.utils;

import java.util.ArrayList;

import com.kof.model.GlobalData;

import android.content.Context;
import android.util.Log;

public class HolderFactory {
	private Context context;
	private ArrayList<Holder> holderArrayList;
	
	public HolderFactory(Context context){
		this.context = context;
		holderArrayList = new ArrayList<Holder>();
	}
	public Holder generateHolder(int type,int resid){
		if(GlobalData.TEXT_TYPE == type){
			for(Holder holder : holderArrayList){
				if(holder.getTag() == type && holder.getResid() == resid){
					return holder;
				}
			}
			Holder holder = new SubMainHolder(context,resid);
			holderArrayList.add(holder);
			return holder;
		}
		else{
			for(Holder holder : holderArrayList){
				if(holder.getTag() == type && holder.getResid() == resid){
					return holder;
				}
			}
			Holder holder = new SubMainImageHolder(context,resid);
			holderArrayList.add(holder);
			return holder;
		}
	}
}
