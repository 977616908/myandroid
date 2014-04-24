package com.ifidc.traffic.adapter;

import java.util.List;

import com.ifidc.traffic.R;
import com.ifidc.traffic.adapter.Traffic_Date_Adapter.Holder;
import com.ifidc.traffic.data.AppTrafficData;
import com.ifidc.traffic.util.DateTypeUtil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class App_Traffic_Adapter extends BaseAdapter{
	private List<AppTrafficData> list;
	private Context context;
	public App_Traffic_Adapter(Context context,List<AppTrafficData> list){
		this.context=context;
		this.list=list;
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
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		Holder holder = new Holder();
		if (arg1 == null) {
			Holder tHolder = new Holder();
			arg1 = LayoutInflater.from(context).inflate(
					R.layout.adapter_app, null);
			tHolder.up = (TextView) arg1.findViewById(R.id.up_tv);
			tHolder.down = (TextView) arg1.findViewById(R.id.down_tv);
			tHolder.total = (TextView) arg1.findViewById(R.id.total_tv);
			tHolder.app_name=(TextView) arg1.findViewById(R.id.app_name);
			tHolder.app_image=(ImageView) arg1.findViewById(R.id.app_image);
			arg1.setTag(tHolder);
		}
		holder=(Holder) arg1.getTag();
		AppTrafficData data=list.get(arg0);
		holder.app_name.setText(data.getApp_name());
		holder.up.setText("上传："+DateTypeUtil.unitHandler(data.getUp()));
		holder.down.setText("下载："+DateTypeUtil.unitHandler(data.getDown()));
		holder.total.setText("总计："+DateTypeUtil.unitHandler(data.getTotal()));
		holder.app_image.setBackgroundDrawable(data.getApp_Image());
		return arg1;
	}

	class Holder {
		TextView up;
		TextView down;
		TextView total;
		TextView app_name;
		ImageView app_image;
	}

}
