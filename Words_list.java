/*
written by aditya
this program stores the words provided in the words list to an ArrayList and returns that list for parsing.
*/

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Words_list {
    public static void main(String[] args) {
        //the main method is for testing and debugging.
        //String l = list().get(2);
        System.out.print(list().size());
    }

    static ArrayList<String> list() {
        ArrayList<String> list = new ArrayList<>();  //Arraylist is created to store the words form the text file.
        String file_path = "word_list.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                //to add the words in the text file into the ArrayList
                list.add(line);
            }
        } catch (IOException e) {
            System.out.println("The words list file is missing!");
        }
        return list;
    }
}