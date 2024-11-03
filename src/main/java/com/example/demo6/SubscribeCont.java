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


public class SubscribeCont {




    //@FXML
    //private MenuItem cartype;

    //@FXML
    //private MenuItem suvtype;

    //@FXML
    //private MenuItem trucktype;

    @FXML
    private TextField V_Subs_SSN;
    @FXML
    private TextField V_Subs_holdername;
    @FXML
    private MenuButton Vtype;
    @FXML
    private TextField pricetype;
    @FXML
    private MenuButton intype;
    @FXML
    private Button V_SUB_Submit_Button;


//// for data base
    int policyid=0;// من الداتا تبعت المركبات

    //int ssn=-5;//عشان اشيك اذا موجود بالداتا تبعت الكستمر
    int cust_no=-5;//برضو للتشييك اذا كستمر ونربطو بال policy id بجدول العلاقة
    String policyholdername;//من الواجهة
    String V_Type;
    String V_INS_Type;
    String V_Prise;



    public void typeCAR(){
    Vtype.setText("CAR");
        V_Type="Car";
        pricetype.setEditable(false);
    }
    public void typeTRUCK(){
        Vtype.setText("TRUCK");
        V_Type="Truck";
        pricetype.setEditable(false);
    }
    public void typeSUV(){
        Vtype.setText("SUV");
        V_Type="SUV";
        pricetype.setEditable(false);
    }
    public void typemonths(){
        intype.setText("6 months");
        V_INS_Type="6 months";
        if(Vtype.getText().equals("CAR")){
            pricetype.setText("            300 $      ");
            V_Prise="300";
        }
        if(Vtype.getText().equals("SUV")){
            pricetype.setText("            530 $      ");
            V_Prise="530";
        }
        if(Vtype.getText().equals("TRUCK")){
            pricetype.setText("            650 $      ");
            V_Prise="650";
        }
        pricetype.setEditable(false);
        V_SUB_Submit_Button.setVisible(true);
    }
    public void typeyear(){
        intype.setText("1 Year");
        V_INS_Type="1 Year";
        if(Vtype.getText().equals("CAR")){
            pricetype.setText("          550 $      ");
            V_Prise="550";
        }
        if(Vtype.getText().equals("SUV")){
            pricetype.setText("          1000 $      ");
            V_Prise="1000";
        }
        if(Vtype.getText().equals("TRUCK")){
            pricetype.setText("          1200 $      ");
            V_Prise="1200";
        }
        pricetype.setEditable(false);
        V_SUB_Submit_Button.setVisible(true);
    }
    public void typeyears(){
        intype.setText("3 Years");
        V_INS_Type="3 Years";
        if(Vtype.getText().equals("CAR")){
            pricetype.setText("          1500 $      ");
            V_Prise="1500";
        }
        if(Vtype.getText().equals("SUV")){
            pricetype.setText("          2500 $      ");
            V_Prise="2500";
        }
        if(Vtype.getText().equals("TRUCK")){
            pricetype.setText("          3350 $      ");
            V_Prise="3350";
        }
        pricetype.setEditable(false);
        V_SUB_Submit_Button.setVisible(true);
    }

/////______________________________
    ///    V_SUB_BUTTON
    //_______________________

    public void V_SUB_CLick() throws SQLException {
        try {

            DriverManager.registerDriver(new Driver());
            String custr = "jdbc:postgresql://localhost:5432/postgres";
            String un = "postgres";
            String up = "1221";
            Connection conn = DriverManager.getConnection(custr, un, up);
            String strStmt;
            PreparedStatement pstmt;
            conn.setAutoCommit(false);

            cust_no=-5;
            strStmt = "SELECT customerno AS customerNo FROM customer where ssn='" + V_Subs_SSN.getText() + "'";

            pstmt = conn.prepareStatement(strStmt);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cust_no = rs.getInt("customerNo");
            }

            if(cust_no!=-5) {



                strStmt = "SELECT MAX(policyid) AS max_policeid FROM vehicle";

                pstmt = conn.prepareStatement(strStmt);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    policyid = rs.getInt("max_policeid");
                }
                policyid++;

                policyholdername=V_Subs_holdername.getText();



                strStmt = "INSERT INTO vehicle (policyid, policyholdername, price, vehicletype, insurancetype) " +
                        "VALUES (?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(strStmt);

                pstmt.setInt(1, policyid);
                pstmt.setString(2, policyholdername);
                pstmt.setInt(3, Integer.parseInt(V_Prise));
                pstmt.setString(4, V_Type);
                pstmt.setString(5, V_INS_Type);


                pstmt.executeUpdate();
                conn.commit();


                strStmt = "INSERT INTO participates (customerno,policyid) " +
                        "VALUES (?, ?)";
                pstmt = conn.prepareStatement(strStmt);

                pstmt.setInt(1, cust_no);
                pstmt.setInt(2, policyid);


                pstmt.executeUpdate();
                conn.commit();
                conn.close();




            }
            else {
                JOptionPane.showMessageDialog(null,"the ssn not found enter correct one \n or you must sign up first ");

            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        pricetype.setText("                     ");
        intype.setText("Shoose the Period");
        Vtype.setText("Choose The Type");
        V_Subs_holdername.clear();
        V_Subs_SSN.clear();
        JOptionPane.showMessageDialog(null,"Thank you for choosing our company.");

        V_SUB_Submit_Button.setVisible(false);
    }



    // policyid=0;// من الداتا تبعت المركبات

    //int ssn=-5;//عشان اشيك اذا موجود بالداتا تبعت الكستمر
    // cust_no=-5;//برضو للتشييك اذا كستمر ونربطو بال policy id بجدول العلاقة
    // policyholdername;//من الواجهة
    String P_Type;
    int coverageamount;//Prise*13
    String P_Prise;



    @FXML
    private Button P_SUB_Button11;
    @FXML
    private TextField P_SUB_SNN;

    @FXML
    private TextField P_SUB_holdername;
    @FXML
    private TextField P_SUB_PROP_TYPE;

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

        if (value >= 20 && value < 40) {
            Pprice.setText("         " + 150 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="150";
            coverageamount=150*13;
        } else if (value >= 40 && value < 100) {
            Pprice.setText("         " + 250 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="250";
            coverageamount=250*13;
        } else if (value >= 100 && value < 140) {
            Pprice.setText("         " + 350 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="350";
            coverageamount=350*13;
        } else if (value >= 140 && value <= 200) {
            Pprice.setText("         " + 450 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="450";
            coverageamount=450*13;
        } else {
            Pprice.setText("Invalid Area");
            P_SUB_Button11.setVisible(false);
        }

    }
    public void  pyear(){
        Pprice.setEditable(false);
        pinT.setText("1 Year");
        String text = Parea.getText().trim();
        int value = Integer.parseInt(text);
        if (value >= 20 && value < 40) {
            Pprice.setText("         " + 280 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="280";
            coverageamount=280*13;
        } else if (value >= 40 && value < 100) {
            Pprice.setText("         " + 450 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="450";
            coverageamount=450*13;
        } else if (value >= 100 && value < 140) {
            Pprice.setText("         " + 650 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="650";
            coverageamount=650*13;
        } else if (value >= 140 && value <= 200) {
            Pprice.setText("         " + 800 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="800";
            coverageamount=800*13;
        } else {
            Pprice.setText("Invalid Area");
            P_SUB_Button11.setVisible(false);
        }

    }
    public void  pmyears(){
        Pprice.setEditable(false);
        pinT.setText("3 Years");
        String text = Parea.getText().trim();
        int value = Integer.parseInt(text);
        if (value >= 20 && value < 40) {
            Pprice.setText("         " + 800 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="800";
            coverageamount=800*13;
        } else if (value >= 40 && value < 100) {
            Pprice.setText("         " + 1200 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="1200";
            coverageamount=1200*13;
        } else if (value >= 100 && value < 140) {
            Pprice.setText("         " + 1900 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="1900";
            coverageamount=1900*13;
        } else if (value >= 140 && value <= 200) {
            Pprice.setText("         " + 2200 + "$");
            P_SUB_Button11.setVisible(true);
            P_Prise="2200";
            coverageamount=2200*13;
        } else {
            Pprice.setText("Invalid Area");
            P_SUB_Button11.setVisible(false);
        }


    }



    public void P_SUB_Submit_Button() throws SQLException {

        try {

            DriverManager.registerDriver(new Driver());
            String custr = "jdbc:postgresql://localhost:5432/postgres";
            String un = "postgres";
            String up = "1221";
            Connection conn = DriverManager.getConnection(custr, un, up);
            String strStmt;
            PreparedStatement pstmt;
            conn.setAutoCommit(false);

            cust_no=-5;
            strStmt = "SELECT customerno AS customerNo FROM customer where ssn='" + P_SUB_SNN.getText() + "'";

            pstmt = conn.prepareStatement(strStmt);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cust_no = rs.getInt("customerNo");
            }

            if (cust_no != -5) {

                strStmt = "SELECT MAX(policyid) AS max_policeid FROM proparty";

                pstmt = conn.prepareStatement(strStmt);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    policyid = rs.getInt("max_policeid");
                }
                policyid++;

                policyholdername=P_SUB_holdername.getText();
                P_Type=P_SUB_PROP_TYPE.getText();







                strStmt = "INSERT INTO proparty (policyid, policyholdername, price, propartytype, coverageamount) " +
                        "VALUES (?, ?, ?, ?, ?)";
                pstmt = conn.prepareStatement(strStmt);

                pstmt.setInt(1, policyid);
                pstmt.setString(2, policyholdername);
                pstmt.setInt(3, Integer.parseInt(P_Prise));
                pstmt.setString(4, P_Type);
                pstmt.setInt(5,coverageamount);




                pstmt.executeUpdate();
                conn.commit();




                strStmt = "INSERT INTO participates (customerno,policyid) " +
                        "VALUES (?, ?)";
                pstmt = conn.prepareStatement(strStmt);

                pstmt.setInt(1, cust_no);
                pstmt.setInt(2, policyid);


                pstmt.executeUpdate();
                conn.commit();
                conn.close();





            }
            else {
                JOptionPane.showMessageDialog(null,"the ssn not found enter correct one \n or you must sign up first ");
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }



        P_SUB_SNN.setText("");
        P_SUB_holdername.setText("");
        P_SUB_PROP_TYPE.setText("");
        Parea.setText("");
        Pprice.setText("");
        pinT.setText("Choose the Type");
            JOptionPane.showMessageDialog(null,"Thank you for choosing our company.");
            P_SUB_Button11.setVisible(false);

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
