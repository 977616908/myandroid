package com.ifidc.router.adapter;

import java.io.IOException;
import java.util.List;

import com.ifidc.router.R;
import com.ifidc.router.cache.ImageLoader;
import com.ifidc.router.data.PreferentilData1;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PreferentialAdapter1 extends BaseAdapter {
	private Activity context;
	private List<PreferentilData1> shopitem;
	private int shoplist_item;
	private ImageLoader imageLoader;
	public PreferentialAdapter1(Activity context, List<PreferentilData1> shopitem,
			int shoplist_item) {
		super();
		imageLoader=new ImageLoader(context);
		this.context = context;
		this.shopitem = shopitem;
		this.shoplist_item = shoplist_item;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return shopitem.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return shopitem.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		ImageView iv = null;
		TextView textView_title = null;
//		TextView textView_des = null;
//		TextView textView_address = null;
//		TextView textView_distance = null;
		if (convertView == null) {
			convertView = inflater.inflate(shoplist_item, null);
			iv = (ImageView) convertView.findViewById(R.id.photo_id);
			textView_title = (TextView) convertView.findViewById(R.id.title_id);
//			textView_des = (TextView) convertView.findViewById(R.id.content_id);
//			textView_address = (TextView) convertView.findViewById(R.id.address_id);
//			textView_distance = (TextView) convertView.findViewById(R.id.distance_id);
			ViewCache cache = new ViewCache();
			cache.imageView = iv;
			cache.titleTextView = textView_title;
//			cache.contentTextView = textView_des;
//			cache.addressTextView = textView_address;
//			cache.distanceTextView = textView_distance;
			convertView.setTag(cache);
		} else {
			ViewCache cache = (ViewCache) convertView.getTag();
			iv = cache.imageView;
			textView_title = cache.titleTextView;
//			textView_des = cache.contentTextView;
//			textView_address = cache.addressTextView;
//			textView_distance = cache.distanceTextView;
		}

		String tit = shopitem.get(position).getTitle();
//		String content = shopitem.get(position).getIntro();
//		String address = shopitem.get(position).getUpdatetime();
//		String distance = shopitem.get(position).getContAdd();
//		String imgtxt = shopitem.get(position).getPic();
		int imgtxt = shopitem.get(position).getImg();
		/*ImageLoader imageLoader = new ImageLoader(context);

		imageLoader.DisplayImage(imgtxt, iv);*/
//		imageLoader.DisplayImage(imgtxt, context, iv);
//		getPic(iv);
		
		iv.setBackgroundResource(imgtxt);
		
		if (tit.length() > 13) {
			tit = tit.substring(0, 13);
		}
//		if (content.length() > 15) {
//			content = content.substring(0, 15);
//		}
		textView_title.setText(tit);
//		textView_des.setText(content);
//		textView_address.setText(address);
//		textView_distance.setText(distance);
		return convertView;
	}

	private final class ViewCache {
		ImageView imageView;
		TextView titleTextView;
//		TextView contentTextView;
//		TextView addressTextView;
//		TextView distanceTextView;
	}
	
}
