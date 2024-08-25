import java.awt.*;
import java.awt.event.*;
public class Calculator extends Frame implements ActionListener {
    // Declare components
    TextField display;
    Button[] numButtons = new Button[10];
    Button[] opButtons = new Button[4];
    Button addButton, subButton, mulButton, divButton, eqButton, clrButton;
    Panel panel;

    // Variables to hold the operands and the result
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor to set up the GUI
    public Calculator() {
        // Set frame properties
        setTitle("Calculator");
        setSize(400, 500);
        setLayout(new BorderLayout());

        // Create the display field
        display = new TextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // Create panel for buttons
        panel = new Panel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Initialize number buttons
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new Button(String.valueOf(i));
            numButtons[i].setFont(new Font("Arial", Font.BOLD, 24));
            numButtons[i].addActionListener(this);
            panel.add(numButtons[i]);
        }

        // Initialize operator buttons
        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("*");
        divButton = new Button("/");
        eqButton = new Button("=");
        clrButton = new Button("C");

        // Add operators to the panel
        opButtons[0] = addButton;
        opButtons[1] = subButton;
        opButtons[2] = mulButton;
        opButtons[3] = divButton;

        for (int i = 0; i < 4; i++) {
            opButtons[i].setFont(new Font("Arial", Font.BOLD, 24));
            opButtons[i].addActionListener(this);
            panel.add(opButtons[i]);
        }

        // Add the equal and clear buttons
        eqButton.setFont(new Font("Arial", Font.BOLD, 24));
        clrButton.setFont(new Font("Arial", Font.BOLD, 24));
        eqButton.addActionListener(this);
        clrButton.addActionListener(this);
        panel.add(eqButton);
        panel.add(clrButton);

        // Add the panel to the frame
        add(panel, BorderLayout.CENTER);

        // Set the frame visible
        setVisible(true);

        // Add window listener to close the application
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            // If a number is pressed, append it to the display
            display.setText(display.getText() + command);
        } else if (command.charAt(0) == 'C') {
            // Clear the display
            display.setText("");
            num1 = num2 = result = 0;
        } else if (command.charAt(0) == '=') {
            // Perform the operation
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        } else {
            // An operator is pressed
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                display.setText("");
            }
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new Calculator();
    }
}
