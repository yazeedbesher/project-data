package com.example.demo6;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField t1;
    @FXML
    public void check(){
        if(t1.getText().equals("abd")){
  System.out.println("abd");
        }
    }

}