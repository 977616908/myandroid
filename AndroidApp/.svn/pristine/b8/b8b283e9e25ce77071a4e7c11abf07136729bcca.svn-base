package com.ifidc.router.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.ifidc.router.R;
import com.ifidc.router.util.MyApplication;

/**
 * 
 * 搜索界面
 * 
 * */
public class SearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		// 将该Activity添加到MyApplication的List
		MyApplication.getInstance().addActivity(this);

		initView();
	}

	/* 初始化界面 */
	private void initView() {

	}

	/* 监听事件 */
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_search: // 搜索
			Toast.makeText(SearchActivity.this, "搜索", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.image_back: // 返回
			finish();
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
