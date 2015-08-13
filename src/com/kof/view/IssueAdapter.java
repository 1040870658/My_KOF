package com.kof.view;

import java.util.ArrayList;

import android.database.DataSetObserver;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

public class IssueAdapter extends PagerAdapter{
    
    private ArrayList<View> viewlist;

    public IssueAdapter(ArrayList<View> viewlist) {
        this.viewlist = viewlist;
    }

    @Override
    public int getCount() {
        return viewlist.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }
     @Override  
     public void destroyItem(ViewGroup container, int position,  
             Object object) {  
     }  
     @Override  
     public Object instantiateItem(ViewGroup container, int position) {
         //对ViewPager页号求模取出View列表中要显示的项
    	 ViewGroup group = (ViewGroup) viewlist.get(position).getParent();
			if (group != null) {
				group.removeView(viewlist.get(position));
			}
			((ViewPager) container).addView(viewlist.get(position));
			return viewlist.get(position);
     }

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		if(observer != null)
			super.unregisterDataSetObserver(observer);
	}

	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return POSITION_NONE;
	}  
     
}
