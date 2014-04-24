package com.ifidc.router.activity;

import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.ifidc.router.R;
import com.ifidc.router.adapter.MakeTrafficAdapter1;
import com.ifidc.router.data.MakeTrafficData1;
import com.ifidc.router.data.MakeTrafficList1;
import com.ifidc.router.util.MyApplication;

/**
 * 
 * 内容界面
 * 
 * */
public class MakeTrafficActivity1 extends Activity{
	
	MakeTrafficAdapter1 informationAdapter; // 适配器
	MakeTrafficList1 informationList; // 集合
	MakeTrafficList1 informationList2; // 加载更多
	private ListView mListView;
	
	// 下拉窗口
	private PopupWindow popupWindow;
	private ListView lv_group;
	private View view;
	private List<String> groups;
	
	private Button btn_search;
	
	private String title;
	private TextView txt_title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.make_traffic);
		
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
		
		btn_search = (Button)findViewById(R.id.btn_search);
		
		mListView = (ListView) findViewById(R.id.xListView);
		parseJSON();
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String title = informationList.getItem(arg2).getTitle();
				
				startActivity(new Intent(MakeTrafficActivity1.this,MakeTrafficItemActivity.class).putExtra("title", "占便宜"));
			}
		});
		
		txt_title = (TextView)findViewById(R.id.title_textView);
		txt_title.setText("占便宜");
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
	
	// 解析资讯列表
	private void parseJSON() {
		informationList = new MakeTrafficList1();
		
		int[] img = {R.drawable.hm_zpy_01,R.drawable.hm_zpy_02,R.drawable.hm_zpy_03
				,R.drawable.hm_zpy_01,R.drawable.hm_zpy_02,R.drawable.hm_zpy_03
				,R.drawable.hm_zpy_01,R.drawable.hm_zpy_02,R.drawable.hm_zpy_03
				,R.drawable.hm_zpy_01,R.drawable.hm_zpy_02,R.drawable.hm_zpy_03
				,R.drawable.hm_zpy_01,R.drawable.hm_zpy_02,R.drawable.hm_zpy_03
				,R.drawable.hm_zpy_01,R.drawable.hm_zpy_02,R.drawable.hm_zpy_03
				,R.drawable.hm_zpy_01,R.drawable.hm_zpy_02};
		
		try {
		
		for (int i = 0; i < 20; i++) {
			MakeTrafficData1 item = new MakeTrafficData1();
				item.setTitle("每日特惠活动");
				item.setIntro("截止日期：2014-04-18");
				item.setImg(img[i]);
				informationList.addItem(item);
			}
			informationAdapter = new MakeTrafficAdapter1(
					MakeTrafficActivity1.this,
					informationList.getAllItems(),
					R.layout.make_traffic_list_item1);
			mListView.setAdapter(informationAdapter);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onClick(View v){
		switch (v.getId()) {
		case R.id.image_back:
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
