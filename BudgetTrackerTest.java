package src.lib;

public class BudgetTrackerTest {
    public static void main(String[] args) {
        BudgetManager manager = new BudgetManager();

        Income salary = new Income("2025-04-01", 3000.0, "Monthly Salary", "Employer Inc.", "Monthly");
        Expense rent = new Expense("2025-04-02", 1200.0, "April Rent", "Housing", "Bank Transfer");
        Expense groceries = new Expense("2025-04-05", 250.0, "Grocery shopping", "Food", "Credit Card");

        manager.addTransaction(salary);
        manager.addTransaction(rent);
        manager.addTransaction(groceries);

        System.out.println(manager.generateReport());
    }
}
