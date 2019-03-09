import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.geometry.HPos;
import javafx.geometry.Insets;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//  John Gumm
//  CIS 279
//  JavaFX Basics

public class Driver extends Application {
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.add(new Label("Salary and wages"), 0, 0);
        grid.add(new TextField(), 1, 0);

        grid.add(new Label("Interest Income"), 0, 1);
        grid.add(new TextField(), 1, 1);

        grid.add(new Label("Investment Income"), 0, 2);
        grid.add(new TextField(), 1, 2);

        grid.add(new Label("Other Income"), 0, 3);
        grid.add(new TextField(), 1, 3);

        grid.add(new Label("Total Income"), 0, 4);
        grid.add(new TextField(), 1, 4);

        grid.add(new Label("Annual interest rate (n.nnn%)"), 2, 0);
        grid.add(new TextField(), 3, 0);

        grid.add(new Label("Term in years"), 2, 1);
        grid.add(new TextField(), 3, 1);

        grid.add(new Label("Loan amount"), 2, 2);
        grid.add(new TextField(), 3, 2);

        grid.add(new Label("Monthly payment"), 2, 3);
        grid.add(new TextField(), 3, 3);

        grid.add(new Label("Total payments over life of loan"), 2, 4);
        grid.add(new TextField(), 3, 4);

        grid.add(new Button("Calc Payment"), 0, 5);
        grid.add(new Button("Cancel"), 1, 5);


        
        Scene scene = new Scene(grid);
        primaryStage.setTitle("Loan Payment and Eligibility Form"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    public static void main(String[] args) {
        launch(args);
    }
}