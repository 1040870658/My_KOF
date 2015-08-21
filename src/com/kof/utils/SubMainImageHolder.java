package com.kof.utils;

import java.util.ArrayList;


import com.kof.R;
import com.kof.model.GlobalData;
import com.kof.model.SubMainImageDataHolder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SubMainImageHolder implements Holder{
	private int Tag = GlobalData.IMAGE_TYPE;
	private int resid;
	private Context context;
	private ImageView imageView_1;
	private ImageView imageView_2;
	private ImageView imageView_3;
	private TextView titleTextView;
	private SubMainImageDataHolder subMainImageDataHolder;
	private ArrayList<String> titleArrayList;
	private ArrayList<int[]> imgArrayList;
	public SubMainImageHolder(Context context,int resid){
		this.context = context;
		subMainImageDataHolder = new SubMainImageDataHolder();
		titleArrayList = subMainImageDataHolder.getTitle();
		imgArrayList = subMainImageDataHolder.getImgList();
		this.resid = resid;
		
	}
	@Override
	public void setUp(View convertView) {
		// TODO Auto-generated method stub
		imageView_1 = (ImageView) convertView.findViewById(R.id.iv_imgdata_1);
		imageView_2 = (ImageView) convertView.findViewById(R.id.iv_imgdata_2);
		imageView_3 = (ImageView) convertView.findViewById(R.id.iv_imgdata_3);
		titleTextView = (TextView) convertView.findViewById(R.id.tv_title);
		LinearLayout.LayoutParams params_1 = new LinearLayout.LayoutParams(
				GlobalData.getScreenWidth(context)/4,
				GlobalData.getScreenHeight(context)/10);
//		params_1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
//		imageView_1.setLayoutParams(params_1);
		
		LinearLayout.LayoutParams params_2 = new LinearLayout.LayoutParams(
				GlobalData.getScreenWidth(context)/4,
				GlobalData.getScreenHeight(context)/10);
//		params_2.addRule(RelativeLayout.CENTER_HORIZONTAL);
//		imageView_2.setLayoutParams(params_2);
		
		LinearLayout.LayoutParams params_3 = new LinearLayout.LayoutParams(
				GlobalData.getScreenWidth(context)/4,
				GlobalData.getScreenHeight(context)/10);
//		params_1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//		imageView_3.setLayoutParams(params_3);
	}

	@Override
	public void refreshData(int position) {
		// TODO Auto-generated method stub
		titleTextView.setText(titleArrayList.get(0));
		imageView_1.setBackgroundResource(R.drawable.img_news1_1);
		imageView_2.setBackgroundResource(R.drawable.img_news2_1);
		imageView_3.setBackgroundResource(R.drawable.img_news3_1);
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 4;
	}
	public int getTag(){
		return Tag;
	}
	@Override
	public int getResid() {
		// TODO Auto-generated method stub
		return resid;
	}
}
