package com.ifidc.router.data;

import java.util.List;
import java.util.Vector;

public class ListViewList {
	private int itemcount = 0;
	private List<ListViewData> itemlist;

	public ListViewList() {
		itemlist = new Vector(0);
	}

	public int addItem(ListViewData item) {
		itemlist.add(item);
		itemcount++;
		return itemcount;
	}

	public ListViewData getItem(int location) {
		return itemlist.get(location);
	}

	public List getAllItems() {
		return itemlist;
	}

	int getItemCount() {
		return itemcount;
	}
}
