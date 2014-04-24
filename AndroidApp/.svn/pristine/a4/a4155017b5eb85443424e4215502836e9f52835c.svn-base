package com.ifidc.traffic.activity;

import com.ifidc.traffic.R;
import com.ifidc.traffic.data.User;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity{
	private EditText userName;
	private EditText password;
	private TextView forgetPassword;
	private Button login_btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initView();
	}
	
	public void initView(){
		setContentView(R.layout.activity_login);
		userName=(EditText) findViewById(R.id.login_username);
		password=(EditText) findViewById(R.id.login_password);
		forgetPassword=(TextView) findViewById(R.id.forget_password);
		login_btn=(Button) findViewById(R.id.login);
		login_btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(userName.getText().toString().equals("123")){
					SharedPreferences sh=LoginActivity.this.getSharedPreferences(LoginActivity.this.getResources().getString(R.string.app_name), 0);
					Editor edit=sh.edit();
					edit.putString("name", userName.getText().toString());
					edit.putString("password", password.getText().toString());
					edit.commit();
					User user=new User();
					user.setName(userName.getText().toString());
					user.setPassword(password.getText().toString());
					((TrafficApplication)getApplication()).setUser(user);;
					LoginActivity.this.startActivity(new Intent(LoginActivity.this,HomeFrameActivity.class));
					LoginActivity.this.finish();
				}
			}
		});
	}
}
