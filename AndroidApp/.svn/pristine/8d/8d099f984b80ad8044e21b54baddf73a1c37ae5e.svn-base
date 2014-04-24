package com.ifidc.router.data;

import java.util.List;
import java.util.Vector;

public class ModuleContentList1 {
	private int itemcount = 0;
	private List<ModuleContentData1> itemlist;

	public ModuleContentList1() {
		itemlist = new Vector(0);
	}

	public int addItem(ModuleContentData1 item) {
		itemlist.add(item);
		itemcount++;
		return itemcount;
	}

	public ModuleContentData1 getItem(int location) {
		return itemlist.get(location);
	}

	public List getAllItems() {
		return itemlist;
	}

	int getItemCount() {
		return itemcount;
	}
}
