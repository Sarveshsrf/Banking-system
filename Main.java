import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== 🏦 Online Banking System ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer Funds");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    bank.createAccount(accNo, name, balance);
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double depositAmt = sc.nextDouble();
                    bank.deposit(accNo, depositAmt);
                    break;

                case 3:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double withdrawAmt = sc.nextDouble();
                    bank.withdraw(accNo, withdrawAmt);
                    break;

                case 4:
                    System.out.print("Enter Account No: ");
                    accNo = sc.nextLine();
                    bank.checkBalance(accNo);
                    break;

                case 5:
                    System.out.print("Enter Sender Account No: ");
                    String fromAcc = sc.nextLine();
                    System.out.print("Enter Receiver Account No: ");
                    String toAcc = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    bank.transfer(fromAcc, toAcc, amount);
                    break;

                case 6:
                    System.out.println("👋 Thank you for using Online Banking System!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
