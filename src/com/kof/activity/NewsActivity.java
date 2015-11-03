package com.kof.activity;

import com.kof.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NewsActivity extends Activity{

	private Bundle info;
	private String url = "http://www.dongqiudi.com/article/";
	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_layout);
		info = getIntent().getBundleExtra("news");
		String id = info.getString("id");
		url += id;
		webView = (WebView) findViewById(R.id.wv_news);
		Log.e("url", url);
		webView.loadUrl(url);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.setWebViewClient(new WebViewClient(){
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				view.loadUrl(url);// 使用当前WebView处理跳转
				return true;//true表示此事件在此处被处理，不需要再广播
			}
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				// TODO Auto-generated method stub
			}
		});
	}
	
}
