package redsocial;

import java.util.ArrayList;

public class Image extends Post {

	private int width;

	private int length;

	public Image(String title, ArrayList<Comment> comments, int width, int length) {
		super(title, comments);
		this.type = "Image";
		this.width = width;
		this.length = length;
	}

	public Image(String title, int width, int length) {
		super(title);
		this.type = "Image";
		this.width = width;
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Post [date=" + this.getDate() + ", title=" + this.getTitle() + ", + , type =" + this.getType() + "]";
	}

}
