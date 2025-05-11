package src.lib;
public abstract class Transaction {
    private String date;
    private double amount;
    private String description;

    public Transaction(String date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract boolean isValid();

    @Override
    public String toString() {
        return "Date: " + date + ", Amount: " + amount + ", Description: " + description;
    }
}
