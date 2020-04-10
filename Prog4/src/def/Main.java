//Liubomyr Kovtsun

package def;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Main {

	public static void main(String[] args) throws IOException, CsvValidationException {
		PrintStream ps = new PrintStream("output/output.txt");
		String movieFile = "Data/movies.csv";
		HashMap<String, ArrayList> genres = new HashMap<>();//holds arraylists of movies with names, genres, and release dates
		HashMap<String, HashMap> genresY = new HashMap<>();//holds number of movies per each year per genre
		readData(movieFile, genres, ps);
		//gets all names simultaneously with cutting out square brackets
		String genres1 = genres.keySet().toString().substring(1, genres.keySet().toString().length() - 1);
		String[] names = genres1.split(",");
		ps.println("Genre Name    " + "           # Movies");
		for (int i = 0; i < names.length; i++) {
			ps.printf("%-20s \t %-10d%n", names[i].trim(), genres.get(names[i].trim()).size());
		}
		
		readYears(genres, genresY);
		ps.println();
		ps.println();
		ps.println("\t Number of Movies per Year per Genre");
		ps.printf("%-20s Years:\t", "Genres");
		// System.out.print(genresY.get(" Comedy").keySet());
		for (int i = 1980; i < 2021; i++) {
			ps.print(i + "\t");
		}
		ps.println();
		//prints table of yearly releases per genre
		for (int i = 0; i < names.length; i++) {
			String toPrint = "\t";
			for (int j = 1980; j < 2021; j++) {

				try {
					toPrint = toPrint + Integer.toString((int) genresY.get(names[i]).get(j)) + "\t";
				} catch (NullPointerException p) {
					toPrint = toPrint + 0 + "\t";
				}
			}
			ps.printf("%-20s        %s%n%n", names[i], toPrint);
		}

	}

	// creates a Hashmap with genres' years and count of movies in each year
	public static void readYears(HashMap genres_movies, HashMap genresYearHash) {
		ArrayList<Movie> movies;
		Movie movie;
		int year, count;
		String genres = genres_movies.keySet().toString().substring(1, genres_movies.keySet().toString().length() - 1);
		String[] names = genres.split(",");
		
		//iterates through each genre
		for (int i = 0; i < names.length; i++) {
			HashMap<Integer, Integer> hashMovieCount = new HashMap<>();
			movies = (ArrayList) genres_movies.get(names[i].trim());
			//iterates through each movie
			for (int j = 0; j < movies.size(); j++) {
				movie = movies.get(j);
				year = movie.year;
				//fills hashmap
				if (hashMovieCount.containsKey(year)) {
					count = hashMovieCount.get(year) + 1;
					hashMovieCount.replace(year, count);
				} else {
					hashMovieCount.put(year, 1);
				}
			}
			genresYearHash.put(names[i], hashMovieCount);
		}
	}
	
	// reads data information from input file
	public static void readData(String filename, HashMap genresHash, PrintStream ps)
			throws IOException, CsvValidationException {
		String nameYear;
		int length;
		Movie movie;
		CSVReader reader = new CSVReader(new FileReader(filename));
		reader.skip(1);
		String[] tokens = reader.readNext();
		while (tokens != null) {
			nameYear = tokens[1].trim();
			ArrayList<Movie> genre;// some specific genre
			movie = new Movie(Integer.parseInt(nameYear.substring(nameYear.length() - 5, nameYear.length() - 1)),
					nameYear.substring(0, nameYear.length() - 6).trim(), tokens[2]);
			String[] genresTotal = tokens[2].split("\\|");
			for (int i = 0; i < genresTotal.length; i++) {// iterates through each genre in the movie
				if (genresHash.containsKey(genresTotal[i].trim())) {// case when hash does contain same genre
					// ps.println(movie.name+" "+genresTotal[i]);
					genre = (ArrayList) genresHash.get(genresTotal[i]);
					genre.add(movie);
				} else {// creates new genre key in the hashmap
					ArrayList<Movie> genre1 = new ArrayList<>();
					genre1.add(movie);
					genresHash.put(genresTotal[i].trim(), genre1);
				}
			}
			tokens = reader.readNext();
		}
	}

}

class Movie {
	int year;
	String name, genre;

	public Movie(int y, String name, String genre) {
		year = y;
		this.name = name;
		this.genre = genre;
	}
}
