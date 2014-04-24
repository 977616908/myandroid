package com.ifidc.traffic.data;

import android.graphics.drawable.Drawable;

public class AppTrafficData {
	private String app_name;
	private Drawable app_Image;
	private long up;
	private long last_up;
	private long down;
	private long last_down;
	private long total;
	private long last_total;
	private boolean isSystem;
	private int uid;
	public String getApp_name() {
		return app_name;
	}
	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}
	public Drawable getApp_Image() {
		return app_Image;
	}
	public void setApp_Image(Drawable app_Image) {
		this.app_Image = app_Image;
	}
	public long getUp() {
		return up==-1?0:up;
	}
	public void setUp(long up) {
		this.up = up;
	}
	public long getLast_up() {
		return last_up;
	}
	public void setLast_up(long last_up) {
		this.last_up = last_up;
	}
	public long getDown() {
		return down==-1?0:down;
	}
	public void setDown(long down) {
		this.down = down;
	}
	public long getLast_down() {
		return last_down;
	}
	public void setLast_down(long last_down) {
		this.last_down = last_down;
	}
	public long getTotal() {
		return total<=-1?0:total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getLast_total() {
		return last_total;
	}
	public void setLast_total(long last_total) {
		this.last_total = last_total;
	}
	public boolean isSystem() {
		return isSystem;
	}
	public void setSystem(boolean isSystem) {
		this.isSystem = isSystem;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
}
