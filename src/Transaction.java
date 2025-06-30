import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final LocalDate date;
    private final int amount;
    private final int balanceAfterTransaction;

    public Transaction(LocalDate date, int amount, int balanceAfterTransaction) {
        this.date = date;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public String getFormattedDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public String toString() {
        return String.format("%s %15d %30d",
                getFormattedDate(), amount, balanceAfterTransaction);
    }
}
