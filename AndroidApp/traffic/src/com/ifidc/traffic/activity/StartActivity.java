package com.ifidc.traffic.activity;

import com.ifidc.traffic.R;
import com.ifidc.traffic.data.User;
import com.ifidc.traffic.service.trafficService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;


public class StartActivity extends Activity{
	private View view;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		view=findViewById(R.id.start_lay);
		context=this;
		startService(new Intent(this, trafficService.class));
		new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SharedPreferences sharedPreferences=context.getSharedPreferences(context.getResources().getString(R.string.app_name), 0);
				String userName=sharedPreferences.getString("name", null);
				String password=sharedPreferences.getString("password", null);
				if(userName==null||password==null){
					User user=new User();
					user.setName(userName);
					user.setPassword(password);
					((TrafficApplication)getApplication()).setUser(user);;
					context.startActivity(new Intent(context, LoginActivity.class));
					StartActivity.this.finish();
				}else{
					context.startActivity(new Intent(context, HomeFrameActivity.class));
					StartActivity.this.finish();
				}
				
			}
			
		}.start();
	}

}
