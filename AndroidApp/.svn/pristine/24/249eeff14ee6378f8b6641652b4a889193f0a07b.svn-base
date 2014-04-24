package com.ifidc.router.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.ifidc.router.R;
import com.ifidc.router.util.MyApplication;

/**
 * 
 * 详情界面
 * 
 * */
public class ModuleContentItenActivity extends Activity{
	
	private TextView txt_title;
	private String title;
//	private String title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.module_content_item);
		
		// 将该Activity添加到MyApplication的List
		MyApplication.getInstance().addActivity(this);
		
		getData();
		initView();
	}
	
	/* 获取数据 */
	private void getData(){
		title = getIntent().getStringExtra("title");
	}
	
	/* 初始化界面 */
	private void initView(){
		
		txt_title = (TextView)findViewById(R.id.title_textView);
		txt_title.setText(title);
		findViewById(R.id.title_btn_left).setVisibility(View.VISIBLE);
		findViewById(R.id.title_btn_left).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						finish();
					}
				});
	}
	
	/* 监听事件 */
	public void onClick(View v){
		
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
