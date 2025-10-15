package org.solver.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import org.solver.utils.Data;
import org.solver.utils.map;

public class yellowSelector {
    /**
     * Searches for words containing characters from the input string in any order.
     * Then removes words with characters in the same index position as the input string.
     * Input format: "a0b2" means contains 'a' and 'b', but not at positions 0 and 2 respectively.
     * 
     * @param input String with character-position pairs (e.g., "a0e1l3")
     */
    public static void filterByCharactersNotAtPositions(String input) {
        if (!map.isValidInput(input)) {
            return;
        }
        
        Map<Integer, Character> positionMap = map.parsePositions(input);
        
        removeWordsWithoutRequiredCharacters(positionMap);
        removeWordsWithMatchingPositions(positionMap);
        
        List<String> words = Data.getWords();
        System.out.println("Yellow filter applied. Remaining: " + words.size());
    }
    
    /**
     * Removes words that don't contain all required characters.
     * 
     * @param positionMap Map of position -> character (we only care about characters)
     */
    private static void removeWordsWithoutRequiredCharacters(Map<Integer, Character> positionMap) {
        List<String> words = Data.getWords();
        Iterator<String> iterator = words.iterator();
        
        while (iterator.hasNext()) {
            String word = iterator.next();
            
            if (!containsAllCharacters(word, positionMap)) {
                iterator.remove();
            }
        }
    }
    
    /**
     * Removes words where any character appears at the specified position.
     * 
     * @param positionMap Map of position -> character to avoid at that position
     */
    private static void removeWordsWithMatchingPositions(Map<Integer, Character> positionMap) {
        List<String> words = Data.getWords();
        Iterator<String> iterator = words.iterator();
        
        while (iterator.hasNext()) {
            String word = iterator.next();
            
            if (hasCharacterAtSpecifiedPosition(word, positionMap)) {
                iterator.remove();
            }
        }
    }
    
    /**
     * Checks if a word contains all characters from the position map.
     * 
     * @param word The word to check
     * @param positionMap Map of position -> character
     * @return true if word contains all characters, false otherwise
     */
    private static boolean containsAllCharacters(String word, Map<Integer, Character> positionMap) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        
        // Count frequency of each character in the word
        for (char c : word.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        
        // Count required characters from position map
        Map<Character, Integer> requiredChars = new HashMap<>();
        for (Character c : positionMap.values()) {
            requiredChars.put(c, requiredChars.getOrDefault(c, 0) + 1);
        }
        
        // Check if word has all required characters
        for (Map.Entry<Character, Integer> entry : requiredChars.entrySet()) {
            char requiredChar = entry.getKey();
            int requiredCount = entry.getValue();
            
            if (charFrequency.getOrDefault(requiredChar, 0) < requiredCount) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Checks if a word has any character at the same position as in the position map.
     * 
     * @param word The word to check
     * @param positionMap Map of position -> character to avoid
     * @return true if any character matches at the specified position, false otherwise
     */
    private static boolean hasCharacterAtSpecifiedPosition(String word, Map<Integer, Character> positionMap) {
        for (Map.Entry<Integer, Character> entry : positionMap.entrySet()) {
            int position = entry.getKey();
            char forbiddenChar = entry.getValue();
            
            if (position < word.length() && word.charAt(position) == forbiddenChar) {
                return true;
            }
        }
        return false;
    }
}
