package org.solver.game;

import java.util.List;
import java.util.Map;
import java.util.Iterator;

import org.solver.utils.Data;
import org.solver.utils.map;

public class greenSelector {
  /**
     * Keeps only words where specified characters appear at exact positions.
     * Input format: "a0b2c4" means 'a' at position 0, 'b' at position 2, 'c' at position 4
     * 
     * @param input String with character-position pairs (e.g., "a0e1l3")
     */
    public static void filterByPosition(String input) {
        if (input == null || input.isEmpty() || input.equals("null")) {
            return;
        }
        
        // Convert input string to position map
        Map<Integer, Character> positionMap = map.parsePositions(input);
        
        List<String> words = Data.getWords();
        Iterator<String> iterator = words.iterator();
        
        while (iterator.hasNext()) {
            String word = iterator.next();
            
            if (!matchesAllPositions(word, positionMap)) {
                iterator.remove();
            }
        }
        
        System.out.println("Green filter applied. Remaining: " + words.size());
    }
    
    
    
    /**
     * Checks if a word has the specified characters at the exact positions.
     * 
     * @param word The word to check
     * @param positionMap Map of position -> required character
     * @return true if all positions match, false otherwise
     */
    private static boolean matchesAllPositions(String word, Map<Integer, Character> positionMap) {
        for (Map.Entry<Integer, Character> entry : positionMap.entrySet()) {
            int position = entry.getKey();
            char requiredChar = entry.getValue();
            
            // Check if word is long enough and has the right character
            if (position >= word.length() || word.charAt(position) != requiredChar) {
                return false;
            }
        }
        return true;
    }
}
