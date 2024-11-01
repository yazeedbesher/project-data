package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    public void confirmpainLOGIN()throws IOException {
        String text = SSNLogIn.getText();
        if (text.startsWith("9")) {
            signinpanel.setVisible(false);

            LoginButton.setVisible(false);
            SignUpButton.setVisible(false);

            Parent root= FXMLLoader.load(getClass().getResource("manager.fxml"));
            mainpage.getChildren().setAll(root);
        }
        if (text.startsWith("7")) {
            signinpanel.setVisible(false);

            LoginButton.setVisible(false);
            SignUpButton.setVisible(false);

            Parent root= FXMLLoader.load(getClass().getResource("RequistEMP.fxml"));
            mainpage.getChildren().setAll(root);
        }
        if (text.startsWith("8")) {
            signinpanel.setVisible(false);

            LoginButton.setVisible(false);
            SignUpButton.setVisible(false);

            Parent root= FXMLLoader.load(getClass().getResource("complaintEMP.fxml"));
            mainpage.getChildren().setAll(root);
        }
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


    /*_______________________
       comunication
    __________________________ */

    @FXML
    int recordid1=0;
    @FXML
    String SUPPORT_Type;
    @FXML
    String status ;
    //for date
    @FXML
    LocalDateTime currentDateTime;
    @FXML
    DateTimeFormatter formatter ;
    @FXML
    String current_datetime;
    @FXML
    String res_req;
    @FXML
    int ManagerNO=5;
//    ____________________________
//            Complaints pane
//    ____________________________
    @FXML
    public Pane Complaints_pane;
    @FXML
    public Button sup_comp_button;
    @FXML
    public TextField sup_comp_title;
    @FXML
    public TextArea sup_comp_textarea;
    @FXML
    public TextField sup_comp_name;
    @FXML
    public TextField sup_comp_SSN;
    @FXML
    public TextField sup_comp_email;

    @FXML
    String compSSN;

    public void Comppage(){
        Complaints_pane.setVisible(true);
    }

    @FXML
    public void sup_comp_click(){
    String comp_title,comp_disc;

        //بنستخدمهم عشان نبعتهم لداتاونربط ال
        comp_title = sup_comp_title.getText();
        comp_disc = sup_comp_textarea.getText();
        compSSN=sup_comp_SSN.getText();

        recordid1++;
        SUPPORT_Type ="Complaints";
        status ="Pending";
        //date and time
        currentDateTime = LocalDateTime.now();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        current_datetime = currentDateTime.format(formatter);//date and time is in current_datetime
        ManagerNO=5;
        res_req ="No";


        sup_comp_textarea.clear();
        sup_comp_title.clear();
        sup_comp_name.clear();
        sup_comp_email.clear();
        sup_comp_SSN.clear();

        Complaints_pane.setVisible(false);
    }
    public void sup_comp_close(){
        sup_comp_textarea.clear();
        sup_comp_title.clear();
        sup_comp_name.clear();
        sup_comp_email.clear();
        sup_comp_SSN.clear();
        Complaints_pane.setVisible(false);
    }
    //    ____________________________
    //            offers pane
    //    ____________________________
    @FXML
    public Pane sup_offers_pane;

    public void Sup_Offer_click(){
        sup_offers_pane.setVisible(true);
    }
    public void sup_offers_close(){

        sup_offers_pane.setVisible(false);
    }
    @FXML
    public Pane sup_investment_pane;
    @FXML
    public void Sup_invest_click(){
        sup_investment_pane.setVisible(true);
    }
    public void sup_invest_close(){

        sup_investment_pane.setVisible(false);
    }



    public void opencarinv() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("V_invest_Employee.fxml"));
        mainpage.getChildren().setAll(root);
    }

    public void openpropartyemp() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Property_Employee.fxml"));
        mainpage.getChildren().setAll(root);
    }
    public void openHemp() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("H_care_Employee.fxml"));
        mainpage.getChildren().setAll(root);
    }
    @FXML
    private Pane reqpane;
 public void req(){
     reqpane.setVisible(true);

 }
    @FXML
    private Pane carpane;
    public void carreq(){
        healthpane.setVisible(false);
        carpane.setVisible(true);
        proppane.setVisible(false);
    }
    @FXML
    private Pane healthpane;
    public void healthreq(){
        carpane.setVisible(false);
        healthpane.setVisible(true);
        proppane.setVisible(false);
    }
    @FXML
    private Pane proppane;
    public void propreq(){
        carpane.setVisible(false);
        healthpane.setVisible(false);
        proppane.setVisible(true);
    }
    @FXML
    private Button closedep;
    @FXML
    private Button senddep;
    public void closepropreq(){
        reqpane.setVisible(false);
    }
}
