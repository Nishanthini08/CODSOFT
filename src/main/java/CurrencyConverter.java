/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Currency Converter!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Convert USD to EUR");
            System.out.println("2. Convert EUR to USD");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertCurrency("USD", "EUR");
                    break;
                case 2:
                    convertCurrency("EUR", "USD");
                    break;
                case 3:
                    System.out.println("Thank you for using the Currency Converter!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void convertCurrency(String baseCurrency, String targetCurrency) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        // Fetch real-time exchange rates from API (replace with your API handling code)
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        if (exchangeRate == -1) {
            System.out.println("Failed to fetch exchange rates. Please try again later.");
            return;
        }

        double convertedAmount = amount * exchangeRate;
        System.out.printf("%.2f %s is equivalent to %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
    }

    // Replace with actual API call to fetch exchange rates
    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Example: Replace with your API integration code
        // Simulating API call (replace with real API integration)
        if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.85;  // Example rate for USD to EUR
        } else if (baseCurrency.equals("EUR") && targetCurrency.equals("USD")) {
            return 1.18;  // Example rate for EUR to USD
        } else {
            return -1;  // Handle error or unsupported conversion
        }
    }
}

