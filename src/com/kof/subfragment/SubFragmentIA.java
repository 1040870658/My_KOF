package com.kof.subfragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.kof.R;
import com.kof.adapter.SubMainHotnewsAdapter;
import com.kof.model.SubMainDataHolder;
import com.kof.net.LoadingTask;
import com.kof.utils.DataRefreshHandler;
import com.kof.utils.Holder;
import com.kof.utils.SubMainHolder;

public class SubFragmentIA extends SubFragmentMain{
	private RequestQueue mQueue;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		adapter = new SubMainHotnewsAdapter(getActivity(),
				 dataHolder);
		dataRefreshHandler = new DataRefreshHandler(adapter);
		// CustomApplication.getRefWatcher(getActivity()).watch(this);
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	protected void setUpDataHolder() {
		// TODO Auto-generated method stub
		this.dataHolder = new SubMainDataHolder();
		dataURL = "http://www.dongqiudi.com/archives/4?page=";
		mQueue = Volley.newRequestQueue(fatherActivity);
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
				"http://www.dongqiudi.com/archives/4?page=1", null,
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						JSONArray jsonArray;
						
						try {
							jsonArray = response.getJSONArray("data");
							for (int i = 0; i != jsonArray.length(); i++) {
								JSONObject jsonObject = jsonArray
										.getJSONObject(i);
								dataHolder.addImage(jsonObject.getString("thumb"));
								dataHolder.addTitle(jsonObject.getString("title"));
								dataHolder.addDescription(jsonObject.getString("description"));
							}
							adapter.notifyDataSetChanged();
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
		count++;
		mQueue.add(jsonObjectRequest);
	}

	@Override
	protected AsyncTask<Void, Void, String> runRefreshTask(
			PullToRefreshListView listView) {
		// TODO Auto-generated method stub
		// return new LoadingTask(mPullToRefreshListView);
		return new LoadingTask(mPullToRefreshListView,fatherActivity,dataURL+1,
				  dataRefreshHandler,dataHolder);
	}

}
