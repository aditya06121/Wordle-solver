//execute this for Wordle_solver version 1.0
//This is the current UI of the program ver-1.0
//written by aditya
//UI connector requires extensive debugging
//exception catching is not implemented yet

import java.util.Scanner;

public class UIConnector {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <= 80; i++)
            System.out.print("_");
        Thread.sleep(500);
        System.out.println("\n\t\t\t\t\t\t\tWordle Solver!");
        Thread.sleep(500);
        System.out.println("Version 1.0");
        Thread.sleep(500);
        System.out.println("First, try any word which comes to your mind");
        Thread.sleep(500);
        System.out.println("Don't repeat the arguments which were already entered!");
        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {

            System.out.print("Enter the green letters together with their position in zero index:- ");
            String green = scanner.next();
            Search.green_selector(green);


            System.out.print("Enter the yellow letters:- ");
            String yellow = scanner.next();
            Search.yellow_selector(yellow);


            System.out.print("Enter the grayed-out letters:- ");
            String grey = scanner.next();
            Search.eliminator(grey);

            System.out.println(Src.result_list);

            System.out.print("Did you get the correct word? ");
            boolean check = Boolean.parseBoolean(scanner.next());
            if (check) {
                break;
            }
        }
        for (int i = 0; i <= 80; i++)
            System.out.print("_");
        scanner.close();
    }
}