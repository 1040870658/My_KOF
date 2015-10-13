package com.kof.activity;

import java.util.ArrayList;

import org.apache.http.conn.scheme.Scheme;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.kof.adapter.TextSettingAdapter;
import com.kof.model.GlobalData;
import com.kof.utils.SplashDialog;

import com.kof.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class MainActivity extends FragmentActivity {
	private DrawerLayout drawerLayout;
	private RelativeLayout drawerSettings;
	private FragmentTabHost mTabHost;
	private Dialog splashDialog ;
	private ArrayAdapter<String> arrayAdapter;
	private ArrayList<String>individual_items;
	private ActionBarDrawerToggle drawerbar;
	private TextSettingAdapter textSettingAdapter;
	
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
		individual_items = new ArrayList<String>();
		individual_items.add("关于");
		individual_items.add("意见反馈");
		individual_items.add("推荐给好友");
		individual_items.add("给我们评分 ");
		individual_items.add("语言");
		individual_items.add("设置");
		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,individual_items);
		textSettingAdapter = new TextSettingAdapter(individual_items, this);
		drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
		drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
		drawerSettings = (RelativeLayout) drawerLayout.findViewById(R.id.main_right_drawer_layout);
		ListView listView = (ListView) drawerSettings.findViewById(R.id.lv_individual);
		listView.setAdapter(textSettingAdapter);
		for(int i = 0;i != GlobalData.num_of_fragments;i ++){
			View indicatorView = getIndicatorView(i);
			mTabHost.addTab(mTabHost.newTabSpec(GlobalData.fragment_tags[i]).setIndicator(indicatorView),
					GlobalData.fragment_class[i],new Bundle());
		}
		ImageView imageView = (ImageView) drawerLayout.findViewById(R.id.riv_image);
		ImageLoader imageLoader = ImageLoader.getInstance();
		DisplayImageOptions options = new DisplayImageOptions.Builder()
	    .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
	    .cacheInMemory(true)
	    .cacheOnDisk(true)
	    .resetViewBeforeLoading(true)
	    .displayer(new RoundedBitmapDisplayer(112)).build();
		imageLoader.displayImage("drawable://"+R.drawable.individual,imageView, options);
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        splashDialog = new SplashDialog(this, R.style.mydialog);
        splashDialog.show();
        //setTitleStyle();
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
    public void Switch(View view){
    	if(drawerLayout.isDrawerOpen(drawerSettings)){
    		drawerLayout.closeDrawer(drawerSettings);
    	}
    	else{
    		drawerLayout.openDrawer(drawerSettings);
    	}
    }
   }
