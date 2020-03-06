package def;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class MyQueue extends LinkedList {
	public static int size;
	//creates queue by reading one input file
	public MyQueue(String filename) throws CsvValidationException, IOException {
		size = readData(filename);
	}
	//reads the file and fills queue
	public static int readData(String filename) throws CsvValidationException, IOException {
		int size = 0;
		CSVReader reader = new CSVReader(new FileReader(filename));
		reader.skip(2);
		String[] tokens = reader.readNext();

		while (tokens != null) {
			String trackName = tokens[1].replaceAll("\"", "");
			if (isEmpty()) {
				Track track = new Track(trackName, null, null);

				head = track;
				tail = track;
				size++;// size of a queue

			} else {
				Track previous = tail;
				Track track = new Track(trackName, previous, null);
				previous.next = track;
				tail = track;
				size++;
			}
			tokens = reader.readNext();
		}
		reader.close();
		return size;
	}

	//method to add songs in the queue to the playlist
	public static Playlist merge(Playlist p1, MyQueue q2) {
		Playlist playlist;
		Track t2 = q2.head;
		playlist = p1;
		for (int i = 0; i < 200; i++) {
			playlist.add(t2);
			t2 = t2.next;
		}
		return playlist;

	}
	
	//method that prints the contents of a queue
	public static void print(PrintStream ps) {
		Track k = head.next;
		for (int i = 0; i < size; i++) {
			ps.println(k.songName);
			k = k.next;
		}
	}

	//method to find first alphabetical word
	public static int minIndex(MyQueue list) {
		int minIndex = -1;
		String leastName = "z";
		Track current = list.head.next;
		for (int i = 0; i < list.size; i++) {
			if (current.songName.compareToIgnoreCase(leastName) < 0) {
				leastName = current.songName;
				minIndex = i;
			}
		}
		return minIndex;
	}

	//method to insert a Track to the end of the queue
	public static void insertMin(MyQueue list, int min_index) {
		Track current = list.head.next;
		for (int i = 0; i <= min_index; i++) {
			if (i == min_index) {
				list.add(current);
				current.previous.next = current.next;
				current.next.previous = current.previous;
			}
			current = current.next;
		}
	}

	//main method of the sorting algorithm
	//implements selection sort
	public static void sortQueue(MyQueue list) {
		for (int i = 1; i <= list.size; i++) {
			int min_index = minIndex(list);
			insertMin(list, min_index);
		}
	}

	//merges two queues into a playlist
	public static Playlist merge(MyQueue q1, MyQueue q2, Playlist p) {

		// q1.print();
		// q2.print();

		Track t1 = q1.head;
		Track t2 = q2.head;
		for (int i = 0; i < 200; i++) {
			p.add(t1);
			t1 = t1.next;
		}
		for (int i = 0; i < 200; i++) {
			p.add(t2);
			t2 = t2.next;
		}
		return p;

	}
}
