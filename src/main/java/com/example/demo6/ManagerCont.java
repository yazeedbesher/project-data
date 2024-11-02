package com.example.demo6;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import javax.swing.*;
import java.sql.*;

public class ManagerCont {
    @FXML
    private TextArea invest;

    public void showinvestment() {
        try {
            // Database connection details
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            // Establishing connection
            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM investment";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Setting up header in the TextArea
            this.invest.setText("Dep No\tDep Name\t\t\tManager Name\tEmployees\tProfit\t\tLoss\n");
            this.invest.appendText("---------------------------------------------------------------------------------------------------------\n");

            // Fetching data and displaying all columns
            while (rs.next()) {
                int deptNo = rs.getInt("departmentno");
                String deptName = rs.getString("departmentname");
                String managerName = rs.getString("managername");
                int numOfEmp = rs.getInt("numberofemp");
                double profit = rs.getDouble("profit");
                double loss = rs.getDouble("loss");


                // Append row data to TextArea
                this.invest.appendText(deptNo + "\t\t" + deptName + "\t\t" + managerName + "\t\t" +
                        numOfEmp + "\t\t" + profit + "\t\t" + loss + "\t\t" +  "\n");
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    @FXML
    private TextArea subsshow;
    public void showsub() {
        try {
            // Database connection details
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            Connection conn = DriverManager.getConnection(url, user, password);
            String sql = "SELECT * FROM investment";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            this.subsshow.setText("CUS No\t\tSSN\t\t\tEmployment\tIncome\n");
            this.subsshow.appendText("--------------------------------------------------------------------------\n");

//            while (rs.next()) {
//                int cusno= rs.getInt("customerno");
//                String ssn = rs.getString("ssn");
//                String employment = rs.getString("employment");
//                int income = rs.getInt("income");
//
//                this.subsshow.appendText(cusno + "\t\t" + ssn + "\t\t" + employment + "\t\t" +
//                        income +"\n");
//            }



            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

}
