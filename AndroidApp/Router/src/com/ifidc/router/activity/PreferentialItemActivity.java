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
 * 赚流量Item界面
 * 
 * */
public class PreferentialItemActivity extends Activity {

	private TextView text_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preferential_item);

		// 将该Activity添加到MyApplication的List
		MyApplication.getInstance().addActivity(this);

		initView();
	}

	/* 初始化界面 */
	private void initView() {

		findViewById(R.id.title_btn_left).setVisibility(View.VISIBLE);
		findViewById(R.id.title_btn_left).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View arg0) {
						finish();
					}
				});

		text_title = (TextView) findViewById(R.id.title_textView);
		text_title.setText("软件详情");
	}

	/* 按钮监听事件 */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.text_download:
			Toast.makeText(PreferentialItemActivity.this, "下载",
					Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
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
