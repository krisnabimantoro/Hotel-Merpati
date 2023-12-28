package com.example.hotelbooking.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    File database = new File("C:\\Kuliah\\Semester 3\\Tugas Besar Proglan\\HotelBooking\\src\\main\\java\\com\\example\\hotelbooking\\database\\booking.txt");

    public  int ln;


    public  void countLines(){
        ln=1;
        try {
            RandomAccessFile raf = new RandomAccessFile(database, "rw");
            for (int i = 0; raf.readLine()!=null ; i++) {
                ln++;
            }
            System.out.println("Number of lines: "+ln);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void moveLogin() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("booking.fxml")));

        Scene scene = new Scene(root);

        stage = (Stage) moveRegister.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void login(String username, String pass){
        boolean cekLogin =false;

        try {
            RandomAccessFile raf = new RandomAccessFile(database,"rw");
            System.out.println(ln);
            String line;
            while ((line = raf.readLine())!=null){
                String[] data = line.split(",");
                if (username.equals(data[0].trim())&&pass.equals(data[5].trim())) {
                    moveLogin();
                    cekLogin=true;
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       if (cekLogin!=true) {
            tbPassword.clear();
            tbUsername.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Username atau passworrd salah");
            alert.show();
        }

    }
    public void onActionLogin(ActionEvent actionEvent) throws IOException {


        if (tbUsername.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom username tidak boleh kososng");
            alert.show();
        } else if (tbPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom password tidak boleh kososng");
            alert.show();
        }else {
            countLines();
            login(tbUsername.getText(),tbPassword.getText());
        }




    }

    public void onRegister(MouseEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register.fxml")));

        Scene scene = new Scene(root);

        stage = (Stage) moveRegister.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
