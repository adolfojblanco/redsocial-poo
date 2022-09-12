package redsocial;

import java.util.ArrayList;

public class Text extends Post {

	private String content;

	public Text(String title, String content) {
		super(title);
		this.type = "Text";
		this.content = content;
	}

	public Text(String title, String content, ArrayList<Comment> comments) {
		super(title, content, comments);
		this.type = "Text";

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
