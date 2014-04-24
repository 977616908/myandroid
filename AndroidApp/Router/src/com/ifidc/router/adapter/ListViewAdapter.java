package com.ifidc.router.adapter;

import java.util.List;

import com.ifidc.router.R;
import com.ifidc.router.cache.ImageLoader;
import com.ifidc.router.data.ListViewData;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
	private Activity context;
	private List<ListViewData> shopitem;
	private int shoplist_item;
	private ImageLoader imageLoader;
	public ListViewAdapter(Activity context, List<ListViewData> shopitem,
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
		TextView textView_des = null;
		if (convertView == null) {
			convertView = inflater.inflate(shoplist_item, null);
			iv = (ImageView) convertView.findViewById(R.id.photo_id);
			textView_title = (TextView) convertView.findViewById(R.id.title_id);
			textView_des = (TextView) convertView.findViewById(R.id.content_id);
			ViewCache cache = new ViewCache();
			cache.imageView = iv;
			cache.titleTextView = textView_title;
			cache.contentTextView = textView_des;
			convertView.setTag(cache);
		} else {
			ViewCache cache = (ViewCache) convertView.getTag();
			iv = cache.imageView;
			textView_title = cache.titleTextView;
			textView_des = cache.contentTextView;
		}

		String tit = shopitem.get(position).getTitle();
		String content = shopitem.get(position).getIntro();
		String imgtxt = shopitem.get(position).getPic();
		/*ImageLoader imageLoader = new ImageLoader(context);

		imageLoader.DisplayImage(imgtxt, iv);*/
		imageLoader.DisplayImage(imgtxt, context, iv);
		if (tit.length() > 13) {
			tit = tit.substring(0, 13);
		}
		if (content.length() > 15) {
			content = content.substring(0, 15);
		}
		textView_title.setText(tit);
		
		textView_des.setText(content);
		return convertView;
	}

	private final class ViewCache {
		ImageView imageView;
		TextView titleTextView;;
		TextView contentTextView;
	}

}
