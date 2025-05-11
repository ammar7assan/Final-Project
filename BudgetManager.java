package src.lib;
import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    private List<Transaction> transactions;

    public BudgetManager() {
        this.transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        if (t != null && t.isValid()) {
            transactions.add(t);
        }
    }

    public void removeTransaction(Transaction t) {
        transactions.remove(t);
    }

    public double getTotalIncome() {
        return transactions.stream()
            .filter(t -> t instanceof Income)
            .mapToDouble(Transaction::getAmount)
            .sum();
    }

    public double getTotalExpenses() {
        return transactions.stream()
            .filter(t -> t instanceof Expense)
            .mapToDouble(Transaction::getAmount)
            .sum();
    }

    public double getBalance() {
        return getTotalIncome() - getTotalExpenses();
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transactions Report:\n");
        for (Transaction t : transactions) {
            sb.append(t.toString()).append("\n");
        }
        sb.append("Total Income: ").append(getTotalIncome()).append("\n");
        sb.append("Total Expenses: ").append(getTotalExpenses()).append("\n");
        sb.append("Balance: ").append(getBalance()).append("\n");
        return sb.toString();
    }
}
