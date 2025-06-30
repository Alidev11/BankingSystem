import java.time.LocalDate;

public class BankingServiceDemo {
    public static void main(String[] args) {
        System.out.println("=== Banking Service Demo ===\n");

        // Create account
        Account account = new Account();

        try {
            // Execute the exact test case from requirements
            System.out.println("Executing test case operations:");

            // Deposit 1000 on 10-01-2012
            account.deposit(1000);
            System.out.println("✓ Deposited 1000 on " + LocalDate.now());

            // Deposit 2000 on 13-01-2012
            account.deposit(2000);
            System.out.println("✓ Deposited 2000 on  " + LocalDate.now());

            // Withdraw 500 on 14-01-2012
            account.withdraw(500);
            System.out.println("✓ Withdrew 500 on  " + LocalDate.now());

            System.out.println("\n=== BANK STATEMENT ===");
            account.printStatement();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
