/**
 * The `Words_list` class is responsible for reading words from a text file and storing them in an ArrayList.
 * It provides a static method, `list()`, that returns an ArrayList containing the words from the specified file.

 * The words are expected to be provided in the 'word_list.txt' file located in the same directory as the program.
 */
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Words_list {

    /**
     * Reads words from a text file and returns an ArrayList containing those words.

     * The words are expected to be provided in the 'word_list.txt' file. Each line in the file represents a word
     * to be added to the ArrayList.
     *
     * @return An ArrayList containing words read from the 'word_list.txt' file.
     */
    static ArrayList<String> list() {
        ArrayList<String> list = new ArrayList<>();  //Arraylist is created to store the words form the text file.
        String file_path = "word_list.txt"; // Path to the words list file
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                //to add the words in the text file into the ArrayList
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("The words list file is missing!");
        }
        // Returning the ArrayList containing words from the file
        return list;
    }
}