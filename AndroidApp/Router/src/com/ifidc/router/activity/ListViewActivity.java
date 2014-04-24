package com.ifidc.router.activity;

import java.util.List;

import com.ifidc.router.R;
import com.ifidc.router.adapter.ListViewAdapter;
import com.ifidc.router.data.ListViewList;
import com.ifidc.router.pultorefreshlist.view.XListView;
import com.ifidc.router.pultorefreshlist.view.XListView.IXListViewListener;
import com.ifidc.router.util.FunctionUtil;
import com.ifidc.router.util.HttpUtils;
import com.ifidc.router.util.ShowProcessDialog;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ListViewActivity extends Activity {
	public List<String> urls;
	Uri uri;
	Intent intent;
	ListViewAdapter Adapter;// 适配器
	ListViewList List;// 存放首次加载数据的集合
	ListViewList List2;// 存放加载更多或刷新加载数据的集合
	private XListView mListView;
	private int count = 0; // 加载时候的页码
//	RelativeLayout rela_v;// 隐藏的布局文件，用来设置网络连接
	
	private String url = "http://json.3g518.org/infojson/xinwen_list.aspx?regid=2190118";
	private String url_type = "0"; // 该参数在加载数据的时候鉴别是首次加载数据还是加载更多、刷新加载数据

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.listview);

		initView();
		getData();
	}
	
	/* 初始化 */
	private void initView(){
//		rela_v = (RelativeLayout) findViewById(R.id.rela_v);
		mListView = (XListView) findViewById(R.id.xListView);
		mListView.setXListViewListener(xListViewListener);
		mListView.setPullLoadEnable(true);
		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int arg = arg2 - 1;
//				String title = List.getItem(arg).getTitle();

				Toast.makeText(ListViewActivity.this, "点击了" + arg + "项",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
	
	/* 访问服务器获取数据并且解析返回的数据 */
	private void getData(){
		url_type = "0";
		// 判断网络是否连接
		if(HttpUtils.isNetwork(ListViewActivity.this)){
			new SaxParseApplyTask().execute(url);
		}else{
			Toast.makeText(ListViewActivity.this, "获取数据失败，请检查网络连接后重试", Toast.LENGTH_SHORT).show();
		}
	}

	/* 异步加载 */
	public class SaxParseApplyTask extends
			AsyncTask<String, Void, ListViewList> {
		protected ListViewList doInBackground(String... params) {
			//"1"代表加载更多的数据，"0"代表是首次加载的数据
			if("0".equals(url_type)){
				return List = HttpUtils.parseJSON(HttpUtils.getDataPost(params[0]), List);
			}else{
				return List2 = HttpUtils.parseJSON(HttpUtils.getDataPost(params[0]), List2);
			}
		}
		@Override
		protected void onPreExecute() {
//			rela_v.setVisibility(View.VISIBLE);
			ShowProcessDialog.showRoundProcessDialog(ListViewActivity.this,
					R.layout.loading_process_dialog_anim, true, true);
			FunctionUtil.setWindow();
		}
		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}
		@Override
		protected void onPostExecute(ListViewList result) {
			mListView.stopRefresh();
			mListView.stopLoadMore();
			if (result != null) {
				//"1"代表加载更多的数据，"0"代表是首次加载的数据
				if("0".equals(url_type)){
					Adapter = new ListViewAdapter(
							ListViewActivity.this,
							List.getAllItems(),
							R.layout.listview_list_item);
					mListView.setAdapter(Adapter);
				}else{
					for (int i = 0; i < List2.getAllItems().size(); i++) {
						List.addItem(List2.getItem(i));
					}
					if (Adapter != null) {
						Adapter.notifyDataSetChanged();
					}
				}
			} else {
				Toast.makeText(ListViewActivity.this, "获取数据失败，请检查网络连接后重试", 1)
						.show();
			}
//			rela_v.setVisibility(View.GONE);
			ShowProcessDialog.mDialog.dismiss();
		}
	}
	
	/* 实现下拉刷新和加载更多 */
	private IXListViewListener xListViewListener = new IXListViewListener() {
		/* 下拉刷新 */
		@Override
		public void onRefresh() {
			url_type = "0";
			count = 0;
			// 判断网络是否连接
			if(HttpUtils.isNetwork(ListViewActivity.this)){
				new SaxParseApplyTask().execute(url+ "&topm=" + count);
			}else{
				Toast.makeText(ListViewActivity.this, "获取数据失败，请检查网络连接后重试", Toast.LENGTH_SHORT).show();
			}
			
		}
		/* 上拉加载更多 */
		@Override
		public void onLoadMore() {
			url_type = "1";
			count++;
			String more = url + "&topm=" + (count * 10 + "");
			// 判断网络是否连接
			if(HttpUtils.isNetwork(ListViewActivity.this)){
				new SaxParseApplyTask().execute(more);
			}else{
				Toast.makeText(ListViewActivity.this, "获取数据失败，请检查网络连接后重试", Toast.LENGTH_SHORT).show();
			}
		}
	};

}