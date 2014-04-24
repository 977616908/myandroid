package com.ifidc.router.util;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

/**
 * 
 * 存放Activity,每启动一个Activity就添加进来，最后关闭应用程序时，
 * 遍历关闭所有的Activity,达到完全关闭应用程序的作用。
 * 
 */
public class MyApplication extends Application {
	// 定义一个List存放Activity
	private List<Activity> activityList = new LinkedList<Activity>();
	private static MyApplication instance;

	public MyApplication() {

	}

	/** 单例模式中获取唯一的MyApplication实例 */
	public static MyApplication getInstance() {
		if (null == instance) {
			instance = new MyApplication();
		}
		return instance;
	}

	/** 添加Activity到容器中 */
	public void addActivity(Activity activity) {
		activityList.add(activity);
	}

	/** 遍历所有Activity 并finish */
	public void exit() {
		for (Activity activity : activityList) {
			activity.finish();
		}
		System.exit(0);
	}
}
