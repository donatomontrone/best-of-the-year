package org.java.demo.obj;

public class Movie {
	private int id;
	private int title;
	
	
	public Movie(int id, int title) {
		setId(id);
		setTitle(title);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	
	
}
