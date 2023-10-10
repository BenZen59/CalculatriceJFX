package fr.fs.calculatrice;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatriceApplication extends Application {
    private ChangeListener<Number> widthChangeListener;
    private ChangeListener<Number> heightChangeListener;
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatriceApplication.class.getResource("calculatrice-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("calc.css").toExternalForm());
        stage.setTitle("Calculatrice");
        stage.setScene(scene);
        stage.setMinWidth(300);
        stage.setMinHeight(440);
        stage.setMaxWidth(900);
        stage.setMaxHeight(1000);
        stage.setWidth(380);
        stage.setHeight(450);
        stage.getIcons().add(new Image("file:src/main/resources/images/calculator.png"));
        widthChangeListener = (observable, oldValue, newValue) -> widthChange(newValue);
        heightChangeListener = (observable, oldValue, newValue) -> heightChangeListener(newValue);
        stage.widthProperty().addListener(widthChangeListener);
        stage.heightProperty().addListener(heightChangeListener);
        stage.show();
    }

    private void widthChange(Number newValue) {
        stage.heightProperty().removeListener(heightChangeListener);
        stage.setHeight(newValue.doubleValue() * 1.5);
        stage.heightProperty().addListener(heightChangeListener);
    }

    private void heightChangeListener(Number newValue) {
        stage.widthProperty().removeListener(widthChangeListener);
        stage.setWidth(newValue.doubleValue() / 1.5);
        stage.widthProperty().addListener(widthChangeListener);
    }


    public static void main(String[] args) {
        launch();
    }
}