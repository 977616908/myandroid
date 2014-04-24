package com.ifidc.router.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ifidc.router.R;
import com.ifidc.router.adapter.ModuleContentAdapter1;
import com.ifidc.router.adapter.PoupWindowAdapter;
import com.ifidc.router.data.ModuleContentData1;
import com.ifidc.router.data.ModuleContentList1;
import com.ifidc.router.util.MyApplication;

/**
 * 
 * 内容界面
 * 
 * */
public class ModuleContent1Activity extends Activity{
	
	ModuleContentAdapter1 informationAdapter; // 适配器
	ModuleContentList1 informationList; // 集合
	ModuleContentList1 informationList2; // 加载更多
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
		setContentView(R.layout.module_content1);
		
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
				
				startActivity(new Intent(ModuleContent1Activity.this,ModuleContentItenActivity.class).putExtra("title", title));
			}
		});
		
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
	
	// 解析资讯列表
	private void parseJSON() {
		informationList = new ModuleContentList1();
		
		int[] img = {R.drawable.rexiao_1,R.drawable.rexiao_2,R.drawable.rexiao_3
				,R.drawable.rexiao_4,R.drawable.rexiao_5,R.drawable.rexiao_6
				,R.drawable.rexiao_4,R.drawable.rexiao_1,R.drawable.rexiao_2
				,R.drawable.rexiao_3,R.drawable.rexiao_4,R.drawable.rexiao_5
				,R.drawable.rexiao_6,R.drawable.rexiao_4,R.drawable.rexiao_1
				,R.drawable.rexiao_2,R.drawable.rexiao_3,R.drawable.rexiao_4
				,R.drawable.rexiao_5,R.drawable.rexiao_6};
		
		String[] address = {"石牌/龙口 粤菜     410m","石牌/龙口 粤菜     820m","石牌/龙口 粤菜     <100m"
				,"石牌/龙口 粤菜     450m","石牌/龙口 粤菜     230m","石牌/龙口 粤菜     780m"
				,"石牌/龙口 粤菜     670m","石牌/龙口 粤菜    250m","石牌/龙口 粤菜     970m"
				,"石牌/龙口 粤菜     560m","石牌/龙口 粤菜    530m","石牌/龙口 粤菜     680m"
				,"石牌/龙口 粤菜     560m","石牌/龙口 粤菜    530m","石牌/龙口 粤菜     680m"
				,"石牌/龙口 粤菜     560m","石牌/龙口 粤菜    530m","石牌/龙口 粤菜     680m"
				,"石牌/龙口 粤菜     560m","石牌/龙口 粤菜    530m"};
		
		try {
		String[] stationPicNames = this.getResources().getAssets().list("stationPic");
		String[] str_title = {"黄鳝世家（龙口东店）","唐府佳宴（珠江新城店）","荟宴（天河南店）","香港海鲜酒家","摩亚咖啡","黄鳝世家（龙口东店）","唐府佳宴（珠江新城店）","荟宴（天河南店）","香港海鲜酒家","摩亚咖啡","黄鳝世家（龙口东店）","唐府佳宴（珠江新城店）","荟宴（天河南店）","香港海鲜酒家","摩亚咖啡","黄鳝世家（龙口东店）","唐府佳宴（珠江新城店）","荟宴（天河南店）","香港海鲜酒家","摩亚咖啡"};
		String[] str_pay = {" 人均： ￥64"," 人均： ￥36"," 人均： ￥57"," 人均： ￥32"," 人均： ￥77"," 人均： ￥23"," 人均： ￥55"," 人均： ￥87"," 人均： ￥25"," 人均： ￥35"," 人均： ￥64"," 人均： ￥36"," 人均： ￥57"," 人均： ￥32"," 人均： ￥77"," 人均： ￥23"," 人均： ￥55"," 人均： ￥87"," 人均： ￥25"," 人均： ￥35"};
		
		for (int i = 0; i < 20; i++) {
				ModuleContentData1 item = new ModuleContentData1();
				item.setTitle(str_title[i]);
				item.setIntro(str_pay[i]);
				item.setUpdatetime(address[i]);
				item.setImg(img[i]);
				informationList.addItem(item);
			}
			informationAdapter = new ModuleContentAdapter1(
					ModuleContent1Activity.this,
					informationList.getAllItems(),
					R.layout.module_conten_list_item1);
			mListView.setAdapter(informationAdapter);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 下拉筛选框 */
	@SuppressWarnings("deprecation")
	private void showWindow(View parent) {
		if (popupWindow == null) {
			LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = layoutInflater.inflate(R.layout.poupwindow_list, null);
			lv_group = (ListView) view.findViewById(R.id.lvGroup);
			// 加载数据
			groups = new ArrayList<String>();
			groups.add("全部商户");
			groups.add("团购商户");
			groups.add("可预订商户");
			groups.add("会员卡商户");
			groups.add("优惠卷商户");
			groups.add("新增商户");

			PoupWindowAdapter groupAdapter = new PoupWindowAdapter(this, groups);
			lv_group.setAdapter(groupAdapter);
			// 创建一个PopuWidow对象
			popupWindow = new PopupWindow(view, LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
		}
		// 使其聚集
		popupWindow.setFocusable(true);
		// 设置允许在外点击消失
		popupWindow.setOutsideTouchable(true);
		// 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		// 显示的位置为:屏幕的宽度的一半-PopupWindow的高度的一半
		int xPos = windowManager.getDefaultDisplay().getWidth() / 2
				- popupWindow.getWidth() / 2;
		popupWindow.showAsDropDown(parent, xPos, 0);
		lv_group.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
//				Toast.makeText(ModuleContent1Activity.this,
//						groups.get(position), 1000)
//						.show();
				btn_search.setText(groups.get(position));
				if (popupWindow != null) {
					popupWindow.dismiss();
				}
			}
		});
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
