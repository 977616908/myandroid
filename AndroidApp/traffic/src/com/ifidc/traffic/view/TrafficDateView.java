package com.ifidc.traffic.view;

import java.util.ArrayList;
import java.util.List;

import com.ifidc.traffic.R;
import com.ifidc.traffic.util.DateTypeUtil;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TrafficDateView extends LinearLayout{
	private List<Long> list;
	private List<Long> reList=new ArrayList<Long>();
	private TextView up_tv;
	private TextView up_speend_tv;
	private TextView down_tv;
	private TextView down_speed_tv;
	private TextView total_tv;
	private TextView total_speed_tv;
	private TextView wifi_up_tv;
	private TextView wifi_up_speend_tv;
	private TextView wifi_down_tv;
	private TextView wifi_down_speed_tv;
	private TextView wifi_total_tv;
	private TextView wifi_total_speed_tv;
	private List<TextView> textViewList;
	public TrafficDateView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(R.layout.view_traffic_date, this);
		initView();
	}
	
	public void setData(List<Long> _list){
		list=_list;
		if(reList.size()==0){
			reList.addAll(list);
		}
		for(int i=0;i<list.size();i++){
			long data = list.get(i);
			long diff=reList.get(i);
			textViewList.get(2*i).setText(DateTypeUtil.unitHandler(data<=-1?0:data));
			textViewList.get(2*i+1).setText(diff==0?"0B/S":(DateTypeUtil.unitHandler(data<=-1?0:(data
					-diff ))+"/S"));
			reList.set(i, data);
		}
	}
	public void initView(){
		textViewList=new ArrayList<TextView>();
		up_tv=(TextView) findViewById(R.id.up_textView);
		up_speend_tv=(TextView) findViewById(R.id.up_speed_textView);
		down_tv=(TextView) findViewById(R.id.down_textView);
		down_speed_tv=(TextView) findViewById(R.id.down_speed_textView);
		total_tv=(TextView) findViewById(R.id.total_textView);
		total_speed_tv=(TextView) findViewById(R.id.total_speed_textView);
		wifi_up_tv=(TextView) findViewById(R.id.wifi_up_textView);
		wifi_up_speend_tv=(TextView) findViewById(R.id.wifi_up_speed_textView);
		wifi_down_tv=(TextView) findViewById(R.id.wifi_down_textView);
		wifi_down_speed_tv=(TextView) findViewById(R.id.wifi_down_speed_textView);
		wifi_total_tv=(TextView) findViewById(R.id.wifi_total_textView);
		wifi_total_speed_tv=(TextView) findViewById(R.id.wifi_total_speed_textView);
		textViewList.add(up_tv);
		textViewList.add(up_speend_tv);
		textViewList.add(down_tv);
		textViewList.add(down_speed_tv);
		textViewList.add(total_tv);
		textViewList.add(total_speed_tv);
		textViewList.add(wifi_up_tv);
		textViewList.add(wifi_up_speend_tv);
		textViewList.add(wifi_down_tv);
		textViewList.add(wifi_down_speed_tv);
		textViewList.add(wifi_total_tv);
		textViewList.add(wifi_total_speed_tv);
	}
	

}
