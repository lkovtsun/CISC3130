
public class Movies {
	public String name;
	public int releaseDate;
	public Movies right;
	public Movies left;

	public Movies() {

	}

	//constructor
	public Movies(String name, int year, Movies right, Movies left) {
		this.name = name;
		releaseDate = year;
		if (left != null)
			this.left = new Movies(left.name, left.releaseDate, left.right, left.left);
		if (right != null)
			this.right = new Movies(right.name, right.releaseDate, right.right, right.left);
	}

	//adds movie object to a tree
	public void add(Movies m) {
		if (m.name.compareToIgnoreCase(name) > 0) {
			if (right == null) {
				right = m;
			} else {
				right.add(m);
			}
		} else if (m.name.compareToIgnoreCase(name) < 0) {
			if (left == null) {
				left = m;
			} else {
				left.add(m);
			}
		}
	}
	
	//prints content of the binary search tree
	public String toString() {
		String toReturn = name + "  " + Integer.toString(releaseDate);
		if (right != null) {
			toReturn = toReturn + "\n" + right.toString();
		}
		if (left != null) {
			toReturn = toReturn + "\n" + left.toString();
		}
		return toReturn;
	}

	// method to search an movie object by a name
	public Movies find(String name) {
		Movies m = null;
		if (this.name.equalsIgnoreCase(name)) {
			m = new Movies(name, releaseDate, right, left);
		} else if (this.name.compareToIgnoreCase(name) < 0) {
			m = right.find(name);
		} else if (this.name.compareTo(name) > 0) {
			m = left.find(name);
		}
		return m;
	}
}