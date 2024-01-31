/**
 * The `Src` class serves as a source file containing utility methods for handling input strings.
 * It includes a method to convert a specific format of input string into a dictionary.

 * The class utilizes a global ArrayList 'result_list' and a Map 'map' for storing and processing data.
 */
// TODO: Implement error handling in the input string.
// TODO: Implement error handling for repetition of characters in separate search categories in the input string.
import java.util.*;
public class Src {
    // Global variable declaration

    /**
     * An ArrayList that stores a list of words retrieved from the 'Words_list' class.
     */
    public static ArrayList<String> result_list = new ArrayList<>(Words_list.list());

    /**
     * A Map that associates integer values with characters, used in the 'string_to_dictionary' method.
     */
    public static Map<Integer, Character> map = new HashMap<>();

    /**
     * Converts a specific format of input string into a dictionary.
     *
     * The input string is expected to be in pairs of characters and numeric values, where each pair represents
     * a key-value pair in the dictionary. The characters represent keys, and numeric values represent values.
     * The method populates the global 'map' variable with these key-value pairs.
     *
     * @param input_string The input string in the specified format.
     */
    static void string_to_dictionary(String input_string) {
        map.clear();  // this solved a lot of problems
        for (int i = 0; i < input_string.length(); i += 2) {
            char key = input_string.charAt(i);
            int value = Character.getNumericValue(input_string.charAt(i + 1));
            map.put(value, key);
        }
    }

}
