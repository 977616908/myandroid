package com.ifidc.traffic.adapter;

import java.util.List;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;


//指引页面数据适配器
public class GuidePageAdapter extends PagerAdapter {
	private List<View> gList;

	public GuidePageAdapter(List<View> list) {
		gList = list;
	}

	@Override
	public int getCount() {
		return gList.size();
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
		// ((ViewPager) arg0).removeView(gList.get(arg1));
	}

	@Override
	public Object instantiateItem(View arg0, int arg1) {
		// TODO Auto-generated method stub
		ViewPager v = ((ViewPager) arg0);
		if (v.getChildAt(arg1) == null) {
			((ViewPager) arg0).addView(gList.get(arg1));
			gList.get(arg1).setTag(arg1);
		} else if (v.getChildAt(arg1).getTag() != null) {

		} else {
			((ViewPager) arg0).addView(gList.get(arg1));
			gList.get(arg1).setTag(arg1);
		}
		return gList.get(arg1);
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