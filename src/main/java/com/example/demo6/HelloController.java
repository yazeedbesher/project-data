package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.text.html.ImageView;

public class HelloController {
    @FXML
    private TextField t1;

    @FXML
    private ImageView IMAGE;
    @FXML
    private AnchorPane sccrolpane;
    @FXML
    private Pane login;

    @FXML
    public void check(){
        if(t1.getText().equals("111")){
            login.setVisible(true);
            System.out.println("awdawda");
        }
    }
    public void CLOSEpainLOGIN(){
        login.setVisible(false);

        System.out.println("awdawda");
    }


}