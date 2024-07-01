import java.util.Scanner;

/*  @author
-------------------
     Nikki
*/ 

class BankDetails {
    private String accountNo;
    private String name;
    private String account_type;
    private long balance;
    Scanner sc = new Scanner(System.in);

    // Method to open a new account
    public void openAccount() {
        System.out.print("Enter Account No: ");
        accountNo = sc.next();
        System.out.print("Enter Account type: ");
        account_type = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }

    // Method to display account details
    public void showAccount() {
        System.out.println("Name of account holder: " + name);
        System.out.println("Account no.: " + accountNo);
        System.out.println("Account type: " + account_type);
        System.out.println("Balance: " + balance);
    }

    // Method to deposit money
    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance += amt;
    }

    // Method to withdraw money
    public void withdrawal() {
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance -= amt;
            System.out.println("Balance after withdrawal: " + balance);
        } else {
            System.out.println("Your balance is less than " + amt + "\tTransaction failed...!!");
        }
    }

    // Method to search an account by account number
    public boolean search(String account_number) {
        if (accountNo.equals(account_number)) {
            showAccount();
            return true;
        }
        return false;
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many customers do you want to input? ");
        int n = sc.nextInt();
        BankDetails[] customers = new BankDetails[n];

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new BankDetails();
            customers[i].openAccount();
        }

        int choice;
        do {
            System.out.println("\n*** Banking System Application ***");
            System.out.println("1. Display all account details");
            System.out.println("2. Search by Account number");
            System.out.println("3. Deposit the amount");
            System.out.println("4. Withdraw the amount");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (BankDetails customer : customers) {
                        customer.showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String account_number = sc.next();
                    boolean found = false;
                    for (BankDetails customer : customers) {
                        found = customer.search(account_number);
                        if (found) break;
                    }
                    if (!found) {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account no. to deposit: ");
                    account_number = sc.next();
                    for (BankDetails customer : customers) {
                        if (customer.search(account_number)) {
                            customer.deposit();
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter account no. to withdraw: ");
                    account_number = sc.next();
                    for (BankDetails customer : customers) {
                        if (customer.search(account_number)) {
                            customer.withdrawal();
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting the application. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
