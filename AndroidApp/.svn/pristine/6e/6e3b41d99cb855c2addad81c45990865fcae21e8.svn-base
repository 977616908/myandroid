package com.ifidc.router.util;

import android.app.Activity;
import android.app.ProgressDialog;

public class Loading_Data_Dialog {
	
		// 加载进度条
		public static ProgressDialog myDialog = null;
		
		/** 展示加载的窗口 */
		public static void showDialog(Activity activity){
			myDialog = ProgressDialog.show(activity, "加载中...",
					"正在请求数据，请稍候......", true, true);
		}
		
		/** 关闭加载的窗口 */
		public static void closeDialog(){
			myDialog.dismiss();
		}
		
}
