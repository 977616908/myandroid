package com.ifidc.traffic.activity;

import java.util.ArrayList;
import java.util.List;

import com.ifidc.traffic.R;
import com.ifidc.traffic.adapter.App_Traffic_Adapter;
import com.ifidc.traffic.adapter.GuidePageAdapter;
import com.ifidc.traffic.adapter.Traffic_Date_Adapter;
import com.ifidc.traffic.data.AppTrafficData;
import com.ifidc.traffic.util.AppUtil;
import com.ifidc.traffic.view.TrafficDateView;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.BoringLayout;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Traffc_ManagerActivity extends Activity {
	private RadioGroup radio_grGroup;
	private Traffic_Date_Adapter month_adapter;
	private Traffic_Date_Adapter day_adapter;
	private App_Traffic_Adapter app_adapter;
	private List<Long> monthList;
	private List<Long> dayList;
	private List<AppTrafficData> appList=new ArrayList<AppTrafficData>();
	private GridView appListView;
	private ViewPager viewPager;// 滑动Viewpage
	private GuidePageAdapter guidePageAdapter;// Viewpage的Adapter
	private ImageView cursor;// 动画图片
	private int currIndex = 0;// 当前页卡编号
	private int bmpW;// 动画图片宽度
	private TextView t1, t2;
	private List<View> pageViews;// 显示的View列表
	private View view1;
	private View view2;
	private Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			if(msg.what==0){
				new Thread(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						appList.addAll(AppUtil.getAppList(Traffc_ManagerActivity.this));
						handler.sendEmptyMessage(1);
					}
					
				}.start();
			}else{
				app_adapter.notifyDataSetChanged();
				appListView.invalidate();
			}
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_traffic_manager);
		initView();
		new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				registerReceiver(new DataRecevier(), new IntentFilter("data"));
				handler.sendEmptyMessage(0);
			}
			
		}.start();
	}

	public void initView() {
		pageViews = new ArrayList<View>();
		radio_grGroup = (RadioGroup) findViewById(R.id.radiao);
		viewPager = (ViewPager) findViewById(R.id.vPager);
		cursor = (ImageView) findViewById(R.id.cursor);
		view1=findViewById(R.id.lay_1);
		view2=findViewById(R.id.lay_2);
		InitTextView();
		InitViewPager();
		radio_grGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(checkedId==R.id.radio_app){
					view1.setVisibility(View.VISIBLE);
					view2.setVisibility(View.GONE);
				}else{
					view1.setVisibility(View.GONE);
					view2.setVisibility(View.VISIBLE);
				}
			}
		});
		((RadioButton)radio_grGroup.getChildAt(0)).setChecked(true);
	}


	/**
	 * 初始化头标
	 */
	private void InitTextView() {
		t1 = (TextView) findViewById(R.id.text2);
		t2 = (TextView) findViewById(R.id.text3);
		t1.setOnClickListener(new MyOnClickListener(1));
		t2.setOnClickListener(new MyOnClickListener(0));
	}

	/**
	 * 头标点击监听
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			viewPager.setCurrentItem(index);
		}
	}

	/**
	 * 初始化ViewPager
	 */
	private void InitViewPager() {
		monthList = new ArrayList<Long>();
		dayList=new ArrayList<Long>();
		appList=new ArrayList<AppTrafficData>();
		for (int i = 0; i <6; i++) {
			monthList.add((long) 0.00);
			dayList.add((long) 0.00);
		}
		createListView();
		guidePageAdapter = new GuidePageAdapter(pageViews);
		viewPager.setAdapter(guidePageAdapter);
		/**
		 * 初始化需要的Activity,加到View数组中
		 */
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}

	/**
	 * 创建LsitView
	 * 
	 * @return 返回显示的ListView
	 */
	public void createListView() {
		month_adapter = new Traffic_Date_Adapter(this, monthList);
		day_adapter=new Traffic_Date_Adapter(this, dayList);
		TrafficDateView trafficDateView=new TrafficDateView(this);
		trafficDateView.setData(monthList);
		TrafficDateView trafficDateView1=new TrafficDateView(this);
		trafficDateView1.setData(dayList);
		pageViews.add(trafficDateView);
		pageViews.add(trafficDateView1);
		appListView=(GridView) findViewById(R.id.listView);
		app_adapter=new App_Traffic_Adapter(this, appList);
		appListView.setAdapter(app_adapter);
	}

	/**
	 * 页卡切换监听
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		int one = bmpW / 2;// 页卡1 -> 页卡2 偏移量

		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			View v = findViewById(R.id.cursor);
			one = v.getWidth();
			switch (arg0) {
			case 0:
				if (currIndex == 1) {
					animation = new TranslateAnimation(one, 0, 0, 0);
				}
				break;
			case 1:
				if (currIndex == 0) {
					animation = new TranslateAnimation(0, one, 0, 0);
				}
				break;
			}
			currIndex = arg0;
			animation.setFillAfter(true);// True:图片停在动画结束位置
			animation.setDuration(300);
			cursor.startAnimation(animation);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}

	private class DataRecevier extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			long[] datas=intent.getLongArrayExtra("traffic");
			for(int i=0;i<datas.length;i++){
				if(dayList.get(i)!=datas[i]){
					dayList.set(i, datas[i]);
					monthList.set(i,datas[i]);
				}
			}
			((TrafficDateView)pageViews.get(0)).setData(monthList);
			((TrafficDateView)pageViews.get(1)).setData(dayList);
		}
		
	}
}
