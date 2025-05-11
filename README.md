# Budget Tracker - Final Project

## Overview
This is a personal budget tracking application built using Java and JavaFX. It allows users to add income and expense transactions, view summaries, and maintain a running balance.

## Features
- JavaFX GUI with interactive input fields
- Tracks both Income and Expense transactions
- Generates a financial report (Total Income, Expenses, Balance)
- Validates input and handles errors

## How to Run
1. Ensure JavaFX is installed (JavaFX SDK 24+)
2. Compile the project:
```
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -d src BudgetTrackerApp.java src/lib/*.java
```
3. Run the application:
```
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -cp src BudgetTrackerApp
```

## Repository Contents
- `BudgetTrackerApp.java` – Main app entry
- `lib/` – All supporting model and manager classes
- `FinalProject_Documentation.docx` – UML + Screenshot documentation

## Author
Ammar Hassan
