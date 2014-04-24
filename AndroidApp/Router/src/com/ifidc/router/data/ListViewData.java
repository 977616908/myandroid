package com.ifidc.router.data;

public class ListViewData {
	private String id;
	private String title;
	private String pic;
	private String intro;
	private String updatetime;
	private String ContAdd;

	public ListViewData(String id, String title, String pic, String intro,
			String updatetime, String contAdd) {
		super();
		this.id = id;
		this.title = title;
		this.pic = pic;
		this.intro = intro;
		this.updatetime = updatetime;
		ContAdd = contAdd;
	}

	public ListViewData() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getContAdd() {
		return ContAdd;
	}

	public void setContAdd(String contAdd) {
		ContAdd = contAdd;
	}

}
