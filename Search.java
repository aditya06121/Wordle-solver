/*
The Search code of this project
linear search for parsing the word list
written by aditya
*/
// TODO: yellow-search twice appearance of letter error.
import java.util.*;

public class Search {
    //global variable declaration

    public static void main(String[] args) {
        String a = "e0a4c3";
        Search.yellow_selector(a);
        System.out.println(Src.result_list);
    }

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
    //so that it also removes the letter from their mentioned index position
    static void yellow_selector(String input) {
        if (!Objects.equals(input, "null") && (input != null)) {
            List<String> elementsToRemove = new ArrayList<>();
            Iterator<String> iterator = Src.result_list.iterator();
            while (iterator.hasNext()) {  // this is iterating over EVERY WORD in the result_list.
                String element = iterator.next();
                Src.string_to_dictionary(input);  // initialization of hashmap to store input
                int total = Src.map.size();
                int count = 0;
                loop:
                for (int i = 0; i < element.length(); i++) {  // iterating over every char in the element.
                    Iterator<Map.Entry<Integer, Character>> iterator2 = Src.map.entrySet().iterator();  // initialization of the second iterator
                    while (iterator2.hasNext()) {  // iterating over every element in the hashmap.
                        Map.Entry<Integer, Character> entry = iterator2.next();
                        int key = entry.getKey();
                        char value = entry.getValue();
                        if ((element.charAt(i)==value)){
                            if (i==key){
                                elementsToRemove.add(element);
                                break loop;
                            }
                            count++;
                            iterator2.remove();
                        }
                    }
                }
                if (total > count)
                    iterator.remove();

            }
            Src.result_list.removeAll(elementsToRemove);
        }

    }
    static void yellow_selector_filter(String input){

    }
}