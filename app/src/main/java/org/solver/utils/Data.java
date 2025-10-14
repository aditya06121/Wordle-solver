package org.solver.utils;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Data {
  private static final List<String> WORDS = new ArrayList<>();
  // stops reassignment
   static {
        loadWords();
    }
    public static List<String> getWords() {
        return WORDS;
    }
    private static void loadWords() {
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                Data.class.getClassLoader()
                    .getResourceAsStream("word_list.txt")
            ))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    WORDS.add(line);
                }
            }
            
            System.out.println("Loaded " + WORDS.size() + " words");
            
        } catch (IOException | NullPointerException e) {
            System.err.println("Error: word_list.txt not found in resources");
            e.printStackTrace();
        }
    }

   public static void getWordCount() {
        System.out.println(WORDS.size());
    }
}
