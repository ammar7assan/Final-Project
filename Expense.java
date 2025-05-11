package src.lib;
public class Expense extends Transaction {
    private String category;
    private String paymentMethod;

    public Expense(String date, double amount, String description, String category, String paymentMethod) {
        super(date, amount, description);
        this.category = category;
        this.paymentMethod = paymentMethod;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean isValid() {
        return getAmount() > 0 && category != null && !category.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString() + ", Category: " + category + ", Payment Method: " + paymentMethod;
    }
}
