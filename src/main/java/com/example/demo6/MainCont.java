package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainCont {

    @FXML
    private MenuButton ACC_INV_Button;
    @FXML
    private Button HomeButton;

    @FXML
    private Button LoginButton;

    @FXML
    private MenuButton SUP_Button;

    @FXML
    private Button SignUpButton;

    @FXML
    private MenuButton VButton;

    @FXML
    private AnchorPane mainpage;

    @FXML
    private AnchorPane Homepage;


    @FXML
    public void Vehiclepage() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Vehicle.fxml"));
        mainpage.getChildren().setAll(root);
    }

    @FXML
    public void Mainpage() throws IOException {     ////////just for home button
        Parent root= FXMLLoader.load(getClass().getResource("Main.fxml"));
        Homepage.getChildren().setAll(root);

    }
    @FXML
    public void Propartypage() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Property.fxml"));
        mainpage.getChildren().setAll(root);
    }
    @FXML
    public void Healthpage() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Health.fxml"));
        mainpage.getChildren().setAll(root);
    }
    @FXML
    private Pane signinpanel;
    public void check() {
        signinpanel.setVisible(true);
    }
    @FXML
    private Button exitlogin;
    @FXML
    public void CLOSEpainLOGIN(){
        signinpanel.setVisible(false);
    }
    @FXML
    private Button confirmsignin;
    public void confirmpainLOGIN(){
        signinpanel.setVisible(false);
    }

    ////Ahmad is the booooooooooooooossssssssssssssss

}
