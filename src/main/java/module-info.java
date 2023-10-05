module fr.fs.calculatrice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens fr.fs.calculatrice to javafx.fxml;
    exports fr.fs.calculatrice;
    exports fr.fs.calculatrice.metier;
    opens fr.fs.calculatrice.metier to javafx.fxml;
}