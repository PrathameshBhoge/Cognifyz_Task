package Cognifyz_tasks.Level_3.Task_3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField display;

    private String operand = "";
    private String operator = "";
    private boolean start = true;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setHgap(10);
        grid.setVgap(10);

        display = new TextField();
        display.setEditable(false);
        display.setPrefWidth(200);
        grid.add(display, 0, 0, 4, 1);

        String[][] buttons = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "=", "+"}
        };

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                final Button button = new Button(buttons[i][j]);
                button.setPrefWidth(50);
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        buttonClicked(button.getText());
                    }
                });
                grid.add(button, j, i + 1);
            }
        }

        Scene scene = new Scene(grid, 240, 240);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void buttonClicked(String text) {
        if (text.matches("[0-9\\.]")) {
            if (start) {
                display.setText("");
                start = false;
            }
            display.appendText(text);
        } else if (text.equals("=")) {
            if (!operator.isEmpty()) {
                double secondOperand = Double.parseDouble(display.getText());
                double result = calculate(Double.parseDouble(operand), secondOperand, operator);
                display.setText(String.valueOf(result));
                operand = "";
                operator = "";
                start = true;
            }
        } else {
            if (!operand.isEmpty()) {
                double secondOperand = Double.parseDouble(display.getText());
                double result = calculate(Double.parseDouble(operand), secondOperand, operator);
                display.setText(String.valueOf(result));
                operand = String.valueOf(result);
            } else {
                operand = display.getText();
            }
            operator = text;
            start = true;
        }
    }

    private double calculate(double firstOperand, double secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand == 0) {
                    return Double.NaN; // Indicate division by zero
                }
                return firstOperand / secondOperand;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
