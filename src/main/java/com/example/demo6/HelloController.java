package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
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
    private Button HomeButton;

    @FXML
    private Button LoginButton;

    @FXML
    private Button SignUpButton;
    @FXML
    private MenuButton menuButton1;

    @FXML
    private MenuButton menuButton2;

    @FXML
    private MenuButton menuButton3;

    @FXML
    public void check(){
        if(t1.getText().equals("111")){
            login.setVisible(true);
            System.out.println("awdawda");
        }
    }
    @FXML
    public void CLOSEpainLOGIN(){
        login.setVisible(false);

        System.out.println("awdawda");
    }


}