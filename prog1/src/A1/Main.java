package A1;

import java.io.*;
import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Main {

	public static void main(String[] args) throws Exception {
		PrintStream ps = new PrintStream("output/output.txt");
		String[][] topArtists = new String[200][2];
		int arraySize;
		arraySize = readData(topArtists);
		printData(arraySize, topArtists, ps);
		TopStreamingArtists artistNames = new TopStreamingArtists();
		assembleLinkedList(topArtists, arraySize, artistNames);
		sort(artistNames);
		printList(artistNames, ps);

	}

	// Reads data from csv file to a double array
	public static int readData(String[][] topArtists) throws CsvValidationException, IOException {
		int size = 0, i;
		CSVReader reader = new CSVReader(new FileReader("data/regional-global-weekly-2020-01-17--2020-01-24.csv"));
		reader.skip(2);
		String[] tokens = reader.readNext();
		while (tokens != null) {
			String name = tokens[2].replaceAll("\"", "");

			i = findArtist(topArtists, name, size);
			if (i == -1) {
				// artist name
				topArtists[size][0] = name;
				// initial count
				topArtists[size][1] = "1";
				size++;
			} else {
				int count = Integer.parseInt(topArtists[i][1]) + 1;
				topArtists[i][1] = Integer.toString(count);
			}
			tokens = reader.readNext();
		}
		reader.close();
		return size;
	}

	// Searches for an artist
	public static int findArtist(String[][] artists, String name, int size) {
		for (int i = 0; i < size; i++) {
			if (name.equalsIgnoreCase(artists[i][0])) {
				return i;
			}
		}
		return -1;
	}

	// Creates a linked list from double array
	public static void assembleLinkedList(String[][] topArtists, int size, TopStreamingArtists artists) {
		for (int i = 0; i < size; i++) {
			artists.insert(topArtists[i][0]);
		}
	}

	// Prints an array of Strings with Artist names and count
	public static void printData(int size, String[][] artists, PrintStream ps) {
		ps.println("Artist\t\t\t\t\t\tCount");
		for (int i = 0; i < size; i++) {
			ps.printf("%-20s \t\t\t\t %-2s %n", artists[i][0], artists[i][1]);
		}
	}

	// Prints sorted Linked list of artist names
	public static void printList(TopStreamingArtists artists, PrintStream ps) {
		Artist temp = artists.getArtist();
		ps.println();
		ps.println("Alphabetically Sorted Names");
		ps.println();
		while (temp != null) {

			ps.println(temp.getName());
			temp = temp.next;
		}
	}

	// Sorts alphabetically a linked list of artists
	public static void sort(TopStreamingArtists artists) {
		Artist head = artists.getArtist();
		Artist current = head;
		Artist pointer = head;
		while (current != null) {
			pointer = head;
			while (pointer != current) {
				if (pointer.getName().compareToIgnoreCase(current.getName()) > 0) {
					String tempName = current.getName();
					current.setName(pointer.getName());
					pointer.setName(tempName);
				} else {
					pointer = pointer.next;
				}
			}
			current = current.next;
		}
	}

}