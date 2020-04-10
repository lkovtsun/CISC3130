Assignment 3

made by Liubomyr Kovtsun

* The program implemements maven built tool. The pom.xml file with program dependencies can be found in the root directory.
* Source code can be found in the src/def/ directory.
* Data used in the program is in data/ folder
* Output is in output/ folder

The program contains multiple classes (Movies, MoviesBST, Main). MoviesBST class acts as root for the binary search tree and simple tasks to find and subset. Movies class acts as storage place for the data and references to its children. Main class invokes methods and prints the data.

The program can store multiple input files. Open them and put it into the binary search tree. The program reads a section with name and release date from each row in the csv file. Then it splits name and year using a substring method. Creates a Movie object with a name and as an integer a release date. Then tries to put object into leaf of the tree by comparing by names. When everything is read, the program subsets a tree with two initial names. It first looks for the first movie object and creates the new mirror object with mirrored new objects in order to not to change references in the original tree. Then it creates a branch path to the second movie name. Afterwards the path is transferred to reference object and it prints the path with its movie names and release dates to the output file.

Note: The csv input data is corrupted or badly structured. For example, "Godfather: Part II, The (1974)" and sometimes release date is not mentioned or not in the parenthesis. It gave me small headache while finishing the program.
