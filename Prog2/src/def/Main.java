package def;

import java.io.*;
import java.util.ArrayList;

import com.opencsv.exceptions.CsvValidationException;

public class Main {

	public static void main(String[] args) throws CsvValidationException, IOException {
		Playlist playlist = new Playlist();
		HistoryStack history = new HistoryStack();
		PrintStream ps = new PrintStream("output/output.txt");
		String[] namesOfWeeklyCharts = { "data/regional-global-weekly-2020-01-17--2020-01-24.csv",
				"data/regional-global-weekly-2020-02-14--2020-02-21.csv", "data/regional-us-weekly-latest.csv" };
		ArrayList<MyQueue> weeklyCharts = new ArrayList<>();
		// reads csv files and stores the queue data in the Araylist
		for (int k = 0; k < namesOfWeeklyCharts.length; k++) {
			weeklyCharts.add(new MyQueue(namesOfWeeklyCharts[k]));
		}
		//merges first two queues in the arraylist and puts to the playlist
		playlist = MyQueue.merge(weeklyCharts.get(0), weeklyCharts.get(2), playlist);
		//add queues one by one to the playlist
		for (int i = 2; i < weeklyCharts.size(); i++) {
			playlist = MyQueue.merge(playlist, weeklyCharts.get(i));
		}
		int play_size = playlist.size;
		//next loop is assuming that user is listening to whole playlist
		for (int i = 0; i < play_size; i++) {
			playlist.listen(history);
		}
		//prints history what user had listen
		ps.println();
		ps.println("-----------------------------History------------------------");
		for (int j = 0; j < history.size; j++) {
			ps.println();
			ps.println(history.pop());
		}
	}

}
