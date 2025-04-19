package org.example.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BookApp extends Application {
    @Override
    public void start(Stage primaryStage){
        MainView view = new MainView();
        Scene scene = new Scene(view.getRoot(), 900, 600);
        primaryStage.setTitle("Book Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
