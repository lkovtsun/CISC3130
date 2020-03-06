package def;

public class Track {
	public String songName;
	public Track next;
	public Track previous;
	public Track() {
	}
	
	//constructors
	public Track(String songName, Track next,Track previous) {
		this.songName=songName;
		this.next=next;
		this.previous=previous;
	}
	public Track(String songName, Track next) {
		this.songName=songName;
		this.next=next;
	}
	//setters
	public void setNext(Track next) {
		this.next=next;
	}
	public void setPrevious(Track previous) {
		this.previous=previous;
	}
	
}
