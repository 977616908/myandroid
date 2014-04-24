package com.ifidc.traffic.adapter;

import java.util.ArrayList;
import java.util.List;

import com.ifidc.traffic.R;
import com.ifidc.traffic.data.AppData;
import com.ifidc.traffic.util.ImageCache;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter{
	private Context context;
	private List<AppData> list=new ArrayList<AppData>();
	public GridViewAdapter(Context context,List<AppData> list){
		this.context=context;
		this.list.addAll(list);
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			ViewHold viewHold=new ViewHold();
			convertView=LayoutInflater.from(context).inflate(R.layout.adapter_gridview, null);
			viewHold.imageView=(ImageView) convertView.findViewById(R.id.gridView_imageView);
			viewHold.textView=(TextView) convertView.findViewById(R.id.gridView_textView);
			viewHold.tv=(TextView) convertView.findViewById(R.id.gridView_typeTextView);
			convertView.setTag(viewHold);
		}
		ViewHold hViewhold=(ViewHold) convertView.getTag();
		AppData appData=list.get(arg0);
		if(appData.getCode()==0){
			ImageCache.getInstance(context).fetchDrawableOnThread(appData.getApp_url(), hViewhold.imageView, R.drawable.app_defaule);
		}else{
			hViewhold.imageView.setBackgroundResource(appData.getCode());
		}
		hViewhold.textView.setText(appData.getApp_name());
		hViewhold.tv.setText(appData.getApp_type());
		return convertView;
	}
	
	private class ViewHold{
		ImageView imageView;
		TextView textView;
		TextView tv;
	}
}
