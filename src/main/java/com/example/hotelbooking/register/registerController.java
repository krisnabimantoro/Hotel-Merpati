package com.example.hotelbooking.register;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.*;

public class registerController {

    public TextField tbUsername;
    public TextField tbPass;
    public PasswordField tbConfirmPass;
    public ComboBox cbGender;
    public DatePicker dpBirthday;
    public TextField tbAge;
    public TextField tbPhonenumber;
    public Button btnTes;
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
    public void addData(String username, String password, String phoneNumber){
        try {
            RandomAccessFile raf = new RandomAccessFile(database,"rw");

            for (int i = 0; i < ln; i++) {
                raf.readLine();
            }
            raf.writeBytes(username+"");
            raf.writeBytes(","+password+"");
            raf.writeBytes(","+phoneNumber+"\n");


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void onActionLogin(ActionEvent actionEvent) {
        countLines();
    addData(tbUsername.getText(),tbPass.getText(),tbPhonenumber.getText());
    }

    public void login(String username, String pass){

        try {
            RandomAccessFile raf = new RandomAccessFile(database,"rw");
            System.out.println(ln);
            String line;
            while ((line = raf.readLine())!=null){
                String[] data = line.split(",");
                if (username.equals(data[0].trim())&&pass.equals(data[1].trim())){
                    System.out.println("login succes");
                }else{
                    System.out.println("login gagal");
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void cekLogin(ActionEvent actionEvent) {
        countLines();
        login(tbUsername.getText(),tbPass.getText());
    }
}
