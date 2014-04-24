package com.ifidc.traffic.activity;

import java.util.ArrayList;
import java.util.List;

import com.ifidc.traffic.R;
import com.ifidc.traffic.adapter.GridViewAdapter;
import com.ifidc.traffic.data.AppData;
import com.ifidc.traffic.util.ImageCache;
import com.ifidc.traffic.view.HomePageAppView;
import com.ifidc.traffic.view.RoundImageView;
import com.ifidc.traffic.view.SlideView;
import com.ifidc.traffic.view.SlideView.onChageListener;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.VpnService;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class HomePageActivity extends Activity implements OnClickListener {
	private TextView title_textView;
	private RoundImageView user_imageView;
	private TextView user_textView;
	private TextView user_socre_textView;
	private TextView user_add_traffic_textView;
	private TextView user_save;
	private TextView user_Management;
	private TextView user_advance;
	private TextView user_add;
	private List<AppData> list = new ArrayList<AppData>();
	private ImageView leftView;
	private ImageView rightView;
	private LinearLayout linearLayout;
	private List<ImageView> imageViews = new ArrayList<ImageView>();// 显示的小圆点列表
	private List<View> viewList = new ArrayList<View>();
	private SlideView slideView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initView();

	}

	public void initView() {
		setContentView(R.layout.activity_homepage);
		title_textView = (TextView) findViewById(R.id.title_textView);
		title_textView.setText(getString(R.string.homepage_text));
		findViewById(R.id.title_btn_left).setOnClickListener(this);
		findViewById(R.id.title_btn_right).setOnClickListener(this);
		findViewById(R.id.user_Management).setOnClickListener(this);
		user_imageView = (RoundImageView) findViewById(R.id.user_image);
		ImageCache.getInstance(this).fetchDrawableOnThread(null,
				user_imageView, R.drawable.user_defaule);
		user_textView = (TextView) findViewById(R.id.user_textView);
		SpannableString seatStyle = new SpannableString("Homer :159898989");
		seatStyle.setSpan(
				new ForegroundColorSpan(Color.parseColor("#FF0000")),
				7, seatStyle.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		user_textView.setText(seatStyle);
		user_socre_textView = (TextView) findViewById(R.id.user_socre_textView);
		user_add_traffic_textView = (TextView) findViewById(R.id.user_add_traffic);
		user_socre_textView.setText("账户积分:3449");
		user_add_traffic_textView.setText("充值流量Go");
		user_save = (TextView) findViewById(R.id.user_save_tv2);
		user_save.setText("58.5M");
		user_Management = (TextView) findViewById(R.id.user_Management_tv2);
		user_Management.setText("11.5M");
		user_advance = (TextView) findViewById(R.id.user_advance_tv2);
		user_advance.setText("已开启");
		user_add=(TextView) findViewById(R.id.user_add_tv2);
		for (int i = 0; i < 6; i++) {
			AppData appData = new AppData();
			appData.setApp_name("流量");
			list.add(appData);
		}
		leftView = (ImageView) findViewById(R.id.left);
		rightView = (ImageView) findViewById(R.id.right);
		leftView.setOnClickListener(this);
		rightView.setOnClickListener(this);
		slideView = (SlideView) findViewById(R.id.slideView);
		linearLayout = (LinearLayout) findViewById(R.id.imageView_lay);
		for (int i = 0; i < 3; i++) {
			ImageView imageView = new ImageView(this);
			LayoutParams l = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			l.gravity = Gravity.CENTER;
			l.rightMargin=10;
			imageView.setLayoutParams(l);
			if(i==0){
				imageView.setBackgroundResource(R.drawable.switchingkey02);
			}else{
				imageView.setBackgroundResource(R.drawable.switchingkey01);
			}
			
			imageViews.add(imageView);
			linearLayout.addView(imageView);
		}
		for (int i = 0; i < 3; i++) {
			HomePageAppView view=new HomePageAppView(this);
			view.setData(list);
			viewList.add(view);
		}
		slideView.setState(viewList, imageViews);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_btn_left:
			break;
		case R.id.title_btn_right:
			break;
		case R.id.user_Management:
			startActivity(new Intent(this, Traffc_ManagerActivity.class));
			break;
		case R.id.left:
			slideView.setCurrItem(false);
			break;
		case R.id.right:
			slideView.setCurrItem(true);
			break;
		}
	}
}
