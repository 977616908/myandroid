package com.ifidc.router.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import com.ifidc.router.R;
import com.ifidc.router.util.HttpUtils;
import com.ifidc.router.util.Loading_Data_Dialog;
import com.ifidc.router.util.MyApplication;

/**
 * 
 * 占便宜——点击列表Item——打开一个网页
 * 
 * */
public class PreferentialDownItemActivity extends Activity {

	private WebView web;
	private String url = "http://www.baidu.com/";
	private TextView text_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preferential_down_item);

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
		text_title.setText("赚流量");

		web = (WebView) findViewById(R.id.webView1);
		// 判断网络是否连接
		if (HttpUtils.isNetwork(PreferentialDownItemActivity.this)) {
			webview(url);
		} else {
			Toast.makeText(PreferentialDownItemActivity.this,
					"获取数据失败，请检查网络连接后重试", Toast.LENGTH_SHORT).show();
		}

	}

	/* 制作浏览器webview */
	public void webview(String url) {
		web = (WebView) findViewById(R.id.webView1);
		web.loadUrl(url);
		web.getSettings().setPluginsEnabled(true);
		// 设置javascript可用，即支持js脚本
		web.getSettings().setJavaScriptEnabled(true);
		// 设置可以访问文件
		web.getSettings().setAllowFileAccess(true);
		// 设置不使用缓存模式
		web.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
		// 设置不显示滚动条
		web.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		web.getSettings().setDefaultTextEncodingName("utf-8");
		web.getSettings().setBuiltInZoomControls(true); // 显示放大缩小 controler
		// 使页面获得焦点
		web.requestFocus();

		/** 新页面在客户端打开 */
		web.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url); // 显示网页
				return super.shouldOverrideUrlLoading(view, url);
			}

			/* 页面有loading提示 */
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
			}

			/* 关闭loading提示 */
			public void onPageFinished(WebView view, String url) {
				Loading_Data_Dialog.closeDialog();
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				super.onReceivedError(view, errorCode, description, failingUrl);
			}
		});

		/** 设置网页加载的进度条 */
		web.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, final int newProgress) {
				new Thread() {
					public void run() {
						Message msg = new Message();
						msg.obj = newProgress;
						handler.sendMessage(msg);
					}
				}.start();
				super.onProgressChanged(view, newProgress);
			}

			@Override
			public void onReceivedTitle(WebView view, String title) {
				// TODO Auto-generated method stub
				super.onReceivedTitle(view, title);
				setTitle(R.string.app_name);
			}
		});
	}

	/** 显示加载进度条 */
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			setProgress((Integer) msg.obj * 100);
		}

	};

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
