import java.awt.*;
import java.awt.event.*;

public class ShoppingCartAWT extends Frame implements ActionListener {
    // Components for prices, quantities, and totals
    TextField price1, quantity1, price2, quantity2, price3, quantity3, totalCost;
    Button calculateButton, resetButton;
    Label subtotal1Label, subtotal2Label, subtotal3Label;

    public ShoppingCartAWT() {
        // Set layout
        setLayout(new FlowLayout());

        // Labels and TextFields for Item 1
        add(new Label("Price of Item 1:"));
        price1 = new TextField(10);
        add(price1);

        add(new Label("Quantity of Item 1:"));
        quantity1 = new TextField(10);
        add(quantity1);

        // Labels and TextFields for Item 2
        add(new Label("Price of Item 2:"));
        price2 = new TextField(10);
        add(price2);

        add(new Label("Quantity of Item 2:"));
        quantity2 = new TextField(10);
        add(quantity2);

        // Labels and TextFields for Item 3
        add(new Label("Price of Item 3:"));
        price3 = new TextField(10);
        add(price3);

        add(new Label("Quantity of Item 3:"));
        quantity3 = new TextField(10);
        add(quantity3);

        // Subtotal labels
        subtotal1Label = new Label("Subtotal for Item 1: ");
        add(subtotal1Label);
        subtotal2Label = new Label("Subtotal for Item 2: ");
        add(subtotal2Label);
        subtotal3Label = new Label("Subtotal for Item 3: ");
        add(subtotal3Label);

        // Total cost label and text field
        add(new Label("Total Cost (including tax):"));
        totalCost = new TextField(15);
        totalCost.setEditable(false); // Non-editable total cost field
        add(totalCost);

        // Buttons to calculate total and reset
        calculateButton = new Button("Calculate Total");
        resetButton = new Button("Reset");
        add(calculateButton);
        add(resetButton);

        // Add action listeners to the buttons
        calculateButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Set Frame properties
        setTitle("Shopping Cart Calculator");
        setSize(350, 400);
        setVisible(true);

        // Close the frame on clicking close
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Event handler for button actions
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                // Get input values for price and quantity of items
                double item1Price = Double.parseDouble(price1.getText());
                int item1Quantity = Integer.parseInt(quantity1.getText());
                double item2Price = Double.parseDouble(price2.getText());
                int item2Quantity = Integer.parseInt(quantity2.getText());
                double item3Price = Double.parseDouble(price3.getText());
                int item3Quantity = Integer.parseInt(quantity3.getText());

                // Calculate subtotals
                double subtotal1 = item1Price * item1Quantity;
                double subtotal2 = item2Price * item2Quantity;
                double subtotal3 = item3Price * item3Quantity;

                // Display subtotals
                subtotal1Label.setText("Subtotal for Item 1: $" + String.format("%.2f", subtotal1));
                subtotal2Label.setText("Subtotal for Item 2: $" + String.format("%.2f", subtotal2));
                subtotal3Label.setText("Subtotal for Item 3: $" + String.format("%.2f", subtotal3));

                // Calculate total cost with 7% tax
                double totalBeforeTax = subtotal1 + subtotal2 + subtotal3;
                double totalWithTax = totalBeforeTax + (totalBeforeTax * 0.07);

                // Display total cost
                totalCost.setText("$" + String.format("%.2f", totalWithTax));
            } catch (NumberFormatException ex) {
                totalCost.setText("Invalid input");
            }
        } else if (e.getSource() == resetButton) {
            // Reset all input and output fields
            price1.setText("");
            quantity1.setText("");
            price2.setText("");
            quantity2.setText("");
            price3.setText("");
            quantity3.setText("");
            subtotal1Label.setText("Subtotal for Item 1: ");
            subtotal2Label.setText("Subtotal for Item 2: ");
            subtotal3Label.setText("Subtotal for Item 3: ");
            totalCost.setText("");
        }
    }

    // Main method to launch the application
    public static void main(String[] args) {
        new ShoppingCartAWT();
    }
}
