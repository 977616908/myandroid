package com.ifidc.traffic.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.ifidc.traffic.R;
import com.ifidc.traffic.adapter.GridViewAdapter;
import com.ifidc.traffic.adapter.GuidePageAdapter;
import com.ifidc.traffic.adapter.TypeAdapter;
import com.ifidc.traffic.data.AppData;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SurfingActivity extends Activity{
	private Button back_btn;//返回按钮
	private TextView title_textView;//标题
	private ViewPager viewPager;//滑动Viewpage
	private GuidePageAdapter guidePageAdapter;//Viewpage的Adapter
	private List<View> pageViews;// 显示的View列表
	private List<List<AppData>> lists;
	private List<GridViewAdapter> adapterList;
	private List<TextView> tvList;
	private ImageView cursor;// 动画图片
	private int offset = 0;// 动画图片偏移量
	private int currIndex = 0;// 当前页卡编号
	private int bmpW;// 动画图片宽度

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_surfing);
		initView();

	}
	
	/**
	 * 构建视图
	 */
	public void initView() {
		pageViews=new ArrayList<View>();
		lists=new ArrayList<List<AppData>>();
		adapterList=new ArrayList<GridViewAdapter>();
		viewPager = (ViewPager) findViewById(R.id.vPager);
		InitImageView();
		InitTextView();
		InitViewPager();
	}
	

	/**
	 * 初始化头标
	 */
	private void InitTextView() {
		tvList=new ArrayList<TextView>();
		tvList.add((TextView)findViewById(R.id.text1));
		tvList.add((TextView)findViewById(R.id.text2));
		tvList.add((TextView)findViewById(R.id.text3));
		tvList.add((TextView)findViewById(R.id.text4));
		tvList.add((TextView)findViewById(R.id.text5));
		for(int i=0;i<tvList.size();i++){
			tvList.get(i).setOnClickListener(new MyOnClickListener(i));
		}
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
	};

	/**
	 * 初始化ViewPager
	 */
	private void InitViewPager() {
		guidePageAdapter = new GuidePageAdapter(pageViews);
		
		/**
		 * 初始化需要的Activity,加到View数组中
		 */
		createListView();
		createListView();
		createListView();
		createListView();
		createListView();
		viewPager.setAdapter(guidePageAdapter);
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}
	
	/**
	 * 创建LsitView
	 * @return 返回显示的ListView
	 */
	public void createListView(){
		GridView gridView = new GridView(this);
		gridView.setNumColumns(2);
		gridView.setVerticalSpacing(10);
		gridView.setHorizontalSpacing(10);
		List<AppData> list=new ArrayList<AppData>();
		AppData data=new AppData();
		data.setApp_name("aaaa");
		data.setApp_type("小说");
		list.add(data);
		list.add(data);
		list.add(data);
		list.add(data);
		GridViewAdapter adapter=new GridViewAdapter(this,list);
		gridView.setAdapter(adapter);
		adapterList.add(adapter);
		lists.add(list);
		pageViews.add(gridView);
	}
	/**
	 * 初始化动画
	 */
	private void InitImageView() {
		cursor = (ImageView) findViewById(R.id.cursor);
		bmpW = BitmapFactory.decodeResource(getResources(),
				R.drawable.blue_line).getWidth();// 获取图片宽度
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;// 获取分辨率宽度
		offset = screenW / 5 ;// 计算偏移量
		Matrix matrix = new Matrix();
		matrix.postTranslate(0, 0);
		float f=(float)offset/(float)bmpW;
		matrix.postScale(f, 1);
		cursor.setImageMatrix(matrix);// 设置动画初始位置
	}

	/**
	 * 页卡切换监听
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		int one = offset ;// 页卡1 -> 页卡2 偏移量

		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			animation = new TranslateAnimation(currIndex*one, arg0*one, 0, 0);
			tvList.get(currIndex).setTextColor(getResources().getColor(R.color.store_detail_text_color_black));
			currIndex = arg0;
			tvList.get(currIndex).setTextColor(getResources().getColor(R.color.blue));
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
}
