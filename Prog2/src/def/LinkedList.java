package def;

public class LinkedList {
	public static Track head;
	public static Track tail;


	public void add(Track t) {
		t.next = tail;
		t.previous = tail.previous;
		tail.previous = t;
	}

	public String peek() {
		return head.songName;
	}

	public void element() {

	}

	public void poll() {

	}

	public void size() {

	}

	public static boolean isEmpty() {
		if (head == null) {
			return true;
		}
		return false;
	}

}
