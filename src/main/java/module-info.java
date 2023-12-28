module com.example.hotelbooking {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.hotelbooking.register;
    opens com.example.hotelbooking.register to javafx.fxml;

    exports com.example.hotelbooking.booking;
    opens com.example.hotelbooking.booking to javafx.fxml;


    exports com.example.hotelbooking.login;
    opens com.example.hotelbooking.login to javafx.fxml;



}