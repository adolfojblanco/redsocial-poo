package redsocial;

public class Video extends Post{
	
	private String quality;
	
	private int seconds;
	
	
	

	public Video(String title, String quality, int seconds) {
		super(title);
		this.type = "Video";
		this.quality = quality;
		this.seconds = seconds;
	}




	public String getQuality() {
		return quality;
	}




	public void setQuality(String quality) {
		this.quality = quality;
	}




	public int getSeconds() {
		return seconds;
	}




	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	
	
	
	
	
	

}
