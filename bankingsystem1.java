import java.util.HashMap;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String customerName;
    private double balance;

    public BankAccount(String accountNumber, String customerName) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
}

class BankingSystem {
    private HashMap<String, BankAccount> accounts;

    public BankingSystem() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String customerName) {
        if (!accounts.containsKey(accountNumber)) {
            BankAccount newAccount = new BankAccount(accountNumber, customerName);
            accounts.put(accountNumber, newAccount);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account with this number already exists.");
        }
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean accountExists(String accountNumber) {
        return accounts.containsKey(accountNumber);
    }
}

public class bankingsystem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingSystem bankingSystem = new BankingSystem();

        while (true) {
            System.out.println("1. Create Account\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            if (option == 1) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.next();
                System.out.print("Enter customer name: ");
                String customerName = scanner.next();
                bankingSystem.createAccount(accountNumber, customerName);

            } else if (option == 2) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.next();
                if (bankingSystem.accountExists(accountNumber)) {
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    bankingSystem.getAccount(accountNumber).deposit(amount);
                } else {
                    System.out.println("Account does not exist.");
                }

            } else if (option == 3) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.next();
                if (bankingSystem.accountExists(accountNumber)) {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = scanner.nextDouble();
                    bankingSystem.getAccount(accountNumber).withdraw(amount);
                } else {
                    System.out.println("Account does not exist.");
                }

            } else if (option == 4) {
                System.out.print("Enter account number: ");
                String accountNumber = scanner.next();
                if (bankingSystem.accountExists(accountNumber)) {
                    bankingSystem.getAccount(accountNumber).checkBalance();
                } else {
                    System.out.println("Account does not exist.");
                }

            } else if (option == 5) {
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
