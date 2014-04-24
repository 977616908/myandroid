package com.ifidc.router.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.ifidc.router.R;
import com.ifidc.router.util.MyApplication;

/**
 * 
 * 
 * 
 * */
public class MakeTrafficItemActivity extends Activity{
	
	private TextView text_title;
	private String title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.make_traffic_item);
		
		// 将该Activity添加到MyApplication的List
		MyApplication.getInstance().addActivity(this);
		
		getTitleText();
		initView();
	}
	
	/* 获取上一个界面的标题 */ 
	private void getTitleText(){
		title = getIntent().getStringExtra("title");
	}
	
	/* 初始化界面 */
	private void initView(){
		
		findViewById(R.id.title_btn_left).setVisibility(View.VISIBLE);
		findViewById(R.id.title_btn_left).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						finish();
					}
				});
		
		text_title = (TextView)findViewById(R.id.title_textView);
		text_title.setText(title);
		
	}
	
	/**
	 * 返回键响应
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return false;
	}
}
