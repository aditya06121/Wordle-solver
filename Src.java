//The main source code of this project
//written by aditya

import java.util.*;

public class Src {
    //global variable declaration
    public static ArrayList<String> result_list = new ArrayList<>(Words_list.list());
    public static Map<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) {
        String a = "a2t4";
        String b = "whrf";
        String c = "a1t2c3";
        Search.green_selector(a);
        Search.eliminator(b);
        Search.yellow_selector(c);
        System.out.println(Src.result_list);

    }


    //function for generating a hash map for key value pairs.
    static void string_to_dictionary(String input_string) {
        for (int i = 0; i < input_string.length(); i += 2) {
            char key = input_string.charAt(i);
            int value = Character.getNumericValue(input_string.charAt(i + 1));
            map.put(value, key);
        }
    }
}