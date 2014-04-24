package com.ifidc.router.data;

import java.util.List;
import java.util.Vector;

public class PreferentialList1 {
	private int itemcount = 0;
	private List<PreferentilData1> itemlist;

	public PreferentialList1() {
		itemlist = new Vector(0);
	}

	public int addItem(PreferentilData1 item) {
		itemlist.add(item);
		itemcount++;
		return itemcount;
	}

	public PreferentilData1 getItem(int location) {
		return itemlist.get(location);
	}

	public List getAllItems() {
		return itemlist;
	}

	int getItemCount() {
		return itemcount;
	}
}
