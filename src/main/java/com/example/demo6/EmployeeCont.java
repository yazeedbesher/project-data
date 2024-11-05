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
        String sql = "UPDATE communication SET response_requird = ? WHERE recordid = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Set the parameters for the query
        pstmt.setString(1, res_req); // Assuming res_req is defined somewhere in your code
        pstmt.setInt(2, id);

        // Execute the update
        int rowsAffected = pstmt.executeUpdate();

        // Check if the update was successful
        if (rowsAffected > 0) {
            res_req = "No";
            yes_no_button.setText("response required ");
            Complaints_lable.setText("");
            Complaints_num.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "No record found with the specified ID.");
        }

        // Close resources
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
            String sql = "SELECT * FROM communication order by recordid";
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
    @FXML
    private TextArea hreq;

    @FXML
    private TextArea preq;

    @FXML
    private TextArea vreq;
    public void vreq(){
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM vrequest";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            this.vreq.setText("ReqId\tSSN\t\t\t\tPhone\t\t\tEmployeeName\n");
            this.vreq.appendText("---------------------------------------------------------------------------\n");

            vreq.setStyle("-fx-control-inner-background: #65929e;");
            vreq.setEditable(false);
            while (rs.next()) {
                int reqid = rs.getInt("requestid");
                String ssn = rs.getString("ssn");
                int ph = rs.getInt("phone");
                String emp = rs.getString("employeename");

                this.vreq.appendText(reqid+ "\t\t"+ssn + "\t"+ "\t\t"+ph+ "\t\t"
                        +emp+  "\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void preq(){
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM prequest";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            this.preq.setText("ReqId\tSSN\t\t\t\tPhone\n");
            this.preq.appendText("---------------------------------------------------------------------------\n");

            preq.setStyle("-fx-control-inner-background: #65929e;");
            preq.setEditable(false);
            while (rs.next()) {
                int reqid = rs.getInt("requestid");
                String ssn = rs.getString("ssn");
                int ph = rs.getInt("phone");


                this.preq.appendText(reqid+ "\t\t"+ssn + "\t"+ "\t\t"+ph+ "\t\t"+
                        "\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void hreq(){
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM hrequest";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            this.hreq.setText("ReqId\tSSN\t\t\t\tPhone\t\t\tHospitalName\n");
            this.hreq.appendText("---------------------------------------------------------------------------\n");

            hreq.setStyle("-fx-control-inner-background: #65929e;");
            hreq.setEditable(false);
            while (rs.next()) {
                int reqid = rs.getInt("requestid");
                String ssn = rs.getString("ssn");
                int ph = rs.getInt("phone");
                String hp = rs.getString("hospitalname");


                this.hreq.appendText(reqid+ "\t\t"+ssn + "\t"+ "\t\t"+ph+ "\t\t"+ "\t\t"+hp+
                        "\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    @FXML
    private TextArea hinsur;

    @FXML
    private TextArea pinsur;

    @FXML
    private TextArea vinsur;
    public void vinsur(){
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM vehicle";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            this.vinsur.setText("Id\tName\t\t\tPrice\t\tVehcile\t\t\tType\n");
            this.vinsur.appendText("---------------------------------------------------------------------------\n");

            vinsur.setStyle("-fx-control-inner-background: #65929e;");
            vinsur.setEditable(false);
            while (rs.next()) {
                int reqid = rs.getInt("policyid");
                String name = rs.getString("policyholdername");
                int pc = rs.getInt("price");
                String vt = rs.getString("vehicletype");
                String ins = rs.getString("insurancetype");


                this.vinsur.appendText(reqid+ "\t"+name + "\t"+pc+ "\t\t"+vt+ "\t\t\t"+ins+
                        "\n");
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void pinsur(){
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM proparty";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            this.pinsur.setText("Id\tName\t\t\t\tArea\t\tType\t\t\t\tPrice\n");
            this.pinsur.appendText("---------------------------------------------------------------------------\n");

            pinsur.setStyle("-fx-control-inner-background: #65929e;");
            pinsur.setEditable(false);
            while (rs.next()) {
                int reqid = rs.getInt("policyid");
                String name = rs.getString("policyholdername");
                int area = rs.getInt("coverageamount");
                String vt = rs.getString("coverage_Type");//propartytype:)    //coverage_Type:(
                int pc = rs.getInt("price");


                this.pinsur.appendText(reqid+ "\t"+name +  "\t\t"+area+ "\t"+vt+"\t\t\t"+pc+"\n");

            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    public void hinsur() {
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM health";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            this.hinsur.setText("Id\tName\t\t\tType\t\t\t\tProvider\t\t\t\tPrice\n");
            this.hinsur.appendText("-----------------------------------------------------------------------------------------\n");

            hinsur.setStyle("-fx-control-inner-background: #65929e;");
            hinsur.setEditable(false);
            while (rs.next()) {
                int reqid = rs.getInt("policyid");
                String name = rs.getString("policyholdername");
                String type = rs.getString("propartytype");//coverage_Type:)   //propartytype:(
                String pr = rs.getString("provider");
                int pc = rs.getInt("price");


                this.hinsur.appendText(reqid + "\t" + name + "\t" + type + "\t\t\t" + pr + "\t\t\t" + pc + "\n");

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
