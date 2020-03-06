Assignment 2

made by Liubomyr Kovtsun

  * The program implemements maven built tool. The pom.xml file with program dependencies can be found in the root directory.
  * Source code can be found in the src/def/ directory.
  * Data used in the program is in data/ folder
  * Output is in output/ folder
  
  The program contains multiple classes (LinkedList, HistoryStack, Playlist, MyQueue, Main). 
        LinkedList class used to store the start and end of lists used in queues and stacks. 
        MyQueue class extends LinkedList and has main methods to work with a queue like to create queue,sort,merge,print its contents.  
        Playlist class is like MyQueue class but has method listen(), which in theory should be called when user listens a song. 
        HistoryStack class extends LinkedList and it is a stack where songs are placed when listened. 
        Main class make main calls and (currently not present) user interface which will prompt the user the options.
    
  The program has stored the name of input data files. Program opens each file and reads each name of the track and constructs
    Track object which holds name of the song. As it constructs, the Track is also placed into a queue. When loop finishes, queues
    with tracks are stored in the arraylist which can automaticaly increase as required. Then merging process starts, first
    first two queues in the arraylist merged together into one queue playlist. Later each other queue is apended to a playlist.
    When whole playlist of queues is formed listen() method is called which for now just removes the first element and puts to
    a history stack. When listening of whole playlist is completed, main prints songs in the history stack. In the program
    sorting method was not called, but is written in the MyQueue class and should oraganize queue in the alphabetical order.
