package com.ifidc.traffic.adapter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.ifidc.traffic.R;
import com.ifidc.traffic.util.DateTypeUtil;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Traffic_Date_Adapter extends BaseAdapter {
	private List<Long> list;
	private Context context;
	private List<Long> reList=new ArrayList<Long>();
	public Traffic_Date_Adapter(Context context, List<Long> list) {
		this.list = list;
		reList.addAll(list);
		this.context = context;
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
		if (arg1 == null || arg1.getTag() == null) {
			Holder tHolder = new Holder();
			arg1 = LayoutInflater.from(context).inflate(
					R.layout.adapter_traffic_date, null);
			tHolder.textView = (TextView) arg1.findViewById(R.id.textView);
			tHolder.total = (TextView) arg1.findViewById(R.id.total_tv);
			tHolder.v_tv = (TextView) arg1.findViewById(R.id.v_tv);
			arg1.setTag(tHolder);
		}
		if (arg0 == 0 || arg0 == 4 || arg0 == 8) {
			TextView tv = new TextView(context);
			switch (arg0) {
			case 0:
				tv.setText("移动数据");
				break;
			case 4:
				tv.setText("WIFI数据");
				break;
			case 8:
				tv.setText("总流量");
				break;
			}
			tv.setPadding(2, 2, 3, 3);
			return tv;
		}
		holder = (Holder) arg1.getTag();
		long data = list.get(arg0);

		switch (arg0 % 4) {
		case 1:
			holder.textView.setText("上传:");
			break;
		case 2:
			holder.textView.setText("下载:");
			break;
		case 3:
			holder.textView.setText("总计:");
			break;
		}
		holder.total.setText(DateTypeUtil.unitHandler(data<=-1?0:data));
		long diff=reList.get(arg0);
		holder.v_tv.setText(diff==0?"0B/S":(DateTypeUtil.unitHandler(data<=-1?0:(data
				-diff ))+"/S"));
		reList.set(arg0, data);
		return arg1;
	}

	class Holder {
		TextView textView;
		TextView total;
		TextView v_tv;
	}

}
