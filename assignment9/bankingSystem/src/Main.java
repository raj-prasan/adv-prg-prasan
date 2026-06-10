import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");

        int type = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Owner Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        float balance = sc.nextFloat();

        Account account;

        if (type == 1) {
            System.out.print("Enter Interest Rate: ");
            float rate = sc.nextFloat();
            account = new SavingsAccount(accNo, name, balance, rate);

        } else {
            System.out.print("Enter Overdraft Limit: ");
            float limit = sc.nextFloat();
            account = new CurrentAccount(accNo, name, balance, limit);
        }

        // 🔁 Menu loop
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        float dep = sc.nextFloat();
                        account.deposit(dep);
                        break;

                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        float wd = sc.nextFloat();
                        account.withdraw(wd);
                        break;

                    case 3:
                        account.displayBalance();
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}