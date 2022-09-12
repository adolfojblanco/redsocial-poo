package redsocial;

import java.time.LocalDate;

public class Comment {

	private String title;

	private LocalDate date;

	private User owner;

	public Comment(String comment, User owUser) {
		this.title = comment;
		this.date = LocalDate.now();
		this.owner = owUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getComment() {
		return title;
	}

	public void setComment(String comment) {
		this.title = comment;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return owner;
	}

	public void setUser(User user) {
		this.owner = user;
	}

}
