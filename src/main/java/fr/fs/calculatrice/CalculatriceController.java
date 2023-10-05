package fr.fs.calculatrice;

import fr.fs.calculatrice.metier.Calculatrice;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatriceController {
    Calculatrice calculate = new Calculatrice();
    @FXML
    private Label memoryLabel;
    @FXML
    private Label operatorLabel;
    @FXML
    private Label calculateLabel;

    @FXML
    protected void clearEvent(Event event) {
        memoryLabel.setText("");
        operatorLabel.setText("");
        calculateLabel.setText("");
        calculate.setTextResult("");
    }

    @FXML
    protected void clearErrorEvent(Event event) {
        memoryLabel.setText("");
        operatorLabel.setText("");
    }

    @FXML
    protected void numberEvent(Event event) {
        Button button = (Button) event.getSource();
        calculateLabel.setText(String.format("%s", calculate.Number(button)));
    }

    @FXML
    protected void memoryCalculateEvent(Event event) {
        Button button = (Button) event.getSource();
        try {
            if (memoryLabel.getText().isEmpty()) {
                System.out.println("VIDE");
                memoryLabel.setText(calculateLabel.getText());
                operatorLabel.setText(calculate.defineOperator(button));
                calculateLabel.setText("");
                calculate.setTextResult("");
            } else {
                long operande1 = Long.parseLong(memoryLabel.getText());
                long operande2 = Long.parseLong(calculateLabel.getText());
                switch (calculate.defineOperator(button)) {
                    case "+":
                        memoryLabel.setText(String.valueOf(operande1 + operande2));

                    case "-":
                        memoryLabel.setText(String.valueOf(operande1 - operande2));
                        break;
                    case "x":
                        memoryLabel.setText(String.valueOf(operande1 * operande2));
                        break;
                    case "/":
                        memoryLabel.setText(String.valueOf(operande1 / operande2));
                        break;
                }

                calculateLabel.setText("");
                calculate.setTextResult("");
                operatorLabel.setText(calculate.defineOperator(button));


            }
        } catch (Exception ignored) {

        }
    }

    @FXML
    protected void egaleEvent(Event event) {
        long operande1 = Long.parseLong(memoryLabel.getText());
        long operande2 = Long.parseLong(calculateLabel.getText());
        switch (operatorLabel.getText()) {
            case "+":
                memoryLabel.setText("");
                operatorLabel.setText("");
                calculateLabel.setText(String.valueOf(operande1 + operande2));
                break;
            case "-":
                memoryLabel.setText("");
                operatorLabel.setText("");
                calculateLabel.setText(String.valueOf(operande1 - operande2));
                break;
            case "x":
                memoryLabel.setText("");
                operatorLabel.setText("");
                calculateLabel.setText(String.valueOf(operande1 * operande2));
                break;
            case "/":
                memoryLabel.setText("");
                operatorLabel.setText("");
                calculateLabel.setText(String.valueOf(operande1 / operande2));
                break;
        }
    }
}