package edu.utsa.cs3443.qxj545_lab4.model;

import edu.utsa.cs3443.qxj545_lab4.LoginScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

    public class AidShipApplication extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            // Using the specific resource path structure from your first function
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/utsa/cs3443/qxj545_lab4/layouts/login-screen.fxml"));

            // Loading the scene with the dimensions from your second function
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);

            // Grabbing the controller to pass the stage reference
            LoginScreenController loginScreenController = fxmlLoader.getController();
            loginScreenController.setStage(stage);

            stage.setTitle("Aid Ship Management System");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            // This launches the JavaFX lifecycle
            launch(args);
        }
    }

