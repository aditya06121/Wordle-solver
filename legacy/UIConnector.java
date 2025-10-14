/**
 * Welcome to the Wordle Solver version 1.5 UI!
 * This is the current face of the program, crafted by the one and only Aditya.
 * Please note that exceptional catching is yet to be implemented, so catch them if you can!
 */
import java.util.Objects;
import java.util.Scanner;

public class UIConnector {
    /**
     * The main method where the Wordle magic happens!
     *
     * @param args Command-line arguments (currently not feeling chatty).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Drawing a virtual curtain for dramatic effect
        for (int i = 0; i <= 80; i++)
            System.out.print("_");
        System.out.println("\n\t\t\t\t Wordle Solver!");
        System.out.println("Version 1.5");
        System.out.println("First, impress us with any word that pops into your mind.");
        System.out.println("But, hey, no repeating letters allowed! Let's keep it fresh!");

        // A series of interactions for the Wordle guessing game
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the green letters along with their position (in zero index): ");
            String green = scanner.next();
            Search.green_selector(green);

            System.out.print("Now, the yellow letters and their sneaky positions (zero-indexed, please): ");
            String yellow = scanner.next();
            Search.yellow_selector(yellow);

            System.out.print("Finally, the greyed-out letters (enter them discreetly): ");
            String grey = scanner.next();
            Search.eliminator(grey);

            // Displaying the current list of potential words
            System.out.println(Src.result_list);

            // Asking the million-dollar question
            System.out.print("Did you crack the code and unveil the secret word? (y/n) ");
            String check = scanner.next();
            if (Objects.equals(check, "y")) {
                break; // Exiting the loop if the word is cracked (or if they give up!)
            }
        }

        // Drawing the curtain again, because every good show needs a grand finale!
        for (int i = 0; i <= 80; i++)
            System.out.print("_");

        // Closing the scanner, because we're polite like that
        scanner.close();
    }
}
