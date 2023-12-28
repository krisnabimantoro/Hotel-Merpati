package com.example.hotelbooking.booking;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.io.*;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Random;

public class bookingController {


    public TableView tvBooking;
    public ComboBox cbRoomtype;
    public Label lblPrice;

    public  int longStay,totalPrice,roomPrice,bookTypePrice,roomNum;
    public TextField tbLongstay;
    public Label lblTotalPrice;
    public Label lblInclude;
    public ComboBox cbBooktype;
    public TextField cbName;
    public TextField tbRoomNumber;
    public DatePicker dpCheckin;
    public TextField tbPhoneNumber;
    public Button btnSubmit;

    ObservableList<String> roomType = FXCollections.observableArrayList("Standart","Deluxe");

    ObservableList<String> bookType = FXCollections.observableArrayList("Include Breakfast","No Include");
    Random random = new Random();

    @FXML
    private void initialize(){
        cbRoomtype.setItems(roomType);
        cbBooktype.setItems(bookType);


    }

    public void selectAction(ActionEvent actionEvent) {

        if (cbRoomtype.getValue().equals("Standart")){
            roomPrice = 300000;
            lblPrice.setText("300000");
            roomNum = random.nextInt(400 + 1 - 1) + 1;
            tbRoomNumber.setText(String.valueOf(roomNum));
        } else if (cbRoomtype.getValue().equals("Deluxe")) {
            roomPrice = 500000;
            lblPrice.setText("500000");
            roomNum = random.nextInt(400 + 1 - 1) + 1;
            tbRoomNumber.setText(String.valueOf(roomNum));
        }


    }

    public void selectBook(ActionEvent actionEvent) {
        if (cbBooktype.getValue().equals("Include Breakfast")){
            bookTypePrice = 100000;
            lblInclude.setText("100000");

        } else if (cbBooktype.getValue().equals("No Include")) {
            bookTypePrice = 0;
            lblInclude.setText("0");
        }
    }

    public void ttlPrice(KeyEvent keyEvent) {
        longStay = Integer.parseInt(tbLongstay.getText());
        totalPrice = roomPrice*longStay+bookTypePrice;
        lblTotalPrice.setText(String.valueOf(totalPrice));

    }


    public static class bookingData {
        private final SimpleStringProperty breakfast,name,phoneNumber,typeRoom,numberRoom,checkIn,longStay,totalPrice;

        public bookingData(String breakfast, String name, String phoneNumber, String typeRoom, String numberRoom, String checkIn, String longStay, String totalPrice) {
            this.breakfast = new SimpleStringProperty(breakfast);
            this.name = new SimpleStringProperty (name);
            this.phoneNumber = new SimpleStringProperty (phoneNumber);
            this.typeRoom = new SimpleStringProperty (typeRoom);
            this.numberRoom = new SimpleStringProperty (numberRoom);
            this.checkIn = new SimpleStringProperty (checkIn);
            this.longStay = new SimpleStringProperty (longStay);
            this.totalPrice = new SimpleStringProperty (totalPrice);
        }

        public String getBreakfast() {
            return breakfast.get();
        }

        public SimpleStringProperty breakfastProperty() {
            return breakfast;
        }

        public void setBreakfast(String breakfast) {
            this.breakfast.set(breakfast);
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public String getPhoneNumber() {
            return phoneNumber.get();
        }

        public SimpleStringProperty phoneNumberProperty() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber.set(phoneNumber);
        }

        public String getTypeRoom() {
            return typeRoom.get();
        }

        public SimpleStringProperty typeRoomProperty() {
            return typeRoom;
        }

        public void setTypeRoom(String typeRoom) {
            this.typeRoom.set(typeRoom);
        }

        public String getNumberRoom() {
            return numberRoom.get();
        }

        public SimpleStringProperty numberRoomProperty() {
            return numberRoom;
        }

        public void setNumberRoom(String numberRoom) {
            this.numberRoom.set(numberRoom);
        }

        public String getCheckIn() {
            return checkIn.get();
        }

        public SimpleStringProperty checkInProperty() {
            return checkIn;
        }

        public void setCheckIn(String checkIn) {
            this.checkIn.set(checkIn);
        }

        public String getLongStay() {
            return longStay.get();
        }

        public SimpleStringProperty longStayProperty() {
            return longStay;
        }

        public void setLongStay(String longStay) {
            this.longStay.set(longStay);
        }

        public String getTotalPrice() {
            return totalPrice.get();
        }

        public SimpleStringProperty totalPriceProperty() {
            return totalPrice;
        }

        public void setTotalPrice(String totalPrice) {
            this.totalPrice.set(totalPrice);
        }
    }
}
