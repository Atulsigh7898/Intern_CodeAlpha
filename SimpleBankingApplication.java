import java.util.Scanner;

//Task-3

public class SimpleBankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0;

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    balance += depositAmount;
                    System.out.println("Deposit successful. Current balance: $" + balance);
                    break;

                case 2:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    
                    if (withdrawalAmount > balance) {
                        System.out.println("Insufficient funds. Withdrawal failed.");
                    } else {
                        balance -= withdrawalAmount;
                        System.out.println("Withdrawal successful. Current balance: $" + balance);
                    }
                    break;

                case 3:
                    System.out.println("Current balance: $" + balance);
                    break;

                case 4:
                    System.out.println("Exiting the program. Thank you!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
