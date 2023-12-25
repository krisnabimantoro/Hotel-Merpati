package com.example.hotelbooking.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

public class loginController {
    public PasswordField tbPassword;
    public TextField tbUsername;
    public Button btnLogin;
    public Label moveRegister;

    private Stage stage;
   private Parent root;




    public void onActionLogin(ActionEvent actionEvent) throws IOException {


//        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("booking.fxml")));
//
//        Scene scene = new Scene(root);
//
//        stage = (Stage) moveRegister.getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();


    }

    public void onRegister(MouseEvent event) throws IOException {



        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));

        Scene scene = new Scene(root);

        stage = (Stage) moveRegister.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
