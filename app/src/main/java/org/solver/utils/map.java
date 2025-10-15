package org.solver.utils;

import java.util.HashMap;
import java.util.Map;

public class map {
  /**
     * Converts input string to a map of position -> character.
     * Input format: "a0b2" becomes {0='a', 2='b'}
     * 
     * @param input String in format "char1pos1char2pos2..."
     * @return Map of position to character
     */
    public static Map<Integer, Character> parsePositions(String input) {
        Map<Integer, Character> positionMap = new HashMap<>();
        
        for (int i = 0; i < input.length(); i += 2) {
            char letter = input.charAt(i);
            int position = Character.getNumericValue(input.charAt(i + 1));
            positionMap.put(position, letter);
        }
        
        return positionMap;
    }
/**
 * Validates input string is not null or "null" string.
 *
 * @param input The input string to validate.
 * @return true if valid, false otherwise.
 */

    public static boolean isValidInput(String input) {
    return input != null && !input.equals("null");
}
}
