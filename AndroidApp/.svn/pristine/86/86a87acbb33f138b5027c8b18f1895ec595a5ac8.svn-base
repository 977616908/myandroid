package com.ifidc.router.activity;

import java.util.ArrayList;

import com.ifidc.router.R;
import com.ifidc.router.util.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;

/**
 * 
 * 导航界面
 * 
 * */
public class GuideActivity extends Activity {
	private ViewPager viewPager;
	private ArrayList<View> pageViews;
	private ViewGroup main, group;
	private ImageView imageView;
	private ImageView[] imageViews;
	// 定义一个变量，为导航界面图的数量（即：当n=3时，有3个导航界面图）
	private int n = 3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		LayoutInflater inflater = getLayoutInflater();
		pageViews = new ArrayList<View>();
		// 加入五张导航界面图
		pageViews.add(inflater.inflate(R.layout.guide01, null));
		pageViews.add(inflater.inflate(R.layout.guide02, null));
		pageViews.add(inflater.inflate(R.layout.guide03, null));

		imageViews = new ImageView[pageViews.size()];
		main = (ViewGroup) inflater.inflate(R.layout.guide, null);
		
		// 将该Activity添加到MyApplication的List
		MyApplication.getInstance().addActivity(this);

		// group是R.layou.main中的负责包裹小圆点的LinearLayout.
		group = (ViewGroup) main.findViewById(R.id.WinGuide_viewGroup);

		viewPager = (ViewPager) main.findViewById(R.id.WinGuide_guidePages);

		for (int i = 0; i < n; i++) {

			imageView = new ImageView(GuideActivity.this);
			imageView.setLayoutParams(new LayoutParams(20, 20));
			imageView.setPadding(20, 0, 20, 0);
			imageViews[i] = imageView;
			if (i == 0) {
				// 默认选中第一张图片
				imageViews[i]
						.setBackgroundResource(R.drawable.page_indicator_focused);
			} else {
				imageViews[i].setBackgroundResource(R.drawable.page_indicator);
			}
			group.addView(imageViews[i]);
		}

		setContentView(main);
		viewPager.setAdapter(new GuidePageAdapter());
		viewPager.setOnPageChangeListener(new GuidePageChangeListener());
	}

	/** 导航指引页面 Adapter */
	class GuidePageAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getItemPosition(Object object) {
			// TODO Auto-generated method stub
			return super.getItemPosition(object);
		}

		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).removeView(pageViews.get(arg1));
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			// TODO Auto-generated method stub
			((ViewPager) arg0).addView(pageViews.get(arg1));
			return pageViews.get(arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			// TODO Auto-generated method stub
		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void finishUpdate(View arg0) {
			// TODO Auto-generated method stub
		}
	}

	/** 指引页面改监听器 */
	class GuidePageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
		}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			/* 当跳转到第五幅图片时，有个“立即体验”的按钮，点击按钮后结束当前的引导界面 */
			if (arg0 == n - 1) {
				// 声明ImageView控件，并且根据控件的id得到代表控件的对象
				ImageView img_go = (ImageView) main
						.findViewById(R.id.WinGuide_img_go);
				// 为ImageView控件的设置监听事件，点击后结束导航界面，跳转到主界面
				img_go.setOnTouchListener(new OnTouchListener() {
					public boolean onTouch(View v, MotionEvent event) {
						// 跳转到导航引导界面图
						Intent mainIntent = new Intent(GuideActivity.this,
								MainPageActivity.class);
						GuideActivity.this.startActivity(mainIntent);
						GuideActivity.this.finish();
						return false;
					}
				});
			}
		}
		@Override
		public void onPageSelected(int arg0) {
			for (int i = 0; i < n; i++) {
				imageViews[arg0]
						.setBackgroundResource(R.drawable.page_indicator_focused);
				if (arg0 != i) {
					imageViews[i]
							.setBackgroundResource(R.drawable.page_indicator);
				}
			}
		}
	}

	/** 点击手机返回键 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}