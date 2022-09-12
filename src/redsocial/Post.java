package redsocial;

import java.time.LocalDate;

import java.util.ArrayList;

public class Post {

	private LocalDate date;

	private String title;

	protected String type;

	private ArrayList<Comment> comments;

	protected User owner;

	public Post(String title) {
		this.date = LocalDate.now();
		this.title = title;
	}

	public Post(String title, User owner) {
		this.date = LocalDate.now();
		this.owner = owner;
		this.title = title;
	}

	public Post(String title, String type, ArrayList<Comment> comments) {
		this.date = LocalDate.now();
		this.title = title;
		this.type = type;
		this.comments = comments;
	}

	public Post(String title, ArrayList<Comment> comments) {
		this.date = LocalDate.now();
		this.title = title;
		this.comments = comments;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public Post(String title, String content) {
		this.date = LocalDate.now();
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Post [date=" + date + ", title=" + title + ", + , type=" + type + "]";
	}

}
