package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.postgresql.Driver;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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
    private String Password="-9";
    @FXML
    private String SSNChick="-9";



    @FXML
    public void CLOSEpainLOGIN(){
        signinpanel.setVisible(false);
        SSNLogIn.setText("");
        passlogin.setText("");
    }
    public void confirmpainLOGIN()throws IOException {
        String text = SSNLogIn.getText();
        if (text.startsWith("9")) {
        try {


            DriverManager.registerDriver(new Driver());
            String custr = "jdbc:postgresql://localhost:5432/postgres";
            String un = "postgres";
            String up = "1221";
            Connection conn = DriverManager.getConnection(custr, un, up);


            String strStmt ="SELECT ssn AS  chickssn FROM person WHERE ssn='"+SSNLogIn.getText()+"' ";
            PreparedStatement pstmt =conn.prepareStatement(strStmt);
            ResultSet rs = pstmt.executeQuery();
            //SSNChick="-55";
            if (rs.next()) {
                SSNChick  = String.valueOf(rs.getInt("chickssn"));
            }

            if(Objects.equals(SSNChick, "999")){



                strStmt = "SELECT ppassword AS chickpass FROM person where ssn='"+SSNLogIn.getText()+"'";

                pstmt = conn.prepareStatement(strStmt);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    Password  = String.valueOf(rs.getInt("chickpass"));
                }

                if(Objects.equals(Password, passlogin.getText())) {


                    signinpanel.setVisible(false);

                    LoginButton.setVisible(false);
                    SignUpButton.setVisible(false);

                    Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
                    mainpage.getChildren().setAll(root);
                    signinpanel.setVisible(false);
                    SSNLogIn.setText("");
                    passlogin.setText("");

                }   else {
                    JOptionPane.showMessageDialog(null,"The Password is wrong");

                    passlogin.setText("");
                }



            }else {
                JOptionPane.showMessageDialog(null,"SSN IS NOT FOUND TRY AGAIN PLEASE");
                SSNLogIn.setText("");
                passlogin.setText("");
            }


        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
            SSNLogIn.setText("");
            passlogin.setText("");
        }






        }
        else if (text.startsWith("7")) {

                try {


                DriverManager.registerDriver(new Driver());
                String custr = "jdbc:postgresql://localhost:5432/postgres";
                String un = "postgres";
                String up = "1221";
                Connection conn = DriverManager.getConnection(custr, un, up);


                String strStmt ="SELECT ssn AS  chickssn FROM person WHERE ssn='"+SSNLogIn.getText()+"' ";
                PreparedStatement pstmt =conn.prepareStatement(strStmt);
                ResultSet rs = pstmt.executeQuery();
                //SSNChick="-55";
                if (rs.next()) {
                SSNChick  = String.valueOf(rs.getInt("chickssn"));
                }

                if(Objects.equals(SSNChick, "777")){

                strStmt = "SELECT ppassword AS chickpass FROM person where ssn='"+SSNLogIn.getText()+"'";

                pstmt = conn.prepareStatement(strStmt);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                Password  = String.valueOf(rs.getInt("chickpass"));
                }

                if(Objects.equals(Password, passlogin.getText())) {






                        signinpanel.setVisible(false);

            LoginButton.setVisible(false);
            SignUpButton.setVisible(false);

            Parent root= FXMLLoader.load(getClass().getResource("RequistEMP.fxml"));
            mainpage.getChildren().setAll(root);
            signinpanel.setVisible(false);
                        SSNLogIn.setText("");
                        passlogin.setText("");


            }   else {
            JOptionPane.showMessageDialog(null,"The Password is wrong");

                passlogin.setText("");
            }



            }else {
            JOptionPane.showMessageDialog(null,"SSN IS NOT FOUND TRY AGAIN PLEASE");
            SSNLogIn.setText("");
            passlogin.setText("");
            }


            }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.toString());
            }

            // signinpanel.setVisible(false);





        }
       else if (text.startsWith("8")) {

            try {


                DriverManager.registerDriver(new Driver());
                String custr = "jdbc:postgresql://localhost:5432/postgres";
                String un = "postgres";
                String up = "1221";
                Connection conn = DriverManager.getConnection(custr, un, up);


                String strStmt ="SELECT ssn AS  chickssn FROM person WHERE ssn='"+SSNLogIn.getText()+"' ";
                PreparedStatement pstmt =conn.prepareStatement(strStmt);
                ResultSet rs = pstmt.executeQuery();
                //SSNChick="-55";
                if (rs.next()) {
                    SSNChick  = String.valueOf(rs.getInt("chickssn"));
                }

                if(Objects.equals(SSNChick, "888")){

                    strStmt = "SELECT ppassword AS chickpass FROM person where ssn='"+SSNLogIn.getText()+"'";

                    pstmt = conn.prepareStatement(strStmt);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        Password  = String.valueOf(rs.getInt("chickpass"));
                    }

                    if(Objects.equals(Password, passlogin.getText())) {






                        signinpanel.setVisible(false);

            LoginButton.setVisible(false);
            SignUpButton.setVisible(false);

            Parent root= FXMLLoader.load(getClass().getResource("complaintEMP.fxml"));
            mainpage.getChildren().setAll(root);
            signinpanel.setVisible(false);

            SSNLogIn.setText("");
            passlogin.setText("");


        }   else {
            JOptionPane.showMessageDialog(null,"The Password is wrong");

            passlogin.setText("");
        }



    }else {
        JOptionPane.showMessageDialog(null,"SSN IS NOT FOUND TRY AGAIN PLEASE");
        SSNLogIn.setText("");
        passlogin.setText("");
    }


}catch (Exception e){
        JOptionPane.showMessageDialog(null,e.toString());
        }

        // signinpanel.setVisible(false);




        }
        else if (text.startsWith("6")) {







            try {


                DriverManager.registerDriver(new Driver());
                String custr = "jdbc:postgresql://localhost:5432/postgres";
                String un = "postgres";
                String up = "1221";
                Connection conn = DriverManager.getConnection(custr, un, up);


                String strStmt ="SELECT ssn AS  chickssn FROM person WHERE ssn='"+SSNLogIn.getText()+"' ";
                PreparedStatement pstmt =conn.prepareStatement(strStmt);
                ResultSet rs = pstmt.executeQuery();
                //SSNChick="-55";
                if (rs.next()) {
                    SSNChick  = String.valueOf(rs.getInt("chickssn"));
                }

                if(Objects.equals(SSNChick, "666")){

                    strStmt = "SELECT ppassword AS chickpass FROM person where ssn='"+SSNLogIn.getText()+"'";

                    pstmt = conn.prepareStatement(strStmt);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        Password  = String.valueOf(rs.getInt("chickpass"));
                    }

                    if(Objects.equals(Password, passlogin.getText())) {






                        signinpanel.setVisible(false);
                        LoginButton.setVisible(false);
                        SignUpButton.setVisible(false);

                        Parent root= FXMLLoader.load(getClass().getResource("insurance.fxml"));
                        mainpage.getChildren().setAll(root);
                        signinpanel.setVisible(false);
                        SSNLogIn.setText("");
                        passlogin.setText("");


                    }   else {
                        JOptionPane.showMessageDialog(null,"The Password is wrong");

                        passlogin.setText("");
                    }



                }else {
                    JOptionPane.showMessageDialog(null,"SSN IS NOT FOUND TRY AGAIN PLEASE");
                    SSNLogIn.setText("");
                    passlogin.setText("");
                }


            }catch (Exception e){
                JOptionPane.showMessageDialog(null,e.toString());
            }

            // signinpanel.setVisible(false);















        }




        else {
            JOptionPane.showMessageDialog(null,"SSN Is Not Apply Please Try Again");
            SSNLogIn.setText("");
            passlogin.setText("");
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
    private TextArea BDateSignUp;
    @FXML
    private TextArea ssnSignup;
    @FXML
    private TextField income_signup ;
    @FXML
    private TextField employment_signup;
    @FXML
    private int cust_no=100;


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
        BDateSignUp.setText("");
    }

    public void confirmpainSIGNUP() {




        if((Objects.equals(PasswordSignUp.getText(), ConfirmPassSignUp.getText()))){
            try {

                String ssn = ssnSignup.getText();
                String firstname = FnameSignUp.getText();
                String midname = MNameSignUp.getText();
                String lastname = LnameSignUp.getText();
                String Date = BDateSignUp.getText();  // Use yyyy-MM-dd format
                String address = AdressSignUp.getText();
                String age = AgeSignUp.getText();
                String email = EmailSignUp.getText();
                String Phone = PhoneSignUp.getText();
                String ppassword = PasswordSignUp.getText();




//                String ssn = "AAA111";
//                String firstname = "ahmadddd";
//                String midname = "khaleeeed";
//                String lastname = "mayyalehhhhh";
//                String Date = "2004-09-30";  // Use yyyy-MM-dd format
//                String address = "nablus";
//                String age = "20";
//                String email = "asdfghjk";
//                String Phone = "23456789";
//                String ppassword = "ahmadbro";




                DriverManager.registerDriver(new Driver());
                String custr = "jdbc:postgresql://localhost:5432/postgres";
                String un = "postgres";
                String up = "1221";
                Connection conn = DriverManager.getConnection(custr, un, up);
                conn.setAutoCommit(false);

                String strStmt = "INSERT INTO person (ssn, firstname, midname, lastname, birthdate, address, age, email, phone, ppassword) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(strStmt);

                pstmt.setString(1, ssn);
                pstmt.setString(2, firstname);
                pstmt.setString(3, midname);
                pstmt.setString(4, lastname);
                pstmt.setDate(5, java.sql.Date.valueOf(Date));
                pstmt.setString(6, address);
                pstmt.setInt(7, Integer.parseInt(age));
                pstmt.setString(8, email);
                pstmt.setInt(9, Integer.parseInt(Phone));
                pstmt.setString(10, ppassword);

                pstmt.executeUpdate();

                conn.commit();

                conn.setAutoCommit(false);

                strStmt = "SELECT MAX(customerno) AS max_customerno FROM customer";
                pstmt = conn.prepareStatement(strStmt);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    cust_no = rs.getInt("max_customerno");

                }

                String income_cust= income_signup.getText();
                String employment_cust=employment_signup.getText();
                //JOptionPane.showMessageDialog(null, cust_no);
                cust_no++;
                //String cutomer_no=cust_no+"";
                //JOptionPane.showMessageDialog(null, cust_no);
//                JOptionPane.showMessageDialog(null, income_cust+"\n"+employment_cust+"\n"+cutomer_no);


//                JOptionPane.showMessageDialog(null, income_cust+"\n"+employment_cust+"\n"+cutomer_no);
//                conn.close();
                conn.setAutoCommit(false);
                strStmt = "INSERT INTO customer (customerno, ssn, employment, income) " +
                        "VALUES (?, ?, ?, ?)";
                pstmt = conn.prepareStatement(strStmt);
                pstmt.setInt(1, cust_no);
                pstmt.setString(2, ssn);
                pstmt.setString(3, employment_cust);
                pstmt.setInt(4, Integer.parseInt(income_cust));



                pstmt.executeUpdate();

                conn.commit();
                conn.close();

                signuppane.setVisible(false);
//        PasswordSignUp.setText("");
//        ssnSignup.setText("");
//        PhoneSignUp.setText("");
//        AdressSignUp.setText("");
//        EmailSignUp.setText("");
//        AgeSignUp.setText("");
//        ConfirmPassSignUp.setText("");
//        FnameSignUp.setText("");
//        LnameSignUp.setText("");
//        MNameSignUp.setText("");
//        BDateSignUp.setText("");
//        income_signup.setText("");
//        employment_signup.setText("");


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                JOptionPane.showMessageDialog(null, "enter correct values \n or enter other SSN\nor enter the date as year-month-day");

            }
        }
            else {
                JOptionPane.showMessageDialog(null, "Retype password");
            PasswordSignUp.setText("");
            ConfirmPassSignUp.setText("");
            }



    }


    /*_______________________
       comunication
    __________________________ */





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



    public void Comppage(){
        Complaints_pane.setVisible(true);
    }

    @FXML
    public void sup_comp_click() throws SQLException {

        try {

            //بنستخدمهم عشان نبعتهم لداتاونربط ال
            String comp_title = sup_comp_title.getText();
            String comp_disc = sup_comp_textarea.getText();
            String compSSN=sup_comp_SSN.getText();

            int  recordid1 = -5; //بدي اوخدو من الداتا
            int cust_no=-5;
            String SUPPORT_Type ="Complaints";
            String status ="Pending";
            //date and time
            String current_datetime;
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            current_datetime = currentDateTime.format(formatter);//date and time is in current_datetime
            String ManagerNO="5";
            String res_req ="No";




            DriverManager.registerDriver(new Driver());
            String custr = "jdbc:postgresql://localhost:5432/postgres";
            String un = "postgres";
            String up = "1221";
            Connection conn = DriverManager.getConnection(custr, un, up);
            String strStmt;
            PreparedStatement pstmt;
            conn.setAutoCommit(false);


            
            strStmt = "SELECT customerno AS customerNo FROM customer where ssn='"+compSSN+"'";

            pstmt = conn.prepareStatement(strStmt);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cust_no  = rs.getInt("customerNo");
            }

            if(cust_no!=-5) {

                strStmt = "SELECT MAX(recordid) AS max_recordid FROM communication";

                pstmt = conn.prepareStatement(strStmt);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    recordid1 = rs.getInt("max_recordid");
                }
                recordid1++;





                 strStmt = "INSERT INTO communication (recordid, recordtype, title, massage_content, date_and_time, status, response_requird, managerno) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                 pstmt = conn.prepareStatement(strStmt);

                 pstmt.setInt(1, recordid1);
                 pstmt.setString(2, SUPPORT_Type);
                 pstmt.setString(3, comp_title);
                 pstmt.setString(4, comp_disc);
                 pstmt.setTimestamp(5, Timestamp.valueOf(current_datetime));
                 pstmt.setString(6, status);
                 pstmt.setString(7, res_req);
                 pstmt.setInt(8, Integer.parseInt(ManagerNO));


                 pstmt.executeUpdate();
                 conn.commit();


                strStmt = "INSERT INTO submit (customerno,recordid) " +
                        "VALUES (?, ?)";
                pstmt = conn.prepareStatement(strStmt);
                pstmt.setInt(1, cust_no);
                pstmt.setInt(2, recordid1);

                pstmt.executeUpdate();
                conn.commit();
                 conn.close();
                sup_comp_textarea.clear();
                sup_comp_title.clear();
                sup_comp_name.clear();
                sup_comp_email.clear();
                sup_comp_SSN.clear();

                Complaints_pane.setVisible(false);

            }else {
                JOptionPane.showMessageDialog(null,"user not found try again");
                sup_comp_textarea.clear();
                sup_comp_title.clear();
                sup_comp_name.clear();
                sup_comp_email.clear();
                sup_comp_SSN.clear();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }









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

    @FXML
    private TextField ssnv;
    @FXML
    private TextField phonev;
    @FXML
    private TextField empv;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1221";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    // Method to handle button click and insert data
    @FXML
    private void handleSubmit() {


        try {
            String ssn = ssnv.getText();
            String phone = phonev.getText();
            int ph=Integer.parseInt(phone);
            String employeeName = empv.getText();


            DriverManager.registerDriver(new Driver());
            String custr = "jdbc:postgresql://localhost:5432/postgres";
            String un = "postgres";
            String up = "1221";
            Connection conn;
             conn = DriverManager.getConnection(custr, un, up);
            String strStmt;
            PreparedStatement pstmt;
            conn.setAutoCommit(false);

            cust_no=-5;

            strStmt = "SELECT customerno AS customerNo FROM customer where ssn='"+ssnv.getText()+"'";

            pstmt = conn.prepareStatement(strStmt);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cust_no  = rs.getInt("customerNo");
            }

            if(cust_no!=-5) {
//                JOptionPane.showMessageDialog(null,"ahmad is the boss");
                // Insert data into the table
                String insertSQL = "INSERT INTO vrequest (ssn, phone, employeename) VALUES (?, ?, ?)";

                conn = connect();
                pstmt = conn.prepareStatement(insertSQL) ;
                pstmt.setString(1, ssn);
                pstmt.setInt(2, ph);
                pstmt.setString(3, employeeName);

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Data inserted successfully!");
                }

                ssnv.clear();
                phonev.clear();
                empv.clear();



            }else {
                JOptionPane.showMessageDialog(null, "user is not found try again");
                ssnv.clear();
                phonev.clear();
                empv.clear();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    @FXML
    private TextField ssnp;
    @FXML
    private TextField php;
    @FXML
    private Button senddep13;
    @FXML
    private Button senddep1;
    private static final String B_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER1 = "postgres";
    private static final String PASSWORD1 = "1221";

    private Connection pconnect() throws SQLException {
        return DriverManager.getConnection(B_URL, USER1, PASSWORD1);
    }

    // Method to handle button click and insert data
    @FXML
    private void phandleSubmit() {
        try {
            String ssn = ssnp.getText();
            String phone = php.getText();
            int ph = Integer.parseInt(phone);


            DriverManager.registerDriver(new Driver());
            String custr = "jdbc:postgresql://localhost:5432/postgres";
            String un = "postgres";
            String up = "1221";
            Connection conn;
            conn = DriverManager.getConnection(custr, un, up);
            String strStmt;
            PreparedStatement pstmt;
            conn.setAutoCommit(false);

            cust_no=-5;

            strStmt = "SELECT customerno AS customerNo FROM customer where ssn='"+ssnp.getText()+"'";

            pstmt = conn.prepareStatement(strStmt);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cust_no  = rs.getInt("customerNo");
            }

            if(cust_no!=-5) {


            // Insert data into the table
            String insertSQL = "INSERT INTO prequest (ssn, phone) VALUES (?, ?)";

             conn = pconnect();
             pstmt = conn.prepareStatement(insertSQL) ;
                pstmt.setString(1, ssn);
                pstmt.setInt(2, ph);

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Data inserted successfully!");
                }



            php.clear();
            ssnp.clear();}
            else {
                JOptionPane.showMessageDialog(null, "user is not found try again");
                php.clear();
                ssnp.clear();

            }

        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    @FXML
    private TextField ssnh;
    @FXML
    private TextField phh;
    @FXML
    private TextField hnh;
    private static final String DB_URL2 = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER2 = "postgres";
    private static final String PASSWORD2 = "1221";

    private Connection hconnect() throws SQLException {
        return DriverManager.getConnection(DB_URL2, USER2, PASSWORD2);
    }

    // Method to handle button click and insert data
    @FXML
    private void hhandleSubmit() {
        try {
            String ssn = ssnh.getText();
            String phone = phh.getText();
            int ph = Integer.parseInt(phone);
            String hospitalname = hnh.getText();

            DriverManager.registerDriver(new Driver());
            String custr = "jdbc:postgresql://localhost:5432/postgres";
            String un = "postgres";
            String up = "1221";
            Connection conn;
            conn = DriverManager.getConnection(custr, un, up);
            String strStmt;
            PreparedStatement pstmt;
            conn.setAutoCommit(false);

            cust_no=-5;

            strStmt = "SELECT customerno AS customerNo FROM customer where ssn='"+ssnh.getText()+"'";

            pstmt = conn.prepareStatement(strStmt);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cust_no  = rs.getInt("customerNo");
            }

            if(cust_no!=-5) {



                // Insert data into the table
                String insertSQL = "INSERT INTO hrequest (ssn, phone, hospitalname) VALUES (?, ?, ?)";

                 conn = hconnect();
                 pstmt = conn.prepareStatement(insertSQL);
                pstmt.setString(1, ssn);
                pstmt.setInt(2, ph);
                pstmt.setString(3, hospitalname);

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Data inserted successfully!");
                }

                ssnh.clear();
                phh.clear();
                hnh.clear();
            }
            else {
                JOptionPane.showMessageDialog(null, "user is not found try again");
                ssnh.clear();
                phh.clear();
                hnh.clear();
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

}
