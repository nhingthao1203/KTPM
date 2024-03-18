module com.mycompany.th01 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.th01 to javafx.fxml;
    exports com.mycompany.th01;
}
