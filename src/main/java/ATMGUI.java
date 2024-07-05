/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid amount");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Invalid amount or insufficient funds");
            return false;
        }
    }
}

class ConsoleATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ConsoleATM(BankAccount userAccount) {
        this.userAccount = userAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void handleUserInput() {
        int choice;
        do {
            displayOptions();
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (userAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                    }
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
                    break;
                case 3:
                    System.out.println("Current balance: $" + userAccount.getBalance());
                    break;
                case 4:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
    }
}

class ATMGUI {
    private BankAccount account;
    private JFrame frame;
    private JTextField amountField;
    private JTextArea messageArea;
    private JLabel balanceLabel;
    private DecimalFormat indianCurrencyFormat;

    public ATMGUI(BankAccount account) {
        this.account = account;
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setCurrencySymbol("₹");
        indianCurrencyFormat = new DecimalFormat("₹ ##,##,###.##", symbols);
        createUI();
    }

    private void createUI() {
        frame = new JFrame("ATM Machine");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Welcome to ATM");
        titleLabel.setBounds(150, 10, 150, 20);
        frame.add(titleLabel);

        balanceLabel = new JLabel("Balance: " + indianCurrencyFormat.format(account.getBalance()));
        balanceLabel.setBounds(50, 40, 250, 20);
        frame.add(balanceLabel);

        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(50, 70, 100, 20);
        frame.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 70, 150, 20);
        frame.add(amountField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 100, 100, 30);
        frame.add(withdrawButton);
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    if (account.withdraw(amount)) {
                        updateBalanceLabel();
                        showMessage("Withdrawn: " + indianCurrencyFormat.format(amount));
                    } else {
                        showMessage("Invalid amount or insufficient funds");
                    }
                } catch (NumberFormatException ex) {
                    showMessage("Invalid amount format");
                }
            }
        });

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(200, 100, 100, 30);
        frame.add(depositButton);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    account.deposit(amount);
                    updateBalanceLabel();
                    showMessage("Deposited: " + indianCurrencyFormat.format(amount));
                } catch (NumberFormatException ex) {
                    showMessage("Invalid amount format");
                }
            }
        });

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(100, 150, 150, 30);
        frame.add(checkBalanceButton);
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessage("Current Balance: " + indianCurrencyFormat.format(account.getBalance()));
            }
        });

        messageArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.setBounds(50, 190, 300, 60);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: " + indianCurrencyFormat.format(account.getBalance()));
    }

    private void showMessage(String message) {
        messageArea.append(message + "\n");
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000.0);
        
        // Uncomment one of the following to test either the console or GUI version

        // Console version
        // ConsoleATM consoleATM = new ConsoleATM(bankAccount);
        // consoleATM.handleUserInput();
        
        // GUI version
        ATMGUI atmGUI = new ATMGUI(bankAccount);
    }
}

