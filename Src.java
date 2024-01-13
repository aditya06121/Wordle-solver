/*
The main source code of this project
written by aditya
*/

import java.util.*;

public class Src {
    //global variable declaration
    public static ArrayList<String> result_list = new ArrayList<>(Words_list.list());
    public static Map<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) {
        String a = "a2a4";
        String b = "b5c6";
        String c = "z7d0";
        string_to_dictionary(a);
        System.out.println(map);
        string_to_dictionary(b);
        System.out.println(map);
        string_to_dictionary(c);
        System.out.println(map);

    }


    //function for generating a hash map for key value pairs.
    static void string_to_dictionary(String input_string) {
        map.clear();  // this solved a lot of problems
        for (int i = 0; i < input_string.length(); i += 2) {
            char key = input_string.charAt(i);
            int value = Character.getNumericValue(input_string.charAt(i + 1));
            map.put(value, key);
        }
    }
}