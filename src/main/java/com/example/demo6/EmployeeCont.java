package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class EmployeeCont {


    public String status ="Pending";
    public String res_req ="No";
    //public String res_req ="No";

    @FXML
    private TextArea Complaints_lable;

    @FXML
    private TextField Complaints_num;

    @FXML
    private RadioButton completed_butt;


    @FXML
    public void get_Complaints_click() {
        try {
            // Get the complaint ID from the input field
            String ids = Complaints_num.getText();
            int id = Integer.parseInt(ids);

            // Database connection details
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            // Establishing connection
            Connection conn = DriverManager.getConnection(url, user, password);

            // Using PreparedStatement for parameterized query
            String sql = "SELECT massage_content FROM communication WHERE recordid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id); // Set the recordid parameter

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Check if there's data and fetch the message content
            if (rs.next()) {
                String msg = rs.getString("massage_content");
                // Append the message content to the label
                this.Complaints_lable.appendText(msg);
            } else {
                // No record found
                this.Complaints_lable.appendText("No complaint found with this ID.");
            }

            // Set the label as non-editable
            Complaints_lable.setEditable(false);

            // Close resources
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    @FXML
    private MenuButton yes_no_button;

    @FXML
    public void Yes_click(){
        res_req ="Yes";
        yes_no_button.setText("YES");
    }
    @FXML
    public void No_click(){
        res_req ="No";
        yes_no_button.setText("NO");

    }


@FXML
public void Update_Complaints_click(){
    try {
        // Get the complaint ID from the input field
        String ids = Complaints_num.getText();
        int id = Integer.parseInt(ids);

        // Database connection details
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1221";

        // Establishing connection
        Connection conn = DriverManager.getConnection(url, user, password);

        // Using PreparedStatement for parameterized query
        String sql = "update communication SET response_requird = 'yes' WHERE recordid = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        rs.close();
        pstmt.close();
        conn.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.toString());
    }

  }

    @FXML
    private TextArea comparea;
    @FXML
    public void Update_list_click(){
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            // Establishing connection
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM communication";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            this.comparea.setText("Id\tRec Type\t\t\tTitle\t\t\t\tStatus\t\t\t\tDate\t\t\tResponse\n");
            this.comparea.appendText("---------------------------------------------------------------------------------------------------------\n");


            comparea.setStyle("-fx-control-inner-background: #65929e;");
            comparea.setEditable(false);
            while (rs.next()) {
                int deptNo = rs.getInt("recordid");
                String rec = rs.getString("recordtype");
                String tit = rs.getString("title");
                Date date = rs.getDate("date_and_time");
                String stat = rs.getString("status");
                String res = rs.getString("response_requird");

                this.comparea.appendText(deptNo + "\t"+ rec + tit+ "\t\t"+stat + "\t"+date+ "\t\t"
                        +res+  "\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }



    }


}
