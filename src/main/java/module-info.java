module com.example.demo6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires javafx.graphics;
    requires java.desktop;
    requires jasperreports;


    opens com.example.demo6 to javafx.fxml;
    exports com.example.demo6;
}