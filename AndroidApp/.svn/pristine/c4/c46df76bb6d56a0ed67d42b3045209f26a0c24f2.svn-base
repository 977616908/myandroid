package com.ifidc.router.util;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * 
 * 工具公共方法
 * 
 * */
public class FunctionUtil {

	/**
	 * 显示Toast
	 * @param activity,content 需要显示的内容
	 * 
	 */
    public static void showToast(final Activity activity,final String content) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(activity, content, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
    
    /** SharedPreference读取数据 */
	public static String readSPstr(Activity activity , String kay){
		SharedPreferences sp = activity.getSharedPreferences(Consts.FILENAME, Consts.MODE);
		String phonenum = sp.getString(kay, "-1");
		return phonenum;
	}
	
	/** SharedPreference写入数据 */
	public static void writeSPstr(Activity activity ,String key ,String value){
		SharedPreferences spsjsx = activity.getSharedPreferences(
				Consts.FILENAME, Consts.MODE);
		SharedPreferences.Editor edx = spsjsx.edit();
		edx.putString(key, value);
		edx.commit();
	}
	
	/** 双击返回退出 */
	private static Boolean isExit = false;
	public static void exitBy2Click(Activity activity) {
		Timer tExit = null;
		if (isExit == false) {
			isExit = true; // 准备退出
			Toast.makeText(activity, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			tExit = new Timer();
			tExit.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false; // 取消退出
				}
			}, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
		} else {
			MyApplication.getInstance().exit();
			System.exit(0);
		}
	}
	
	/** 以下设置可以让屏幕不变暗  */
	public static void setWindow(){
		Window window = ShowProcessDialog.mDialog.getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		lp.dimAmount = 0f;
		window.setAttributes(lp);
	}
	
}
