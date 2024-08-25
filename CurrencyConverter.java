import java.util.Scanner;

public class CurrencyConverter {
    private static final double USD_TO_EUR = 0.85; // Example exchange rate
    private static final double EUR_TO_USD = 1 / USD_TO_EUR;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Currency Converter");
        System.out.println("1. Convert USD to EUR");
        System.out.println("2. Convert EUR to USD");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter amount in USD: ");
            double amountUSD = scanner.nextDouble();
            double convertedAmount = convertUSDtoEUR(amountUSD);
            System.out.printf("%.2f USD is equivalent to %.2f EUR%n", amountUSD, convertedAmount);
        } else if (choice == 2) {
            System.out.print("Enter amount in EUR: ");
            double amountEUR = scanner.nextDouble();
            double convertedAmount = convertEURtoUSD(amountEUR);
            System.out.printf("%.2f EUR is equivalent to %.2f USD%n", amountEUR, convertedAmount);
        } else {
            System.out.println("Invalid option.");
        }

        scanner.close();
    }

    public static double convertUSDtoEUR(double amountUSD) {
        return amountUSD * USD_TO_EUR;
    }

    public static double convertEURtoUSD(double amountEUR) {
        return amountEUR * EUR_TO_USD;
    }
}
