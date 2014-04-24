package com.ifidc.traffic.view;

import java.util.ArrayList;
import java.util.List;

import com.ifidc.traffic.R;
import com.ifidc.traffic.data.AppData;
import com.ifidc.traffic.util.ImageCache;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomePageAppView extends LinearLayout{
	private ImageView imageView;
	private TextView textView;
	private ImageView imageView1;
	private TextView textView1;
	private ImageView imageView2;
	private TextView textView2;
	private ImageView imageView3;
	private TextView textView3;
	private ImageView imageView4;
	private TextView textView4;
	private ImageView imageView5;
	private TextView textView5;
	private List<ImageView> imageList=new ArrayList<ImageView>();
	private List<TextView> textList=new ArrayList<TextView>();
	private ImageCache imageCache;
	public HomePageAppView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(R.layout.view_homepage_app, this);
		initView();
		imageCache=ImageCache.getInstance(context);
	}
	
	public void initView(){
		imageView=(ImageView) findViewById(R.id.home_page_imageView);
		imageView1=(ImageView) findViewById(R.id.home_page_imageView1);
		imageView2=(ImageView) findViewById(R.id.home_page_imageView2);
		imageView3=(ImageView) findViewById(R.id.home_page_imageView3);
		imageView4=(ImageView) findViewById(R.id.home_page_imageView4);
		imageView5=(ImageView) findViewById(R.id.home_page_imageView5);
		imageList.add(imageView);
		imageList.add(imageView1);
		imageList.add(imageView2);
		imageList.add(imageView3);
		imageList.add(imageView4);
		imageList.add(imageView5);
		textView=(TextView) findViewById(R.id.home_page_textView);
		textView1=(TextView) findViewById(R.id.home_page_textView1);
		textView2=(TextView) findViewById(R.id.home_page_textView2);
		textView3=(TextView) findViewById(R.id.home_page_textView3);
		textView4=(TextView) findViewById(R.id.home_page_textView4);
		textView5=(TextView) findViewById(R.id.home_page_textView5);
		textList.add(textView);
		textList.add(textView1);
		textList.add(textView2);
		textList.add(textView3);
		textList.add(textView4);
		textList.add(textView5);
	}
	public void setData(List<AppData> list){
		for(int i=0;i<list.size();i++){
			AppData data=list.get(i);
			imageCache.fetchDrawableOnThread(data.getApp_url(), imageList.get(i), R.drawable.app_defaule);
			textList.get(i).setText(data.getApp_name());
		}
	}
}
