package com.ifidc.router.activity;

import com.ifidc.router.R;
import com.ifidc.router.util.MyApplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
/**
 * 
 * LOGO界面
 * 
 * */
public class LogoActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.logo);
        
	     // 将该Activity添加到MyApplication的List
	     MyApplication.getInstance().addActivity(this);

	     gotoMain();
    }
    
    private void gotoMain(){
    	new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
//				/* 判断是否第一次使用应用，若是跳转到主界面 */
//				if (FunctionUtil.readSPstr(LogoActivity.this, "num_sft").equals("1")) {
//					// 跳转到主界面
//					startActivity(new Intent(LogoActivity.this,MainPageActivity.class));
//					LogoActivity.this.finish();
//				} else {
//					// 跳转到导航引导界面图
//					startActivity(new Intent(LogoActivity.this,GuideActivity.class));
//					LogoActivity.this.finish();
//				}
				
				// 跳转到主界面
				startActivity(new Intent(LogoActivity.this,MainPageActivity.class));
				LogoActivity.this.finish();
				
			}
		}, 2000);      
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