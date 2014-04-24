package com.ifidc.traffic.view;

import java.util.ArrayList;
import java.util.List;

import com.ifidc.traffic.R;
import com.ifidc.traffic.adapter.GuidePageAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

/***
 * Android实现左右滑动指引效果
 * 
 * @author 陈冠全
 * 
 */
public class SlideView extends LinearLayout {
	private List<View> pageViews;// 显示的View列表
	private List<ImageView> imageViews;// 显示的小圆点列表
	private LinearLayout imageLay;
	private ViewPager viewPager;
	private Context context;// Context
	private boolean isTop = true;
	private GuidePageAdapter guidePageAdapter;
	private GuidePageChangeListener guidePageChangeListener;
	public static final String TAG = "MySlide";
	public static final String ViewPageTag = "ViewPageTag";
	public int orderView_height = 0;
	public int viewPage_height = 0;
	public int trolley_height = 0;
	public HorizontalScrollView view_cScrollView;
	int width;
	private onChageListener onChageListener;

	public SlideView(Context context) {
		super(context);
		this.context = context;
		pageViews = new ArrayList<View>();
		imageViews = new ArrayList<ImageView>();
	}

	public SlideView(Context context, AttributeSet attrs) {
		super(context, attrs);
		pageViews = new ArrayList<View>();
		imageViews = new ArrayList<ImageView>();
		this.context = context;
	}

	public int getViewListSize() {
		return pageViews.size();
	}

	public void initView() {
		LayoutInflater.from(context).inflate(R.layout.view_slideview, this);
		viewPager = (ViewPager) findViewById(R.id.myslide_viewpage_top);
		viewPager.setTag(ViewPageTag);
		this.setTag(TAG);
	}

	public void setState(List<View> list, List<ImageView> imageViews) {
		if (pageViews.size() > 0) {
			viewPager.removeAllViews();
		}
		this.imageViews = imageViews;
		this.pageViews = list;
		initView();
		setView();
		if (view_cScrollView != null) {
			view_cScrollView.scrollTo(0, 0);
		}
	}

	public void setView() {
		guidePageAdapter = new GuidePageAdapter(pageViews);
		guidePageChangeListener = new GuidePageChangeListener(imageViews);
		viewPager.setAdapter(guidePageAdapter);
		viewPager.setOnPageChangeListener(guidePageChangeListener);
	}

	public void setImageMargin(int margin) {
		if (!isTop) {
			FrameLayout.LayoutParams layouparams = (FrameLayout.LayoutParams) imageLay
					.getLayoutParams();
			layouparams.bottomMargin = margin;
			imageLay.setLayoutParams(layouparams);
		}

	}

	// 指引页面更改事件监听器
	class GuidePageChangeListener implements OnPageChangeListener {
		private List<ImageView> gList;
		private int oldIndex = 0;

		public GuidePageChangeListener(List<ImageView> list) {
			gList = list;
		}

		public void RenewList(List<ImageView> list) {
			gList = list;
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			for (int i = 0; i < gList.size(); i++) {
				gList.get(i).setBackgroundResource(R.drawable.switchingkey02);
				if (arg0 != i) {
					gList.get(i).setBackgroundResource(
							R.drawable.switchingkey01);
				}
			}
			if (onChageListener != null) {
				onChageListener.Chage(arg0, SlideView.this);
			}
			oldIndex = arg0;
		}
	}

	public void setOnChageListener(onChageListener onChageListener) {
		this.onChageListener = onChageListener;
	}

	public void setCurrItem(boolean isNext) {
		if (isNext) {
			viewPager.setCurrentItem(guidePageChangeListener.oldIndex + 1);
		} else {
			viewPager.setCurrentItem(guidePageChangeListener.oldIndex - 1);
		}

	}

	// @Override
	// protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	// // TODO Auto-generated method stub
	// if(pageViews.size()>0){
	// View view=pageViews.get(0);
	// view.measure(widthMeasureSpec, MeasureSpec.UNSPECIFIED);
	// if (orderView_height == 0
	// || orderView_height < view.getMeasuredHeight()) {
	// orderView_height = view.getMeasuredHeight();
	// android.view.ViewGroup.LayoutParams l = viewPager
	// .getLayoutParams();
	// l.height = orderView_height;
	// viewPager.setLayoutParams(l);
	// }
	// super.onMeasure(widthMeasureSpec, MeasureSpec.UNSPECIFIED);
	// }else{
	// super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	// }
	// }
	public interface onChageListener {
		public void Chage(int index, SlideView slideView);
	}
}