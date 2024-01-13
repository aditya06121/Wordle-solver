/*
The Search code of this project
linear search for parsing the word list
written by aditya
*/

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Search {

    //eliminator is used to remove the words with the letters which are present in the input string.
    static void eliminator(String input) {
        if (!Objects.equals(input, "null") && input != null) {
            boolean shouldRemove;
            Iterator<String> iterator = Src.result_list.iterator();
            while (iterator.hasNext()) {
                String element = iterator.next();
                shouldRemove = false;
                for (int i = 0; i < element.length(); i++) {
                    for (int ii = 0; ii < input.length(); ii++) {
                        if (input.charAt(ii) == element.charAt(i)) {
                            shouldRemove = true;
                            break;
                        }
                    }
                    if (shouldRemove) {
                        break;
                    }
                }
                if (shouldRemove) {
                    iterator.remove();
                }
            }
        }
    }

    /*
    this function checks if the given letter is at the particular index as mentioned in the input.
      key=char value=int(index)
        works don't change!
        */
    static void green_selector(String input) {
        if (!Objects.equals(input, "null") && input != null) {
            Src.string_to_dictionary(input);
            boolean shouldRemove;
            Iterator<String> iterator = Src.result_list.iterator();
            while (iterator.hasNext()) {
                String element = iterator.next();
                shouldRemove = false;
                for (Map.Entry<Integer, Character> entry : Src.map.entrySet()) {
                    int key = entry.getKey();
                    char value = entry.getValue();
                    if (element.charAt(key) != value) {
                        shouldRemove = true;
                        break;
                    }
                }
                if (shouldRemove) {
                    iterator.remove();
                }
            }
        }
    }

    //this function can be modified
    //modifying this method so that it also removes the letter from their mentioned index position
    static void yellow_selector(String input) {
        if (!Objects.equals(input, "null") && input != null) {
            Src.string_to_dictionary(input);
            boolean shouldKeep;
            Iterator<String> iterator = Src.result_list.iterator();
            while (iterator.hasNext()) {
                String element = iterator.next();
                shouldKeep = false;
                for (int i = 0; i < element.length(); i++) {
                    boolean found = false;
                    for (int ii = 0; ii < input.length(); ii++) {
                        if (input.charAt(ii) == element.charAt(i)) {
                            found = true;
                            break;
                        }
                    }

                    for (Map.Entry<Integer, Character> entry : Src.map.entrySet()) {
                        int key = entry.getKey();
                        char value = entry.getValue();
                        if (element.charAt(key) != value) {
                            found = false;
                            break;
                        }
                    }

                    if (found) {
                        shouldKeep = true;
                        break;
                    }
                }
                if (!shouldKeep) {
                    iterator.remove();
                }
            }
        }
    }
}