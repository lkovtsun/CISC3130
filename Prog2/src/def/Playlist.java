package def;

import java.io.PrintStream;

public class Playlist extends LinkedList {
	public static int size;

	//constructors
	public Playlist() {
		head = null;
		tail = null;
		size = 0;
	}

	public Playlist(Track first, Track last) {
		size = 0;
		head = first;
		tail = last;
	}
	
	//prints contents of the list
	public static void print(PrintStream ps) {
		Track k = head.next;
		for (int i = 0; i < size; i++) {
			ps.println(k.songName);
			k = k.next;
		}
	}

	//method to simulate that user is listening
	public static String listen(HistoryStack h) {
		if (!isEmpty()) {
			String name = head.songName;
			h.add(head);
			head = head.next;
			return name;

		}
		return "empty";
	}

	//appends track to the end of a playlist
	public void add(Track track) {

		if (isEmpty()) {
			Track track1 = new Track(track.songName, null, null);
			head = track1;
			tail = track1;
			size++;

		} else {
			Track previous = tail;
			Track track1 = new Track(track.songName, previous, null);
			previous.next = track1;
			tail = track1;
			size++;
		}
	}
}
