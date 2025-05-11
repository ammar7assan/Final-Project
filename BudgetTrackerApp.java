
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import src.lib.BudgetManager;
import src.lib.Expense;
import src.lib.Income;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class BudgetTrackerApp extends Application {

    private BudgetManager budgetManager = new BudgetManager();

    private TextField dateField;
    private TextField amountField;
    private TextField descriptionField;
    private TextField categoryOrSourceField;
    private TextField paymentOrFrequencyField;
    private ChoiceBox<String> transactionTypeChoice;
    private TextArea outputArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Personal Budget Tracker");

        // Transaction Type ChoiceBox
        transactionTypeChoice = new ChoiceBox<>();
        transactionTypeChoice.getItems().addAll("Income", "Expense");
        transactionTypeChoice.setValue("Income");

        // Input Fields
        dateField = new TextField();
        dateField.setPromptText("Date (YYYY-MM-DD)");
        
        amountField = new TextField();
        amountField.setPromptText("Amount");
        
        descriptionField = new TextField();
        descriptionField.setPromptText("Description");
        
        categoryOrSourceField = new TextField();
        categoryOrSourceField.setPromptText("Category or Source");
        
        paymentOrFrequencyField = new TextField();
        paymentOrFrequencyField.setPromptText("Payment Method or Frequency");

        // Buttons
        Button addButton = new Button("Add Transaction");
        Button reportButton = new Button("Generate Report");

        // Event Handlers
        addButton.setOnAction(e -> handleAddTransaction());
        reportButton.setOnAction(e -> handleGenerateReport());

        // Output Area
        outputArea = new TextArea();
        outputArea.setEditable(false);

        // Layouts
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.add(new Label("Transaction Type:"), 0, 0);
        grid.add(transactionTypeChoice, 1, 0);
        grid.add(new Label("Date:"), 0, 1);
        grid.add(dateField, 1, 1);
        grid.add(new Label("Amount:"), 0, 2);
        grid.add(amountField, 1, 2);
        grid.add(new Label("Description:"), 0, 3);
        grid.add(descriptionField, 1, 3);
        grid.add(new Label("Category/Source:"), 0, 4);
        grid.add(categoryOrSourceField, 1, 4);
        grid.add(new Label("Payment/Frequency:"), 0, 5);
        grid.add(paymentOrFrequencyField, 1, 5);
        grid.add(addButton, 0, 6);
        grid.add(reportButton, 1, 6);

        VBox vbox = new VBox(10, grid, outputArea);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleAddTransaction() {
        try {
            String date = dateField.getText();
            double amount = Double.parseDouble(amountField.getText());
            String description = descriptionField.getText();
            String categoryOrSource = categoryOrSourceField.getText();
            String paymentOrFrequency = paymentOrFrequencyField.getText();

            if (transactionTypeChoice.getValue().equals("Income")) {
                Income income = new Income(date, amount, description, categoryOrSource, paymentOrFrequency);
                budgetManager.addTransaction(income);
                outputArea.appendText("Income added successfully.\n");
            } else {
                Expense expense = new Expense(date, amount, description, categoryOrSource, paymentOrFrequency);
                budgetManager.addTransaction(expense);
                outputArea.appendText("Expense added successfully.\n");
            }

            clearFields();
        } catch (NumberFormatException ex) {
            outputArea.appendText("Invalid amount. Please enter a valid number.\n");
        } catch (IllegalArgumentException ex) {
            outputArea.appendText("Error: " + ex.getMessage() + "\n");
        }
    }

    private void handleGenerateReport() {
        String report = budgetManager.generateReport();
        outputArea.setText(report);
    }

    private void clearFields() {
        dateField.clear();
        amountField.clear();
        descriptionField.clear();
        categoryOrSourceField.clear();
        paymentOrFrequencyField.clear();
    }
}
