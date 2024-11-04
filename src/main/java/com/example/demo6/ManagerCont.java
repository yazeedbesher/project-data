package com.example.demo6;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.HashMap;

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
            this.invest.setText("Dep No\tDep Name\t\tEmployees\tProfit\t\tLoss\n");
            this.invest.appendText("---------------------------------------------------------------------------------------------------------\n");

            // Fetching data and displaying all columns
            while (rs.next()) {
                int deptNo = rs.getInt("departmentno");
                String deptName = rs.getString("departmentname");
                int numOfEmp = rs.getInt("numberofemp");
                double profit = rs.getDouble("profit");
                double loss = rs.getDouble("loss");


                // Append row data to TextArea
                this.invest.appendText(deptNo + "\t\t" + deptName  + "\t\t" +
                        numOfEmp + "\t\t" + profit + "\t\t" + loss + "\t\t" +  "\n");
            }
            invest.setStyle("-fx-control-inner-background: #65929e;");
            invest.setEditable(false);

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
            String sql = "SELECT * FROM customer";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            this.subsshow.setText("CUSNo\tSSN\t\t\tEmployment\tIncome\n");
            this.subsshow.appendText("----------------------------------------------------------------\n");

            while (rs.next()) {
                int cusno= rs.getInt("customerno");
                String ssn = rs.getString("ssn");
                String employment = rs.getString("employment");
                int income = rs.getInt("income");

                this.subsshow.appendText(cusno + "\t\t" + ssn + "\t\t" + employment + "\t\t" +
                        income +"\n");
            }
            subsshow.setStyle("-fx-control-inner-background: #65929e;");
            subsshow.setEditable(false);



            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }



    @FXML
    public void invest_report_Button() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1221";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                InputStream inp = new FileInputStream("C:\\Users\\ahmad\\IdeaProjects\\project-data\\src\\main\\resources\\com\\example\\demo6\\Invest_rep.jrxml");
                OutputStream os = new FileOutputStream("report.pdf")
        ) {
            JasperDesign jd = JRXmlLoader.load(inp);
            JasperReport jr = JasperCompileManager.compileReport(jd);

            // Use a HashMap to pass parameters if needed
            HashMap<String, Object> parameters = new HashMap<>();
            // parameters.put("paramName", paramValue); // Add any required parameters here

            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
            JasperExportManager.exportReportToPdfStream(jp, os);

            JOptionPane.showMessageDialog(null, "Report generated successfully!");
        } catch (Exception e) {
            e.printStackTrace(); // For logging
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
//    @FXML
//    public void invest_report_Button(){
//    try {
//
//        DriverManager.registerDriver(new org.postgresql.Driver());
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        String user = "postgres";
//        String password = "1221";
//        Connection conn = DriverManager.getConnection(url, user, password);
//        InputStream inp =new FileInputStream(new File("C:\\Users\\ahmad\\IdeaProjects\\project-data\\src\\main\\resources\\com\\example"));
//        JasperDesign jd= JRXmlLoader.load(inp);
//        JasperReport jr= JasperCompileManager.compileReport(jd);
//        JasperPrint jp= JasperFillManager.fillReport(jr,null,conn);
//        OutputStream os =new FileOutputStream(new File("report.pdf"));
//        JasperExportManager.exportReportToPdfStream(jp,os);
//        os.close();
//        conn.close();
//        inp.close();
//
//
//
//    }
//    catch (Exception e) {
//        JOptionPane.showMessageDialog(null, e.toString());
//    }
//
//    }
@FXML
private TextField cusNumtodel;

    public void deletecus() {
        // Retrieve customer number from text field and convert to int
        String cusNo = cusNumtodel.getText();
        int cusNum;
        try {
            cusNum = Integer.parseInt(cusNo);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid integer for customer number.");
            return;
        }

        // Database connection details
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1221";

        // SQL statements for deletion and retrieving policy IDs
        String deleteCustomerSQL = "DELETE FROM customer WHERE customerno = ?";
        String selectPolicyIdSQL = "SELECT policyid FROM participates WHERE customerno = ?";
        String deletePolicyInHealthSQL = "DELETE FROM health WHERE policyid = ?";
        String deletePolicyInVehicleSQL = "DELETE FROM vehicle WHERE policyid = ?";
        String deletePolicyInPropartySQL = "DELETE FROM proparty WHERE policyid = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Disable auto-commit for transaction management
            conn.setAutoCommit(false);

            // Step 1: Delete from the customer table
            try (PreparedStatement deleteStmt = conn.prepareStatement(deleteCustomerSQL)) {
                deleteStmt.setInt(1, cusNum);
                int rowsDeleted = deleteStmt.executeUpdate();

                if (rowsDeleted == 0) {
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "No customer found with the provided number.");
                    return;
                }
            }

            // Step 2: Retrieve policy IDs from the participates table
            StringBuilder policies = new StringBuilder();
            try (PreparedStatement selectStmt = conn.prepareStatement(selectPolicyIdSQL)) {
                selectStmt.setInt(1, cusNum);
                ResultSet rs = selectStmt.executeQuery();

                while (rs.next()) {
                    int policyId = rs.getInt("policyid");
                    policies.append("Policy ID: ").append(policyId).append("\n");

                    // Step 3: Delete corresponding policy rows in each table if they exist

                    // Delete from health table
                    try (PreparedStatement deleteHealthStmt = conn.prepareStatement(deletePolicyInHealthSQL)) {
                        deleteHealthStmt.setInt(1, policyId);
                        deleteHealthStmt.executeUpdate();
                    }

                    // Delete from vehicle table
                    try (PreparedStatement deleteVehicleStmt = conn.prepareStatement(deletePolicyInVehicleSQL)) {
                        deleteVehicleStmt.setInt(1, policyId);
                        deleteVehicleStmt.executeUpdate();
                    }

                    // Delete from proparty table
                    try (PreparedStatement deletePropartyStmt = conn.prepareStatement(deletePolicyInPropartySQL)) {
                        deletePropartyStmt.setInt(1, policyId);
                        deletePropartyStmt.executeUpdate();
                    }
                }
            }

            // Commit transaction
            conn.commit();

            // Display results
            if (policies.length() > 0) {
                JOptionPane.showMessageDialog(null, "Customer deleted successfully.\nAssociated Policies deleted:\n" + policies.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Customer deleted successfully.\nNo associated policies found.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }




    @FXML
    private TextField cusNumtodel2;
    @FXML
    private TextField empedit;

    @FXML
    private TextField incomeedit;
    public void editcus() {

        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "1221";

            String cusNo2 = cusNumtodel2.getText();
            String emp = empedit.getText();
            String inc = incomeedit.getText();

            int incom = Integer.parseInt(inc);
            int cusNum = Integer.parseInt(cusNo2);

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                String updateSQL = "UPDATE customer SET income = ?, employment = ? WHERE customerno = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                    preparedStatement.setDouble(1, incom);
                    preparedStatement.setString(2, emp);
                    preparedStatement.setInt(3, cusNum);
                    cusNumtodel2.setText("");
                    empedit.setText("");
                    incomeedit.setText("");
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Customer updated successfully.");
                    } else {
                        System.out.println("Customer not found.");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format for customer number or income.");
        }
    }
}