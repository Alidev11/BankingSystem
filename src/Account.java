import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements AccountService {
    private int balance;
    private final List<Transaction> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(int amount) {
        validateAmount(amount);

        balance += amount;
        Transaction transaction = new Transaction(LocalDate.now(), amount, balance);
        transactions.add(transaction);
    }

    @Override
    public void withdraw(int amount) {
        validateAmount(amount);
        validateSufficientFunds(amount);

        balance -= amount;
        Transaction transaction = new Transaction(LocalDate.now(), -amount, balance);
        transactions.add(transaction);
    }

    @Override
    public void printStatement() {
        System.out.println("Date  ||  Amount || Balance");

        // Print transactions in reverse chronological order (most recent first)
        List<Transaction> reversedTransactions = new ArrayList<>(transactions);
        Collections.reverse(reversedTransactions);

        for (Transaction transaction : reversedTransactions) {
            System.out.println(transaction);
        }
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive. Provided: " + amount);
        }

        // Check for potential integer overflow
        if (amount > Integer.MAX_VALUE - balance) {
            throw new IllegalArgumentException("Transaction would cause balance overflow");
        }
    }

    private void validateSufficientFunds(int amount) {
        if (balance < amount) {
            throw new IllegalArgumentException(
                    String.format("Insufficient funds. Current balance: %d, Requested withdrawal: %d",
                            balance, amount));
        }
    }
}
