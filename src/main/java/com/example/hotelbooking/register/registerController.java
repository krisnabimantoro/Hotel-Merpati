package com.example.hotelbooking.register;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.time.LocalDate;

public class registerController {

    public TextField tbUsername;
    public TextField tbPass;
    public PasswordField tbConfirmPass;
    public ComboBox cbGender;
    public DatePicker dpBirthday;
    public TextField tbAge;
    public TextField tbPhonenumber;

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
    public void onActionLogin(ActionEvent actionEvent) {
        countLines();
        addData(tbUsername.getText(),tbPass.getText(),tbPhonenumber.getText(),cbGender.getValue(),tbAge.getText(),dpBirthday.getValue());
    }



}
