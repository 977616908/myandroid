package com.ifidc.traffic.util;

import java.util.ArrayList;
import java.util.List;

import com.ifidc.traffic.data.AppTrafficData;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;

public class AppUtil {
	public static List<AppTrafficData> getAppList(Context context) {
		List<AppTrafficData> list=new ArrayList<AppTrafficData>();
		PackageManager packageManager = context.getPackageManager();
		List<PackageInfo> packageInfos = packageManager
				.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
		for (PackageInfo info : packageInfos) {
			AppTrafficData data=new AppTrafficData();
			// 拿到应用程序的信息
			ApplicationInfo appInfo = info.applicationInfo;
			// 拿到应用程序的图标
			data.setApp_Image(appInfo.loadIcon(packageManager));
			// 拿到应用程序的程序名
			data.setApp_name(appInfo.loadLabel(packageManager).toString());
			data.setUid(appInfo.uid);
			data.setDown(TrafficStats.getUidRxBytes(data.getUid()));
			data.setUp(TrafficStats.getUidTxBytes(data.getUid()));
			data.setTotal(data.getDown()+data.getUp());
			if (filterApp(appInfo)) {
				data.setSystem(true);
			} else {
				data.setSystem(false);
			}
			list.add(data);
		}
		return list;
	}

	/**
	 * 判断某一个应用程序是不是系统的应用程序， 如果是返回true，否则返回false。
	 */
	public static boolean filterApp(ApplicationInfo info) {
		// 有些系统应用是可以更新的，如果用户自己下载了一个系统的应用来更新了原来的，它还是系统应用，这个就是判断这种情况的
		if ((info.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
			return true;
		} else if ((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {// 判断是不是系统应用
			return true;
		}
		return false;
	}

}
