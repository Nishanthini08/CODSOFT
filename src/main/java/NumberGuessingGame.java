/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int totalRounds = 0;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + minRange + " and " + maxRange);

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = minRange + (int) (Math.random() * (maxRange - minRange + 1));
            int attempts = 0;

            System.out.println("\nRound " + (totalRounds + 1));
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed it right.");
                    totalScore += maxAttempts - attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've exhausted all attempts. The number was " + targetNumber);
            }

            totalRounds++;
            System.out.print("Play again? (yes/no): ");
            String playChoice = sc.next().toLowerCase();
            playAgain = playChoice.equals("yes");
        }

        System.out.println("\nGame over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total score: " + totalScore);
    }
}

