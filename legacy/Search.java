/**
 * The Search class implements a word search functionality using various methods.
 * It includes a linear search for parsing a word list and filtering words based on specific criteria.
 * The code is written by Aditya.
 */
import java.util.*;

public class Search {
    /**
     * The main method serves as a test bed for the search functionality.
     * It demonstrates the usage of the yellow_selector method with a sample input.
     */
    public static void main(String[] args) {
        String a = "e0a4c3";
        Search.yellow_selector(a);
        System.out.println(Src.result_list);
    }

    /**
     * Eliminates words from the result list that contain specific letters.
     *
     * @param input A string containing letters to be excluded from the word list.
     */
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

    /**
     * Filters words based on the position of specific letters in the word.
     *
     * @param input A string containing letters and their corresponding indices.
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

    /**
     * Searches for words containing characters from the input string in any order.
     * Removes words with characters in the same index position as the input string.
     *
     * @param input A string containing characters to be matched with the word list.
     */

    static void yellow_selector(String input) {
        if (!Objects.equals(input, "null") && (input != null)) {
            Iterator<String> iterator = Src.result_list.iterator();
            while (iterator.hasNext()) {
                String element = iterator.next();
                Src.string_to_dictionary(input);
                int total = Src.map.size();
                int count = 0;
                for (int i = 0; i < element.length(); i++) {
                    Iterator<Map.Entry<Integer, Character>> iterator2 = Src.map.entrySet().iterator();
                    while (iterator2.hasNext()) {
                        Map.Entry<Integer, Character> entry = iterator2.next();
                        char value = entry.getValue();
                        if ((element.charAt(i)==value)){
                            count++;
                            iterator2.remove();
                        }
                    }
                }
                if (total > count)
                    iterator.remove();

            }
            yellow_selector_filter(input);
        }

    }

    /**
     * Filters words based on the exact position of characters in the word as specified in the input string.
     *
     * @param input A string containing characters and their corresponding indices.
     */

    static void yellow_selector_filter(String input){
        Src.string_to_dictionary(input);
        boolean shouldRemove;
        Iterator<String> iterator = Src.result_list.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            shouldRemove = false;
            for (Map.Entry<Integer, Character> entry : Src.map.entrySet()) {
                int key = entry.getKey();
                char value = entry.getValue();
                if (element.charAt(key) == value) {
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