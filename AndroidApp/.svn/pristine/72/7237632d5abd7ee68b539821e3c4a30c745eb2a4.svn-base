package com.ifidc.traffic.activity;



import com.ifidc.traffic.data.User;
import com.ifidc.traffic.util.CrashHandler;
import com.ifidc.traffic.util.LogUtil;

import android.app.Application;

public class TrafficApplication extends Application{
	private User user;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		CrashHandler caCrashHandler = CrashHandler.getInstance();
		caCrashHandler.init(this);
		LogUtil.getInstance(this).start();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
