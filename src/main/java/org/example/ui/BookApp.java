package org.example.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Here is the entry point of the BookAPP class
// It is a Java FX application
// It sets the main application using a JavaFX window
// You must override the start(Stage primaryStage) method, which is the main point where the UI gets built.
public class BookApp extends Application {

    //It is called when the application is launched
    //Sets up the load view

    @Override
    public void start(Stage primaryStage){
        // Starts te primary window of the application
        MainView view = new MainView();
        //Initiates the custom UI components
        // My view would be 900 pixels width and 600 height
        Scene scene = new Scene(view.getRoot(), 900, 600);
        //Set the title
        primaryStage.setTitle("Book Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Launches the JavaFX application.
    // This method is required to kick things off when running from a standard Java main() method.
    public static void main(String[] args) {
        launch(args);
    }
}
