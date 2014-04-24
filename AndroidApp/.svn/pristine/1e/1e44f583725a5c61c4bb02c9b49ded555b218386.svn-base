package com.ifidc.traffic.activity;

import java.util.ArrayList;
import java.util.List;

import com.ifidc.traffic.R;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

@SuppressWarnings("deprecation")
public class HomeFrameActivity extends ActivityGroup implements OnClickListener {
	private LinearLayout bodyView;// 显示页面的View
	private View[] viewList = new View[3];// 底部的切换Lay
	private ImageView[] imageViewList = new ImageView[3];// 底部的切换图标
	private TextView[] textViewList = new TextView[3];// 底部的切换TextVIew
	private int index = 0;// 切换索引
	private List<Integer> indexList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_homeframe);
		indexList = new ArrayList<Integer>();
		initView();
		// 注册广播
	}

	/**
	 * 构建视图
	 */
	public void initView() {
		bodyView = (LinearLayout) findViewById(R.id.main_lay);
		imageViewList[0] = (ImageView) findViewById(R.id.homepage_imageView);
		imageViewList[1] = (ImageView) findViewById(R.id.account_imageView);
		imageViewList[2] = (ImageView) findViewById(R.id.order_imageView);
		viewList[0] = findViewById(R.id.homepage_lay);
		viewList[1] = findViewById(R.id.findshop_lay);
		viewList[2] = findViewById(R.id.order_lay);
		showView(0);
		viewList[0].setBackgroundResource(R.drawable.buttonclick);
		for (int i = 0; i < viewList.length; i++) {
			viewList[i].setOnClickListener(this);
		}
	}

	/**
	 * 切换View
	 * 
	 * @param index
	 *            准备切换的View的索引
	 */
	public void showView(int index) {
		ReNewView(this.index);
		// 设置新的View
		setNewView(index);

		// 更新索引
		this.index = index;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int vid = v.getId();
		int vindex = 0;
		switch (vid) {
		case R.id.homepage_lay:
			vindex = 0;
			break;
		case R.id.findshop_lay:
			vindex = 1;
			break;
		case R.id.order_lay:
			vindex = 2;
			break;
		}
		showView(vindex);
	}

	/**
	 * 恢复选择View的状态
	 * 
	 * @param index
	 *            被选择的View的索引
	 */
	public void ReNewView(int index) {
		viewList[index].setBackgroundResource(R.drawable.button);
	}

	/**
	 * 设置新的View
	 * 
	 * @param index
	 *            新的View的索引
	 */
	public void setNewView(int index) {
		viewList[index].setBackgroundResource(R.drawable.buttonclick);
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				bodyView.getLayoutParams().height);
		View v = null;
		bodyView.removeAllViews();
		switch (index) {
		case 0:
			v = getLocalActivityManager().startActivity(
					"homepage",
					new Intent(this, HomePageActivity.class)
							.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
					.getDecorView();
			break;
		case 2:
			v = getLocalActivityManager().startActivity(
					"surfing",
					new Intent(this, SurfingActivity.class)
							.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
					.getDecorView();

			break;
		case 1:
			v = getLocalActivityManager().startActivity(
					"add_flow",
					new Intent(this, AddFlowActivity.class)
							.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP))
					.getDecorView();
			v.setLayoutParams(params);
			break;
		}
		v.setLayoutParams(params);
		bodyView.addView(v);
	}

}
