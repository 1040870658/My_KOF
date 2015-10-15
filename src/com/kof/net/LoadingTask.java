package com.kof.net;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kof.adapter.SubMainAdapter;
import com.kof.model.SubMainDataHolder;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class LoadingTask extends AsyncTask<Void, Void, String>{

	protected PullToRefreshListView mPullToRefreshListView;
	private SubMainDataHolder dataHolder;
	private SubMainAdapter adapter;
	private RequestQueue mQueue;
	private Context context;
	private String url;
	public LoadingTask(PullToRefreshListView mPullToRefreshListView,Context context,String url,SubMainAdapter adapter,SubMainDataHolder dataHolder){
		super();
		this.adapter = adapter;
		this.dataHolder = dataHolder;
		this.mPullToRefreshListView = mPullToRefreshListView; 
		this.context = context;
		this.url = url;
	}
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		try {
			RequestData();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		mPullToRefreshListView.onRefreshComplete();
		super.onPostExecute(result);
	}
	private void RequestData(){
		mQueue = Volley.newRequestQueue(context);
		dataHolder.clear();
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
				url, null,
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						JSONArray jsonArray;
						
						try {
							jsonArray = response.getJSONArray("data");
							for (int i = 0; i != jsonArray.length(); i++) {
								JSONObject jsonObject = jsonArray
										.getJSONObject(i);
								synchronized (dataHolder) {
									dataHolder.addImage(jsonObject.getString("thumb"));
									dataHolder.addTitle(jsonObject.getString("title"));
									dataHolder.addDescription(jsonObject.getString("description"));
								}
								adapter.notifyDataSetChanged();
							}
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("TAG", error.getMessage(), error);
					}
				});
		mQueue.add(jsonObjectRequest);
	}
	
}
