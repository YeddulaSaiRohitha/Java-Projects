import java.util.Scanner;

public class ShoppingCartCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Constants
        final double TAX_RATE = 0.07;

        // Input for Item 1
        System.out.print("Price of Item 1: ");
        double price1 = sc.nextDouble();
        System.out.print("Quantity of Item 1: ");
        int quantity1 = sc.nextInt();

        // Input for Item 2
        System.out.print("Price of Item 2: ");
        double price2 = sc.nextDouble();
        System.out.print("Quantity of Item 2: ");
        int quantity2 = sc.nextInt();

        // Input for Item 3
        System.out.print("Price of Item 3: ");
        double price3 = sc.nextDouble();
        System.out.print("Quantity of Item 3: ");
        int quantity3 = sc.nextInt();

        // Calculate subtotal for each item
        double subtotal1 = price1 * quantity1;
        double subtotal2 = price2 * quantity2;
        double subtotal3 = price3 * quantity3;

        // Calculate total before tax
        double totalBeforeTax = subtotal1 + subtotal2 + subtotal3;

        // Calculate total after tax
        double totalCost = totalBeforeTax + (totalBeforeTax * TAX_RATE);

        // Display results
        System.out.printf("Subtotal for Item 1: $%.2f%n", subtotal1);
        System.out.printf("Subtotal for Item 2: $%.2f%n", subtotal2);
        System.out.printf("Subtotal for Item 3: $%.2f%n", subtotal3);
        System.out.printf("Total Cost (including tax): $%.2f%n", totalCost);

        sc.close();
    }
}
