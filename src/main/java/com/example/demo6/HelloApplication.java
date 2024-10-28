package com.example.demo6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 760);
        
        stage.setScene(scene);
        stage.setTitle("Insurtech");
        stage.show();
        System.out.print("dwadawdawda");
    }

    public static void main(String[] args) {
        launch();
    }//ahmad
}//awdawdawdawdwaawadawdawdawdaacwdawdwadawdawdadsadawda