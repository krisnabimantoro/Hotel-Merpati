package com.example.hotelbooking.booking;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.io.*;
import java.nio.file.Files;
import java.util.Collection;

public class bookingController {


    public TableView tvBooking;

//    ObservableList<bookingData> dataBooking = FXCollections.observableArrayList(read);

    @FXML
    private void initialize(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Kuliah\\Semester 3\\Tugas Besar Proglan\\HotelBooking\\src\\main\\java\\com\\example\\hotelbooking\\database\\booking.txt")));
            String line;
            String[] array;

            while ((line=br.readLine())!=null){
                array = line.split(",");
//                tvBooking.getItems().add(new bookingData())
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
