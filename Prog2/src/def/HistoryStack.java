package def;

public class HistoryStack extends LinkedList {
	public static int size;
	public HistoryStack() {
		head = null;
		size = 0;
	}
	
	//method which append a track class to the stack
	public void add(Track trackName) {
		if (isEmpty()) {
			Track track1 = new Track(trackName.songName, null);
			head = track1;
			size++;// size of a queue
		} else {
			Track next = head;
			Track track1 = new Track(trackName.songName, next);
			head = track1;
			size++;
		}

	}

	//method to remove last element
	public static String pop() {
		if (!isEmpty()) {
			String name = head.songName;
			head = head.next;
			return name;
		}
		return "empty";
	}
}
