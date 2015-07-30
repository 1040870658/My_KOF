package com.kof.activity;

import com.example.kof.R;
import com.kof.utils.GlobalData;

import android.R.anim;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;


public class MainActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;
	
	private void initTabHost(){
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(),android.R.id.tabcontent);
	}
	
	private View getIndicatorView(int index){
		return getLayoutInflater().inflate(GlobalData.tab_layouts[index], null);
	}
	
	private void setTitleStyle(){
		getActionBar().setDisplayHomeAsUpEnabled(false);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(false);
		getActionBar().setDisplayShowTitleEnabled(false);
	    getActionBar().setDisplayShowCustomEnabled(true);	
		View actionbarLayout = LayoutInflater.from(this).inflate(
					R.layout.title_style, null);
		getActionBar().setCustomView(actionbarLayout);
	}
	
	
	private void initView(){
		for(int i = 0;i != GlobalData.num_of_fragments;i ++){
			View indicatorView = getIndicatorView(i);
			mTabHost.addTab(mTabHost.newTabSpec(GlobalData.fragment_tags[i]).setIndicator(indicatorView),
					GlobalData.fragment_class[i],new Bundle());
		}
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleStyle();
        setContentView(R.layout.activity_main);
        initTabHost();
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
