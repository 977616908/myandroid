package com.ifidc.router.data;

import java.util.List;
import java.util.Vector;

public class MakeTrafficList1 {
	private int itemcount = 0;
	private List<MakeTrafficData1> itemlist;

	public MakeTrafficList1() {
		itemlist = new Vector(0);
	}

	public int addItem(MakeTrafficData1 item) {
		itemlist.add(item);
		itemcount++;
		return itemcount;
	}

	public MakeTrafficData1 getItem(int location) {
		return itemlist.get(location);
	}

	public List getAllItems() {
		return itemlist;
	}

	int getItemCount() {
		return itemcount;
	}
}
