package WIA2004.Lab_6;

import java.util.Scanner;

public class Lab_6 {
    // Number of customers
    static int totalCustomers = 3;

    // Same maximum loan limit for all customers
    static int maxLoanLimit = 100000;

    // Current borrowed amount by customers
    static int[][] borrowedAmount = {
            { 20000 },
            { 30000 },
            { 15000 }
    };

    // Maximum loan each customer can borrow
    static int[][] maxLoan = new int[totalCustomers][1];

    // Remaining credit customer can still borrow
    static int[][] remainingCredit = new int[totalCustomers][1];

    // Total bank capital
    static int bankCapital = 500000;

    // Available money in bank
    static int availableFunds;

    // Initialize bank data
    static void initializeBank() {
        availableFunds = bankCapital;

        for (int i = 0; i < totalCustomers; i++) {
            maxLoan[i][0] = maxLoanLimit;
            availableFunds -= borrowedAmount[i][0];
            remainingCredit[i][0] = maxLoan[i][0] - borrowedAmount[i][0];
        }
    }

    // Display current bank/customer status
    static void printState() {
        System.out.println("\n📊 Current Bank State:");

        for (int i = 0; i < totalCustomers; i++) {
            System.out.println(
                    "Customer " + i +
                            " | Max Loan: " + maxLoan[i][0] +
                            " | Borrowed: " + borrowedAmount[i][0] +
                            " | Remaining Credit: " + remainingCredit[i][0]);
        }

        System.out.println("Available Bank Funds: " + availableFunds);
    }

    // Banker's Algorithm Safety Check
    static boolean isSafeState() {
        int temporaryFunds = availableFunds;
        boolean[] completed = new boolean[totalCustomers];
        int completedCount = 0;

        while (completedCount < totalCustomers) {
            boolean found = false;
            for (int i = 0; i < totalCustomers; i++) {
                if (!completed[i] && remainingCredit[i][0] <= temporaryFunds) {
                    temporaryFunds += borrowedAmount[i][0];
                    completed[i] = true;
                    found = true;
                    completedCount++;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }

    // Customer loan request
    static void requestLoan(int customerId, int requestAmount) {

        System.out.println("\nCustomer " + customerId + " requests: " + requestAmount);
        // Check over borrowing
        if (requestAmount > remainingCredit[customerId][0]) {
            System.out.println("⚠ WARNING: Over borrowing limit!");
            System.out.println("Maximum allowed remaining: " + remainingCredit[customerId][0]);

            printState();
            return;
        }

        // Check bank funds
        if (requestAmount > availableFunds) {
            System.out.println("⚠ WARNING: Insufficient bank funds!");

            printState();
            return;
        }

        // Temporary allocation
        availableFunds -= requestAmount;
        borrowedAmount[customerId][0] += requestAmount;
        remainingCredit[customerId][0] -= requestAmount;

        // Safety check
        if (isSafeState()) {

            System.out.println("✅ Loan approved for Customer " + customerId);

        } else {
            // Rollback
            availableFunds += requestAmount;
            borrowedAmount[customerId][0] -= requestAmount;
            remainingCredit[customerId][0] += requestAmount;

            System.out.println("⚠ WARNING: Unsafe state detected!");
            System.out.println("Request rejected to prevent deadlock.");
        }

        printState();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBank();

        System.out.println("🏦 Bank Capital: " + bankCapital);

        System.out.println("Maximum Loan Limit Per Customer: " + maxLoanLimit);

        printState();

        while (true) {
            System.out.print("\nEnter customer ID (0-2) or -1 to exit: ");

            int customerId = scanner.nextInt();
            if (customerId == -1) {
                break;
            }

            System.out.print("Enter loan request amount: ");

            int requestAmount = scanner.nextInt();
            requestLoan(customerId, requestAmount);
        }

        scanner.close();
    }
}