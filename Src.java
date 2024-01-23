//Run UIConnector.java to launch v1
//Src file
// TODO: error handling in the input string.
// TODO: error due to repetition of characters in separate search category in the input string.
import java.util.*;
public class Src {
    // global variable declaration
    public static ArrayList<String> result_list = new ArrayList<>(Words_list.list());
    public static Map<Integer, Character> map = new HashMap<>();
    static void string_to_dictionary(String input_string) {
        map.clear();  // this solved a lot of problems
        for (int i = 0; i < input_string.length(); i += 2) {
            char key = input_string.charAt(i);
            int value = Character.getNumericValue(input_string.charAt(i + 1));
            map.put(value, key);
        }
    }

}
