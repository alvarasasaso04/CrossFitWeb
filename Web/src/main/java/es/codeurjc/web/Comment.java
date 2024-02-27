package es.codeurjc.web;

public class Comment {

	private String user;
	private String title;
	private String text;

	public Comment() {

	}

	public Comment(String user, String title, String text) {
		super();
		this.user = user;
		this.title = title;
		this.text = text;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return "Comment [user=" + user + ", title=" + title + ", text=" + text + "]";
	}

}
