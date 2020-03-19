import java.io.IOException;
import java.io.PrintStream;

import com.opencsv.exceptions.CsvValidationException;

public class Main {

	public static void main(String[] args) throws CsvValidationException, IOException {
		PrintStream ps = new PrintStream("output/output.txt");
		String[] movieFiles = { "data/movies.csv"};
		MoviesBST movies = new MoviesBST();
		//reads data from files
		for (int k = 0; k < movieFiles.length; k++) {
			movies.readData(movieFiles[k]);
		}
		MoviesBST sample1, sample2,sample3;
		sample1=movies.subSet("Balto", "Dracula 2000");
		sample2=movies.subSet("Assassins", "Back to the Future");
		sample3=movies.subSet("Shrek", "Sicario");
		//prints subset samples
		ps.println("subset sample 1:");
		ps.println(sample1.first);
		ps.println("\nsubset sample 2:");
		ps.println(sample2.first);
		ps.println("\nsubset sample 3:");
		ps.println(sample3.first);
	}

}
