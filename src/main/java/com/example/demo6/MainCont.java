package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
    private PasswordField passlogin;
    @FXML
    private TextArea SSNLogIn;
    @FXML
    private Button exitlogin;
    @FXML
    private Button confirmsignin;
    @FXML
    public void CLOSEpainLOGIN(){
        signinpanel.setVisible(false);
        SSNLogIn.setText("");
        passlogin.setText("");
    }
    public void confirmpainLOGIN() {

    }



    @FXML
    private Pane signuppane;

    @FXML
    private Button exitsignup;
    @FXML
    private Button confirmsignup;
    @FXML
    private TextArea AdressSignUp;

    @FXML
    private TextArea AgeSignUp;

    @FXML
    private DatePicker BDateSignUp;

    @FXML
    private PasswordField ConfirmPassSignUp;

    @FXML
    private TextArea EmailSignUp;

    @FXML
    private TextArea FnameSignUp;
    @FXML
    private TextArea LnameSignUp;
    @FXML
    private TextArea MNameSignUp;

    @FXML
    private PasswordField PasswordSignUp;

    @FXML
    private TextArea PhoneSignUp;
    @FXML
    private TextArea ssnSignup;


    public void checksignup() {
        signuppane.setVisible(true);
    }
    @FXML
    public void CLOSEpainSIGNUP(){
        signuppane.setVisible(false);

        PasswordSignUp.setText("");
       ssnSignup.setText("");
       PhoneSignUp.setText("");
       AdressSignUp.setText("");
       EmailSignUp.setText("");
       AgeSignUp.setText("");
       ConfirmPassSignUp.setText("");
       FnameSignUp.setText("");
       LnameSignUp.setText("");
       MNameSignUp.setText("");
        BDateSignUp.setValue(null);
    }
    public void confirmpainSIGNUP(){
        signuppane.setVisible(false);

        PasswordSignUp.setText("");
        ssnSignup.setText("");
        PhoneSignUp.setText("");
        AdressSignUp.setText("");
        EmailSignUp.setText("");
        AgeSignUp.setText("");
        ConfirmPassSignUp.setText("");
        FnameSignUp.setText("");
        LnameSignUp.setText("");
        MNameSignUp.setText("");
        BDateSignUp.setValue(null);
    }


}
