package com.ifidc.router.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
/**
 * 
 * 网络加载的loading
 * 
 * */
public class ShowProcessDialog {
	public static Dialog mDialog;

	public static void showRoundProcessDialog(Context mContext, int layout,
			boolean indeterminate, boolean cancelable) {
		// TODO Auto-generated method stub
		OnKeyListener keyListener = new OnKeyListener() {
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode,
					KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_HOME
						|| keyCode == KeyEvent.KEYCODE_SEARCH) {
					return true;
				}
				return false;
			}
		};
		mDialog = new AlertDialog.Builder(mContext).create();
		mDialog.setOnKeyListener(keyListener);
		mDialog.show();
		// 注意此处要放在show之后 否则会报异常
		mDialog.setContentView(layout);
	}
}
