package com.example.hotelbooking.login;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;

public class registerController {

    public TextField tbUsername;
    public TextField tbPass;
    public PasswordField tbConfirmPass;
    public ComboBox cbGender;
    public DatePicker dpBirthday;
    public TextField tbAge;
    public TextField tbPhonenumber;

    public Label moveLogin;
    public Button btnLogin;

    private Stage stage;
    private Parent root;

    File database = new File("C:\\Kuliah\\Semester 3\\Tugas Besar Proglan\\HotelBooking\\src\\main\\java\\com\\example\\hotelbooking\\database\\booking.txt");

    ObservableList<String> jenisKelamin = FXCollections.observableArrayList("Laki-laki","Perempuan");
    public  int ln;


    @FXML
    private void initialize(){
        cbGender.setItems(jenisKelamin);
    }

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
    public void addData(String username, String password, String phoneNumber, Object gender, String age, LocalDate date){
        try {
            RandomAccessFile raf = new RandomAccessFile(database,"rw");

            for (int i = 0; i < ln; i++) {
                raf.readLine();
            }
            raf.writeBytes(username);
            raf.writeBytes(","+gender);
            raf.writeBytes(","+date);
            raf.writeBytes(","+age);
            raf.writeBytes(","+phoneNumber);
            raf.writeBytes(","+password+"\n");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void onActionLogin(ActionEvent actionEvent) throws IOException {

        if(tbUsername.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom username tidak boleh kososng");
            alert.show();
        }else if(cbGender.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom gender harus dipilih");
            alert.show();
        }else if(dpBirthday.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Date brithday harus dipilih");
            alert.show();
        }else if(tbAge.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom age tidak boleh kososng");
            alert.show();
        }else if(tbPhonenumber.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom phone number tidak boleh kososng");
            alert.show();
        }else if(tbPass.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom password tidak boleh kososng");
            alert.show();
        }else if(tbConfirmPass.getText().equals(tbPass.getText())==false) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"confirm paswrd tidak sama dengan password");
            alert.show();
        }else{
            countLines();
            addData(tbUsername.getText(),tbPass.getText(),tbPhonenumber.getText(),cbGender.getValue(),tbAge.getText(),dpBirthday.getValue());

            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));

            Scene scene = new Scene(root);

            stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(scene);
            stage.show();


        }

    }

    public void valUsername(KeyEvent keyEvent) {
        if (!tbUsername.getText().matches("^[a-zA-Z' ]+$")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Tidak boleh input angka dan simbol");
            alert.show();
            tbUsername.deletePreviousChar();
        }
    }

    public void valPhonenumber(KeyEvent keyEvent) {

        if (!tbPhonenumber.getText().matches("^[0-9]+$")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Hanya boleh input angka");
            alert.show();
            tbPhonenumber.deletePreviousChar();
        }
    }

    public void valAge(KeyEvent keyEvent) {
        if (!tbAge.getText().matches("^[0-9]+$")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Hanya boleh input angka");
            alert.show();
            tbAge.deletePreviousChar();
        }
    }

    public void valDateBirthday(MouseEvent event) {

    }
}
