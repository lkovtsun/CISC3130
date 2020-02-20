package A1;


public class Artist {
	private String artistName;
	public Artist next;
	
	//Constructors
	public Artist() {
		artistName = "";
	}

	public Artist(String name) {
		artistName = name;
	}
	
	// setters and getters
	public void setName(String artistName) {
		this.artistName = artistName;
	}

	public String getName() {
		return artistName;
	}
}

class TopStreamingArtists {
	private Artist first;

	//constructor
	public void TopStreamingArtists() {
		first = null;
	}
	
	//getter
	public Artist getArtist() {
		return first;
	}
	
	// Links new Artist objects. Inserts Artist object to a linked list.
	public void insert(String name) {
		Artist newArtist = new Artist(name);
		newArtist.next = first;
		first = newArtist;
	}
	
	// Checks if its the end of linked list
	public boolean isEmpty() {
		return (first == null);
	}

}
