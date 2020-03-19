import java.io.*;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class MoviesBST {
	public Movies first;

	public void readData(String filename) throws IOException, CsvValidationException {
		String nameYear;
		int length;
		CSVReader reader = new CSVReader(new FileReader(filename));
		reader.skip(1);
		String[] tokens = reader.readNext();
		while (tokens != null) {
			if (first == null) {
				first = new Movies();
				nameYear = tokens[1];
				length = nameYear.length();
				first.name = nameYear.substring(0, length - 6).trim();
				first.releaseDate = Integer.parseInt(nameYear.substring(length - 5, length - 1));
			} else {
				Movies movie = new Movies();
				nameYear = tokens[1];
				nameYear = nameYear.trim();
				length = nameYear.length();
				movie.name = nameYear.substring(0, length - 6).trim();
				movie.releaseDate = Integer.parseInt(nameYear.substring(length - 5, length - 1));
				first.add(movie);
			}
			tokens = reader.readNext();
		}
	}

	// method to search an movie object by a name
	public Movies find(String name) {
		Movies m = null;
		if (first.name.equalsIgnoreCase(name)) {
			m = first;
		} else if (first.name.compareToIgnoreCase(name) < 0) {
			m = first.right.find(name);
		} else if (first.name.compareTo(name) > 0) {
			m = first.left.find(name);
		}
		return m;
	}

	// method to subset end of a tree
	public void csubset(Movies m, String name2) {
		if (m.name.compareToIgnoreCase(name2) < 0) {
			m.left = null;
			csubset(m.right, name2);
		} else if (m.name.compareToIgnoreCase(name2) > 0) {
			m.right = null;
			csubset(m.left, name2);
		} else if (m.name.equalsIgnoreCase(name2)) {
			m.right = null;
			m.left = null;
		}
	}

	// method to subset start of the tree
	public MoviesBST subSet(String startingName, String name2) {
		MoviesBST newSubset = new MoviesBST();
		Movies start = find(startingName);
		csubset(start, name2);
		newSubset.first = start;
		return newSubset;
	}
}
