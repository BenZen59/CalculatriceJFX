package fr.fs.calculatrice.metier;

import javafx.scene.control.Button;

public class Calculatrice {
    private Operande operande1 = new Operande("0");
    private Operande operande2 = new Operande("");
    private String textResult = "";

    public Calculatrice() {
    }

    public void setTextResult(String textResult) {
        this.textResult = textResult;
    }

    public String Number(Button button) { //permet d'afficher les nombres quand on les tape sur le clavier de la calculette
        String number = button.getText();
        textResult = textResult + number;
        return textResult;
    }

    public String defineOperator(Button button) { //Permet de définir l'opérateur choisi pour le calcul
        String operator = button.getText();
        switch (operator) {
            case "+":
                return "+";
            case "-":
                return "-";
            case "x":
                return "x";
            case "/":
                return "/";
        }
        return operator;
    }
}



