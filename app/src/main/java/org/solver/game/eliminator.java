package org.solver.game;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.solver.utils.Data;

public class eliminator {
  public static void eliminate(String input) {
        if (input == null || input.isEmpty() || input.equals("null")) {
            return;
        }
        
        // Convert input to Set for faster lookup
        Set<Character> charsToEliminate = new HashSet<>();
        for (char c : input.toCharArray()) {
            charsToEliminate.add(c);
        }
        
        List<String> words = Data.getWords();
        Iterator<String> iterator = words.iterator();
        
        while (iterator.hasNext()) {
            String word = iterator.next();
            
            if (containsAnyCharacter(word, charsToEliminate)) {
                iterator.remove();
            }
        }
        
        System.out.println("Eliminated words. Remaining: " + words.size());
    }
    private static boolean containsAnyCharacter(String word, Set<Character> chars) {
        for (char c : word.toCharArray()) {
            if (chars.contains(c)) {  // O(1) lookup
                return true;
            }
        }
        return false;
    }
}
