package com.ifidc.traffic.adapter;

import java.util.List;




import com.ifidc.traffic.R;
import com.ifidc.traffic.data.TypeData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TypeAdapter extends BaseAdapter {
	private List<TypeData> list;
	private Context context;
	public TypeAdapter(Context contex, List<TypeData> list) {
		this.context = contex;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub

		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		Holder holder = new Holder();
		if (arg1 == null) {
			Holder tHolder = new Holder();
			arg1 = LayoutInflater.from(context).inflate(
					R.layout.adapter_type, null);
			tHolder.name = (TextView) arg1.findViewById(R.id.re_name);
			tHolder.num = (TextView) arg1.findViewById(R.id.re_num);
			tHolder.image = (ImageView) arg1.findViewById(R.id.re_image);
			arg1.setTag(tHolder);
		}
		holder = (Holder) arg1.getTag();
		TypeData reginsData = list.get(arg0);
		holder.name.setText(reginsData.getName());
		if (reginsData.getRegionId() == 0) {
			holder.image.setVisibility(View.GONE);
		}
		return arg1;
	}

	class Holder {
		TextView name;
		TextView num;
		ImageView image;
	}
}
