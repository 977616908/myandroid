package com.ifidc.router.activity;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.ifidc.router.R;
import com.ifidc.router.spiner.SpinerPopWindow;
import com.ifidc.router.spiner.AbstractSpinerAdapter;
import com.ifidc.router.util.FunctionUtil;
import com.ifidc.router.util.MyApplication;

/**
 * 
 * 主界面
 * 
 * */
public class MainPageActivity extends Activity implements 
AbstractSpinerAdapter.IOnItemSelectListener{
	
	private TextView text_city;
	private SpinerPopWindow mSpinerPopWindow;
	private List<String> nameList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 将该Activity添加到MyApplication的List
		MyApplication.getInstance().addActivity(this);
		
		initView();
	}
	
	/* 初始化界面 */
	private void initView(){
		text_city = (TextView)findViewById(R.id.textView_dd);
		text_city.setText("广州 ");
		city_down();
	}
	
	/* 城市选择下拉框 */
	private void showSpinWindow() {
		mSpinerPopWindow.setWidth(findViewById(R.id.btn_spiner).getWidth());
		mSpinerPopWindow.showAsDropDown(findViewById(R.id.btn_spiner));
	}
	
	/* 下拉框 */
	private void city_down(){
		for (int i = 0; i < getResources().getStringArray(R.array.city_array).length; i++) {
			nameList.add(getResources().getStringArray(R.array.city_array)[i]);
		}
		mSpinerPopWindow = new SpinerPopWindow(this);
		mSpinerPopWindow.refreshData(nameList, 0);
		mSpinerPopWindow.setItemListener(this);
	}
	
	/** 下拉框Item监听事件 */
	@Override
	public void onItemClick(int pos) {
		//显示地点
		text_city.setText(nameList.get(pos)+" ");
	}
	
	/* 监听事件 */
	public void onClick(View v){
		switch (v.getId()) {
		case R.id.textView_dd://地点
			showSpinWindow() ;
			break;
		case R.id.btn_search://搜索
//			startActivity(new Intent(MainPageActivity.this,SearchActivity.class));
//			startActivity(new Intent(MainPageActivity.this,ListViewActivity.class));
			break;
		case R.id.textView_top01:
			startActivity(new Intent(MainPageActivity.this,ModuleContent1Activity.class).putExtra("title", "美食"));
			break;
		case R.id.textView_top02:
			startActivity(new Intent(MainPageActivity.this,ModuleContent1Activity.class).putExtra("title", "酒店"));
			break;
		case R.id.textView_top03:
			startActivity(new Intent(MainPageActivity.this,ModuleContent1Activity.class).putExtra("title", "购物"));
			break;
		case R.id.textView_top04:
			startActivity(new Intent(MainPageActivity.this,ModuleContent1Activity.class).putExtra("title", "酒吧"));
			break;
		case R.id.textView_top05:
			startActivity(new Intent(MainPageActivity.this,ModuleContent1Activity.class).putExtra("title", "运动"));
			break;
		case R.id.textView_top06:
			startActivity(new Intent(MainPageActivity.this,ModuleContent1Activity.class).putExtra("title", "更多"));
			break;
		case R.id.mainpage_m2://广告图模块
			startActivity(new Intent(MainPageActivity.this,MakeTrafficItemActivity.class).putExtra("title", "广告"));
			break;
		case R.id.textView_zpy://占便宜模块
			startActivity(new Intent(MainPageActivity.this,MakeTrafficActivity1.class));
			break;
		case R.id.linear_zpy_01://占便宜第一个app
			startActivity(new Intent(MainPageActivity.this,MakeTrafficItemActivity.class).putExtra("title", "占便宜"));
			break;
		case R.id.linear_zpy_02://占便宜第二个app
			startActivity(new Intent(MainPageActivity.this,MakeTrafficItemActivity.class).putExtra("title", "占便宜"));
			break;
		case R.id.textView_zll://赚流量模块
			startActivity(new Intent(MainPageActivity.this,PreferentialActivity1.class));
			break;
		case R.id.textView_zll01://赚流量（以下是个别模块）
			startActivity(new Intent(MainPageActivity.this,PreferentialItemActivity.class));
			break;
		case R.id.textView_zll02:
			startActivity(new Intent(MainPageActivity.this,PreferentialItemActivity.class));
			break;
		case R.id.textView_zll03:
			startActivity(new Intent(MainPageActivity.this,PreferentialItemActivity.class));
			break;
		case R.id.textView_zll04:
			startActivity(new Intent(MainPageActivity.this,PreferentialItemActivity.class));
			break;
		case R.id.textView_zll05:
			startActivity(new Intent(MainPageActivity.this,PreferentialItemActivity.class));
			break;
		case R.id.textView_zll06:
			startActivity(new Intent(MainPageActivity.this,PreferentialItemActivity.class));
			break;
		case R.id.textView_zll07:
			startActivity(new Intent(MainPageActivity.this,PreferentialItemActivity.class));
			break;
		case R.id.textView_zll08:
			startActivity(new Intent(MainPageActivity.this,PreferentialItemActivity.class));
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
			FunctionUtil.exitBy2Click(MainPageActivity.this);// 调用双击退出函数
		}
		return false;
	}
}
