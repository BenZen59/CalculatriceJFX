package fr.fs.calculatrice;

import fr.fs.calculatrice.metier.Calculatrice;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.math.BigDecimal;

public class CalculatriceController {
    Calculatrice calculate = new Calculatrice();
    private boolean isVirgule = false;
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
        calculateLabel.setText(String.format("%s", calculate.defineNumber(button)));
    }

    @FXML
    protected void virguleEvent(Event event) {
        if (!isVirgule && !calculateLabel.getText().isEmpty()) {
            isVirgule = true;
            Button button = (Button) event.getSource();
            calculateLabel.setText(String.format("%s", calculate.defineVirgule(button)));
        }
    }

    @FXML
    protected void memoryCalculateEvent(Event event) {
        isVirgule = false;
        Button button = (Button) event.getSource();
        try {
            if (memoryLabel.getText().isEmpty()) {
                memoryLabel.setText(calculateLabel.getText());
                operatorLabel.setText(calculate.defineOperator(button));
                calculateLabel.setText("");
                calculate.setTextResult("");
            } else {

                BigDecimal operande1 = new BigDecimal(memoryLabel.getText());
                BigDecimal operande2 = new BigDecimal(calculateLabel.getText());
                switch (calculate.defineOperator(button)) {
                    case "+":
                        memoryLabel.setText(String.valueOf(operande1.add(new BigDecimal(String.valueOf(operande2)))));
                        break;
                    case "-":
                        memoryLabel.setText(String.valueOf(operande1.subtract(new BigDecimal(String.valueOf(operande2)))));
                        break;
                    case "x":
                        memoryLabel.setText(String.valueOf(operande1.multiply(new BigDecimal(String.valueOf(operande2)))));
                        break;
                    case "/":
                        memoryLabel.setText(String.valueOf(operande1.divide(new BigDecimal(String.valueOf(operande2)))));
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
        isVirgule = false;
        try {

            BigDecimal operande1 = new BigDecimal(memoryLabel.getText());
            BigDecimal operande2 = new BigDecimal(calculateLabel.getText());
            switch (operatorLabel.getText()) {
                case "+":
                    memoryLabel.setText("");
                    operatorLabel.setText("");
                    calculateLabel.setText(String.valueOf(operande1.add(new BigDecimal(String.valueOf(operande2)))));
                    break;
                case "-":
                    memoryLabel.setText("");
                    operatorLabel.setText("");
                    calculateLabel.setText(String.valueOf(operande1.subtract(new BigDecimal(String.valueOf(operande2)))));
                    break;
                case "x":
                    memoryLabel.setText("");
                    operatorLabel.setText("");
                    calculateLabel.setText(String.valueOf(operande1.multiply(new BigDecimal(String.valueOf(operande2)))));
                    break;
                case "/":
                    memoryLabel.setText("");
                    operatorLabel.setText("");
                    calculateLabel.setText(String.valueOf(operande1.divide(new BigDecimal(String.valueOf(operande2)))));
                    break;
            }
        } catch (Exception ignored) {

        }

    }
}