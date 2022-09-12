package redsocial;

import java.util.ArrayList;

public class User {

	private String name;

	private ArrayList<User> friends;

	private ArrayList<Post> posts;

	private ArrayList<Comment> comments;

	public User(String name) {
		this.name = name;
	}

	public User(String name, ArrayList<User> friends, ArrayList<Post> posts) {
		this.name = name;
		this.friends = friends;
		this.posts = posts;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<User> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}

	/**
	 * Show friends for the selected user
	 * 
	 * @return String
	 */

	public String showFriends() {

		StringBuilder sb = new StringBuilder();

		if (this.getFriends() != null && !this.getFriends().isEmpty()) {
			for (User user : friends) {
				sb.append(user.getName() + ", ");
			}
			return sb.toString();
		}
		sb.append("El usuario no tiene amigos registrados");
		return sb.toString();

	}

	public String showPost() {

		StringBuilder sb = new StringBuilder();

		if (this.getPosts() != null && !this.getPosts().isEmpty()) {

			sb.append("Publicaciones: ");
			for (Post p : posts) {
				sb.append(p.getTitle() + "," + this.name);
			}
			return sb.toString();
		}
		sb.append("El usuario no tiene amigos registrados");
		return sb.toString();

	}

	@Override
	public String toString() {
		return name;
	}

}
