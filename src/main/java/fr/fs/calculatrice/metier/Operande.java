package fr.fs.calculatrice.metier;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Operande {
    int precision = 60;
    private BigDecimal bigDecimal = new BigDecimal(precision);
    private NumberFormat numberFormat = NumberFormat.getInstance(Locale.FRENCH);
    private String string;
    private String initialString;

    public Operande(String string) {
        initialString = string;
        numberFormat.setMaximumFractionDigits(precision / 2);
    }

    public void add(){

    }
}
