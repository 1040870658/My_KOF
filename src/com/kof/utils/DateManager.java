package com.kof.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.SharedPreferences;

public class DateManager {
	private SimpleDateFormat format;
	private Date curDate;
	private String dateString;
	public DateManager(Date date,String pattern){
		this.curDate = date;
		format = new SimpleDateFormat(pattern);
		dateString = format.format(curDate);
	}
	public boolean isToday(String dateString) throws ParseException{
		SimpleDateFormat day_format = new SimpleDateFormat("MM月dd日");
		Date date = format.parse(dateString);
		String dayString = day_format.format(date);
		String curDay = day_format.format(curDate);
		if(dateString.equals(curDay)){
			return true;
		}
		return false;
	}
	public void insertToshare(SharedPreferences sharedPreferences,String key){
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(key, dateString);
		editor.commit();
	}
	public String getFromshare(SharedPreferences sharedPreferences,String key){
		return sharedPreferences.getString(key, "1月1日");
	}
	public void setFormat(String pattern){
		format = new SimpleDateFormat(pattern);
		dateString = format.format(curDate);
	}
	public String getDateString(){
		return dateString;
	}
}
