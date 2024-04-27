module com.example.projetjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires jbcrypt;
    requires spire.pdf;
    requires java.sql;
    requires java.desktop;

    requires org.apache.pdfbox;
    requires com.jfoenix;
    requires opencv;
    requires lombok;


    opens com.example.projetjava to javafx.fxml;
    exports com.example.projetjava.controller;
    opens com.example.projetjava.controller to javafx.fxml;
    exports com.example.projetjava.Apps;
    opens com.example.projetjava.Apps to javafx.fxml;
    exports com.example.projetjava;
}