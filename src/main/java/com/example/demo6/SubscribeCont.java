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


public class SubscribeCont {



    @FXML
    private MenuButton Vtype;
    @FXML
    private MenuItem cartype;

    @FXML
    private MenuItem suvtype;

    @FXML
    private MenuItem trucktype;
    @FXML
    private TextField pricetype;
    @FXML
    private MenuButton intype;


    public void typeCAR(){
    Vtype.setText("CAR");
        pricetype.setEditable(false);
    }
    public void typeTRUCK(){
        Vtype.setText("TRUCK");
        pricetype.setEditable(false);
    }
    public void typeSUV(){
        Vtype.setText("SUV");
        pricetype.setEditable(false);
    }
    public void typemonths(){
        intype.setText("6 months");
        if(Vtype.getText().equals("CAR")){
            pricetype.setText("            300 $      ");
        }
        if(Vtype.getText().equals("SUV")){
            pricetype.setText("            530 $      ");
        }
        if(Vtype.getText().equals("TRUCK")){
            pricetype.setText("            650 $      ");
        }
        pricetype.setEditable(false);
    }
    public void typeyear(){
        intype.setText("1 Year");
        if(Vtype.getText().equals("CAR")){
            pricetype.setText("          550 $      ");
        }
        if(Vtype.getText().equals("SUV")){
            pricetype.setText("          1000 $      ");
        }
        if(Vtype.getText().equals("TRUCK")){
            pricetype.setText("          1200 $      ");
        }
        pricetype.setEditable(false);
    }
    public void typeyears(){
        intype.setText("3 Years");
        if(Vtype.getText().equals("CAR")){
            pricetype.setText("          1500 $      ");
        }
        if(Vtype.getText().equals("SUV")){
            pricetype.setText("          2500 $      ");
        }
        if(Vtype.getText().equals("TRUCK")){
            pricetype.setText("          3350 $      ");
        }
        pricetype.setEditable(false);
    }

    @FXML
    private TextField Parea;

    @FXML
    private TextField Pprice;

    @FXML
    private MenuButton pinT;
    public void  pmonth(){
        Pprice.setEditable(false);
        pinT.setText("6 Months");
        String text = Parea.getText().trim();
        int value = Integer.parseInt(text);
        if(value>20&value<40) {
            Pprice.setText(String.valueOf(("         "+150 +"$")));
        }
        if(value>40&value<100) {
            Pprice.setText(String.valueOf(("         "+150 +"$")));
        }
        if(value>100&value<140) {
            Pprice.setText(String.valueOf(("         "+150 +"$")));
        }
        if(value>140&value<200) {
            Pprice.setText(String.valueOf(("         "+150 +"$")));
        }
        if(value>200|value<20){
            Pprice.setText(String.valueOf(("Invalid Area")));
        }
    }
    public void  pyear(){
        Pprice.setEditable(false);
        pinT.setText("1 Year");
        String text = Parea.getText().trim();
        int value = Integer.parseInt(text);
    }
    public void  pmyears(){
        Pprice.setEditable(false);
        pinT.setText("3 Years");
        String text = Parea.getText().trim();
        int value = Integer.parseInt(text);
    }

    @FXML
    private TextField Hprice;

    @FXML
    private MenuButton Htype;

    @FXML
    private MenuItem JerCi;

    @FXML
    private MenuItem NajahH;

    @FXML
    private MenuItem Ramci;

    @FXML
    private MenuItem RaziH;

    @FXML
    private MenuItem arabiH;

    @FXML
    private MenuButton inT;

    @FXML
    private MenuItem palestineH;
    public void arabi(){
        Htype.setText("Al Arabi Hospital");
        Hprice.setEditable(false);
    }
    public void pal(){
        Htype.setText("Palestine Hospital");
        Hprice.setEditable(false);
    }
    public void naj(){
        Htype.setText("Al Najah Hospital");
        Hprice.setEditable(false);
    }
    public void razi(){
        Htype.setText("Al Razi Hospital");
        Hprice.setEditable(false);
    }
    public void jer(){
        Htype.setText("Jerusalem Clinic");
        Hprice.setEditable(false);
    }
    public void ram(){
        Htype.setText("Ramallah Clinic");
        Hprice.setEditable(false);
    }
    public void hmonth(){
        inT.setText("6 months");
        if(Htype.getText().equals("Al Arabi Hospital")|| Htype.getText().equals("Palestine Hospital" )|| Htype.getText().equals("Al Razi Hospital" )|| Htype.getText().equals("Al Najah Hospital" )){
            Hprice.setText("              180 $");
        }
        if(Htype.getText().equals("Jerusalem Clinic")|| Htype.getText().equals("Ramallah Clinic" )){
            Hprice.setText("              120 $");
        }
    }
    public void hyear(){
        inT.setText("1 Year");
        if(Htype.getText().equals("Al Arabi Hospital")|| Htype.getText().equals("Palestine Hospital" )|| Htype.getText().equals("Al Razi Hospital" )|| Htype.getText().equals("Al Najah Hospital" )){
            Hprice.setText("              250 $");
        }
        if(Htype.getText().equals("Jerusalem Clinic")|| Htype.getText().equals("Ramallah Clinic" )){
            Hprice.setText("              130 $");
        }

    }
    public void hyears(){
        inT.setText("3 Years");
        if(Htype.getText().equals("Al Arabi Hospital")|| Htype.getText().equals("Palestine Hospital" )|| Htype.getText().equals("Al Razi Hospital" )|| Htype.getText().equals("Al Najah Hospital" )){
            Hprice.setText("              700 $");
        }
        if(Htype.getText().equals("Jerusalem Clinic")|| Htype.getText().equals("Ramallah Clinic" )){
            Hprice.setText("              360 $");
        }

    }












}
