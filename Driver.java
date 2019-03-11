//  John Gumm
//  CIS 279
//  JavaFX Basics

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class Driver extends Application {

    // Create textfields here so they are globally used
    private TextField salaryAndWagesText = new TextField("0");
    private TextField interestIncomeText = new TextField("0");
    private TextField investmentIncomeText = new TextField("0");
    private TextField otherIncomeText = new TextField("0");
    private TextField annualInterestRateText = new TextField("0");
    private TextField termInYearsText = new TextField("0");
    private TextField loanAmountText = new TextField("0");

    private TextField totalIncomeText = new TextField();
    private TextField monthlyPaymentText = new TextField();
    private TextField totalPaymentsOverLifeOfLoanText = new TextField();
    private TextField eligibilityText = new TextField();

    final static double eligibilityPercentage = .25;

    @Override
    public void start(Stage primaryStage) {
        
        // Set grid pane dimensions
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Set output fields as uneditable
        totalIncomeText.setDisable(true);
        totalIncomeText.setStyle("-fx-opacity: 1;");

        monthlyPaymentText.setDisable(true);
        monthlyPaymentText.setStyle("-fx-opacity: 1;");

        totalPaymentsOverLifeOfLoanText.setDisable(true);
        totalPaymentsOverLifeOfLoanText.setStyle("-fx-opacity: 1;");

        eligibilityText.setDisable(true);
        eligibilityText.setStyle("-fx-opacity: 1;");

        // Add labels and text fields to grid pane
        grid.add(new Label("Salary and wages"), 0, 0);
        grid.add(salaryAndWagesText, 1, 0);

        grid.add(new Label("Interest Income"), 0, 1);
        grid.add(interestIncomeText, 1, 1);

        grid.add(new Label("Investment Income"), 0, 2);
        grid.add(investmentIncomeText, 1, 2);

        grid.add(new Label("Other Income"), 0, 3);
        grid.add(otherIncomeText, 1, 3);

        grid.add(new Label("Annual interest rate (n.nnn%)"), 2, 0);
        grid.add(annualInterestRateText, 3, 0);

        grid.add(new Label("Term in years"), 2, 1);
        grid.add(termInYearsText, 3, 1);

        grid.add(new Label("Loan amount"), 2, 2);
        grid.add(loanAmountText, 3, 2);

        // Output text fields
        grid.add(new Label("Monthly payment"), 0, 5);
        grid.add(monthlyPaymentText, 1, 5);

        grid.add(new Label("Total payments over life of loan"), 2, 5);
        grid.add(totalPaymentsOverLifeOfLoanText, 3, 5);

        grid.add(new Label("Total Income"), 0, 6);
        grid.add(totalIncomeText, 1, 6);

        grid.add(new Label("Loan Eligibility"), 2, 6);
        grid.add(eligibilityText, 3, 6);

        // Calc payment button (lambda)
        Button calcPayment = new Button("Calc Payment");
        calcPayment.setOnAction(e -> {
            calcLoanPayment();
            System.out.println("Calc Payment button clicked");
        });
        grid.add(calcPayment, 0, 4);

        // Cancel button (Object event handling)
        Button cancel = new Button("Cancel");
        grid.add(cancel, 1, 4);
        class CancelHandlerClass implements EventHandler<ActionEvent> {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Cancel button clicked");
                primaryStage.close();
            }
        }
        CancelHandlerClass cancelHandler = new CancelHandlerClass();
        cancel.setOnAction(cancelHandler);
        
        // Set the scene
        Scene scene = new Scene(grid);
        primaryStage.setTitle("Loan Payment and Eligibility Form"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    // Calc loan payment (boolean returns true if all fields are validated)
    private void calcLoanPayment() {

        // Get values from text fields
        double salaryAndWages = Double.parseDouble(salaryAndWagesText.getText());
        double interestIncome = Double.parseDouble(interestIncomeText.getText());
        double investmentIncome = Double.parseDouble(investmentIncomeText.getText());
        double otherIncome = Double.parseDouble(otherIncomeText.getText());
        double annualInterestRate = Double.parseDouble(annualInterestRateText.getText());
        int termInYears = Integer.parseInt(termInYearsText.getText());
        double loanAmount = Double.parseDouble(loanAmountText.getText());

        // Create loan object using text field data
        Loan newLoan = new Loan(salaryAndWages, interestIncome, investmentIncome, otherIncome, annualInterestRate, termInYears, loanAmount);
        
        // Calculate total income
        double totalIncome = newLoan.calcTotalIncome();

        // Calculate term in months
        int termInMonths = newLoan.calcTotalPaymentsOverLifeOfLoan();

        // Calc monthly payment
        double monthlyPayment = newLoan.calculateMonthlyPayment();

        // Calc eligibility
        boolean eligible = newLoan.isEligible(eligibilityPercentage);

        // Display results in text field
        totalIncomeText.setText(String.format("$%.2f", totalIncome));
        totalPaymentsOverLifeOfLoanText.setText(Integer.toString(termInMonths));
        monthlyPaymentText.setText(String.format("$%.2f", monthlyPayment));

        if (eligible) {
            eligibilityText.setText("Eligible for loan.");
        }
        else {
            eligibilityText.setText("Not eligible for loan.");
        }
}

    public static void main(String[] args) {
        launch(args);
    }
}