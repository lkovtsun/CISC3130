Assignment 4

made by Liubomyr Kovtsun

* The program implemements maven built tool. The pom.xml file with program dependencies can be found in the root directory.
* Source code can be found in the src/def/ directory.
* Data used in the program is in data/ folder
* Output is in output/ folder

First part of an assignment I accomplished by using a HashMap with genres keys and objects as an Arraylist of Movie objects which contain name, release date and genres of a movies. Also, this program is somewhat automated, for example while the program reads the input file it can read and create new genre key in hashmap and later to fill arraylist with such movies and later to print genres I use key set of hash mmap and to print the amount of movies at each genre I used the size of arraylist. This helps when input file can have different amounts of information.

Second part of the assignment I accomplished by creating nested hashmaps. Main hashmap contains each genre name as keys and other hashmap with release dates as keys and number of movies as a return. To create this new database I used precious hashmap with Movie objects because it already contains realease date instead of reading the file again. Similarly to first part it is automated. It automatically adds genres and counts movies released at particular year of that genre. Later, I print a table of movies between 1980 and 2020 years for each genre. I tried also to use python to create charts but it has few bugs and I was unable to accomplish it because it was first time using it.
