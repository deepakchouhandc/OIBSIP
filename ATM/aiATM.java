package ATM;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class aiATM {
    private static final String CORRECT_PIN = "1234";
    private static final String CORRECT_PASSWORD = "password";
    private static double balance = 1000.0; // Initial balance
    private static List<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (enteredPin.equals(CORRECT_PIN)) {
            System.out.print("Enter your password: ");
            String enteredPassword = scanner.nextLine();

            if (enteredPassword.equals(CORRECT_PASSWORD)) {
                showMenu(scanner);
            } else {
                System.out.println("Incorrect password. Exiting.");
            }
        } else {
            System.out.println("Incorrect PIN. Exiting.");
        }
    }

    private static void showMenu(Scanner scanner) {
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    miniStatement();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    saveTransactionHistory();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
            recordTransaction("Withdrawal", amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.println("Amount deposited: " + amount);
        recordTransaction("Deposit", amount);
    }

    private static void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }

    private static void miniStatement() {
        System.out.println("Mini Statement:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    private static void recordTransaction(String type, double amount) {
        String transaction = "Transaction - " + type + " - Amount: " + amount + " - Balance: " + balance;
        transactionHistory.add(transaction);
    }

    private static void saveTransactionHistory() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("D:\\text file\\Java Data"))) {
            for (String transaction : transactionHistory) {
                writer.println(transaction);
            }
        } catch (IOException e) {
            System.out.println("Error saving transaction history.");
        }
    }
}
