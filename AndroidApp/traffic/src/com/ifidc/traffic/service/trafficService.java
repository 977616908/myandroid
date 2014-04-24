package com.ifidc.traffic.service;

import android.app.Service;
import android.content.Intent;
import android.net.TrafficStats;
import android.os.IBinder;
import android.util.Log;

public class trafficService extends Service{
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				getTraffic();
			}
			
		}.start();
		
	}
	public void getTraffic(){
		while (true) {
			long mobileRx=TrafficStats.getMobileRxBytes();
			long mobileTx=TrafficStats.getMobileTxBytes();
			long totalRx=TrafficStats.getTotalRxBytes();
			long totalTx=TrafficStats.getTotalTxBytes();
			long wifiRx=totalRx-mobileRx;
			long wifiTx=totalTx-mobileTx;
			Intent intent=new Intent("data");
			long[] datas=new long[]{mobileTx,mobileRx,mobileRx+mobileTx,wifiTx,wifiRx,wifiTx+wifiRx};
			intent.putExtra("traffic", datas);
			sendBroadcast(intent);
			//TrafficStats.g
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
