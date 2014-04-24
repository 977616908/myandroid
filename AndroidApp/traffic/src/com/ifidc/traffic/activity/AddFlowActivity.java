package com.ifidc.traffic.activity;

import java.util.ArrayList;
import java.util.List;

import com.ifidc.traffic.R;
import com.ifidc.traffic.adapter.GridViewAdapter;
import com.ifidc.traffic.adapter.TypeAdapter;
import com.ifidc.traffic.data.AppData;
import com.ifidc.traffic.data.TypeData;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class AddFlowActivity extends Activity implements OnClickListener{
	private RadioGroup radio_grGroup;
	private GridView gridView;
	private GridViewAdapter gridViewAdapter;
	private List<AppData> list=new ArrayList<AppData>();
	private View home_lay;
	private View fav_lay;
	private TextView total_tv;
	private Dialog dialog;
	private ListView listView;
	private TypeAdapter adapter;
	private View choose_lay;
	private View choose;
	private List<TypeData> typelist=new ArrayList<TypeData>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		initView();
	}
	
	public void initView(){
		setContentView(R.layout.activity_addflow);
		fav_lay=findViewById(R.id.fav_lay);
		home_lay=findViewById(R.id.home_lay);
		radio_grGroup=(RadioGroup) findViewById(R.id.radio_group);
		radio_grGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(checkedId==R.id.fav_app){
					fav_lay.setVisibility(View.VISIBLE);
					home_lay.setVisibility(View.GONE);
				}else{
					home_lay.setVisibility(View.VISIBLE);
					fav_lay.setVisibility(View.GONE);
				}
			}
		});
		((RadioButton)radio_grGroup.getChildAt(0)).setChecked(true);
		gridView=(GridView) findViewById(R.id.add_flow_gridView);
		for(int i=0;i<6;i++){
			AppData appData=new AppData();
			list.add(appData);
		}
		AppData appData=new AppData();
		appData.setCode(R.drawable.add_app);
		list.add(appData);
		gridViewAdapter=new GridViewAdapter(this, list);
		gridView.setAdapter(gridViewAdapter);
		total_tv=(TextView) findViewById(R.id.total_fav_flow);
		total_tv.setText(getResources().getString(R.string.total_text).replace("d", String.valueOf(list.size())));
		choose_lay = findViewById(R.id.choose_lay);
		choose = findViewById(R.id.wares_sort);
		choose.setOnClickListener(this);
	}
	
	private void choice() {
		if (dialog != null) {
			dialog.show();
			return;
		}
		LayoutInflater inflater = LayoutInflater.from(this);
		View view = inflater.inflate(R.layout.view_find, null);
		Activity act = this;
		while (act.getParent() != null) {
			act = act.getParent();
		}
		dialog = new Dialog(act, R.style.dialog);
		listView = (ListView) view.findViewById(R.id.tradingListView);
		adapter=new TypeAdapter(this, typelist);
		listView.setAdapter(adapter);
		LayoutParams trLayoutParams = listView.getLayoutParams();
		if (trLayoutParams == null) {
			trLayoutParams = new LayoutParams(LayoutParams.FILL_PARENT,
					LayoutParams.WRAP_CONTENT);
		}
		trLayoutParams.width = getWindowManager().getDefaultDisplay()
				.getWidth() / 2;
		trLayoutParams.height = getWindowManager().getDefaultDisplay()
				.getHeight() / 2;
		listView.setLayoutParams(trLayoutParams);
		dialog.setContentView(view);
		WindowManager.LayoutParams localLayoutParams1 = new WindowManager.LayoutParams();
		localLayoutParams1.copyFrom(dialog.getWindow().getAttributes());
		localLayoutParams1.gravity = Gravity.TOP | Gravity.LEFT;
		localLayoutParams1.y = findViewById(R.id.radio_group).getBottom()+choose_lay.getBottom();
		dialog.getWindow().setAttributes(localLayoutParams1);
		dialog.setCanceledOnTouchOutside(true);
		dialog.show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.wares_sort:choice();break;
		}
	}
}
