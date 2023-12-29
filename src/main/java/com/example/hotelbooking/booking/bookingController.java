package com.example.hotelbooking.booking;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.util.Random;

public class bookingController {


    public TableView tvBooking;
    public ComboBox cbRoomtype;
    public Label lblPrice;

    public  int longStay,totalPrice,roomPrice,bookTypePrice,roomNum,payment;
    public TextField tbLongstay;
    public Label lblTotalPrice;
    public Label lblInclude;
    public ComboBox cbBooktype;
    public TextField tbRoomNumber;
    public DatePicker dpCheckin;
    public TextField tbPhoneNumber;
    public Button btnSubmit;
    public TextField tbPayment;
    public TextField tbName;
    public Button btnCancel;
    public Label lblLunas;

    public boolean lunas;

    ObservableList<String> roomType = FXCollections.observableArrayList("Standart","Deluxe");

    ObservableList<String> bookType = FXCollections.observableArrayList("Include Breakfast","No Include");

    private ObservableList<bookingData> bookingDataList = FXCollections.observableArrayList();
    Random random = new Random();

    @FXML
    private void initialize(){
        cbRoomtype.setItems(roomType);
        cbBooktype.setItems(bookType);

        TableColumn breakfast = new TableColumn("BookingType");
        TableColumn name = new TableColumn("Name");
        TableColumn phoneNumber = new TableColumn("PhoneNumber");
        TableColumn roomNumber = new TableColumn("RoomNumber");
        TableColumn checkIn = new TableColumn("CheckIn");
        TableColumn longStay = new TableColumn("LongStay");
        TableColumn totalPrice = new TableColumn("TotalPrice");
        TableColumn payment = new TableColumn("Payment");

        tvBooking.getColumns().addAll(breakfast, name, phoneNumber, roomNumber, checkIn, longStay, totalPrice, payment);
        tvBooking.setItems(bookingDataList);

        breakfast.setCellValueFactory(new PropertyValueFactory<>("breakfast"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        roomNumber.setCellValueFactory(new PropertyValueFactory<>("numberRoom"));
        checkIn.setCellValueFactory(new PropertyValueFactory<>("checkIn"));
        longStay.setCellValueFactory(new PropertyValueFactory<>("longStay"));
        totalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        payment.setCellValueFactory(new PropertyValueFactory<>("payment"));

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

        if (!tbLongstay.getText().matches("^[0-9]+$")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Hanya boleh input angka");
            alert.show();
            tbLongstay.deletePreviousChar();
        }else{

            longStay = Integer.parseInt(tbLongstay.getText());
            totalPrice = (roomPrice+bookTypePrice)*longStay;
            lblTotalPrice.setText(String.valueOf(totalPrice));
        }


    }

    public void actionSubmit(ActionEvent actionEvent) {
        if (cbBooktype.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom booking type harus dipilih");
            alert.show();
        }else if(tbName.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom name tidak boleh kosong");
            alert.show();
        }else if(tbPhoneNumber.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom phone number tidak boleh kosong");
            alert.show();
        }else if(cbRoomtype.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom room type harus dipilih");
            alert.show();
        }else if(tbRoomNumber.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom room number tidak boleh kosong");
            alert.show();
        }else if(dpCheckin.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom checkin harus dipilih");
            alert.show();
        }else if (tbLongstay.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Kolom long stay tidak boleh kosong");
            alert.show();
        } else if (lunas==false) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Uang anda tidak mencukupi");
            alert.show();
        } else{

            String breakfast = (String) cbBooktype.getValue();
            String name = tbName.getText();
            String phoneNumber = tbPhoneNumber.getText();
            String typeRoom = (String) cbRoomtype.getValue();
            String numberRoom = tbRoomNumber.getText();
            String checkIn = dpCheckin.getValue().toString();
            String longStay = tbLongstay.getText();
            String totalPrice = lblTotalPrice.getText();
            String payment = tbPayment.getText();

            bookingDataList.add(new bookingData(breakfast, name, phoneNumber, typeRoom, numberRoom, checkIn, longStay, totalPrice, payment));

            clear();
        }
    }

    public void clear(){
        tbName.clear();
        tbPhoneNumber.clear();
        tbLongstay.clear();
        tbPayment.clear();
        tbRoomNumber.clear();
        tbLongstay.clear();
        lblInclude.setText(String.valueOf(0));
        lblPrice.setText(String.valueOf(0));
        lblTotalPrice.setText(String.valueOf(0));
    }

    public void actionCancel(ActionEvent actionEvent) {
        int selectedItem = tvBooking.getSelectionModel().getSelectedIndex();
        tvBooking.getItems().remove(selectedItem);
    }

    public void validateName(KeyEvent keyEvent) {
        if (!tbName.getText().matches("^[a-zA-Z' ]+$")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Tidak boleh input angka dan simbol");
            alert.show();
            tbName.deletePreviousChar();
        }
    }

    public void validatePhoneNum(KeyEvent keyEvent) {
        if (!tbPhoneNumber.getText().matches("^[0-9]+$")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Hanya boleh input angka");
            alert.show();
            tbPhoneNumber.deletePreviousChar();
        }
    }

    public void validatePayment(KeyEvent keyEvent) {
        if (!tbPayment.getText().matches("^[0-9]+$")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Hanya boleh input angka");
            alert.show();
            tbPayment.deletePreviousChar();
        }else{
            payment = Integer.parseInt(tbPayment.getText());
            if (payment>=totalPrice){
                lblLunas.setText("Lunas");
                lunas=true;
            }else{
                lblLunas.setText("Belum Lunas");
                lunas=false;
            }

        }
    }


    public static class bookingData {
        private final SimpleStringProperty breakfast,name,phoneNumber,typeRoom,numberRoom,checkIn,longStay,totalPrice,payment;

        public bookingData(String breakfast, String name, String phoneNumber, String typeRoom, String numberRoom, String checkIn, String longStay, String totalPrice, String payment) {
            this.breakfast = new SimpleStringProperty(breakfast);
            this.name = new SimpleStringProperty (name);
            this.phoneNumber = new SimpleStringProperty (phoneNumber);
            this.typeRoom = new SimpleStringProperty (typeRoom);
            this.numberRoom = new SimpleStringProperty (numberRoom);
            this.checkIn = new SimpleStringProperty (checkIn);
            this.longStay = new SimpleStringProperty (longStay);
            this.totalPrice = new SimpleStringProperty (totalPrice);
            this.payment = new SimpleStringProperty(payment);
        }

        public String getPayment() {
            return payment.get();
        }

        public SimpleStringProperty paymentProperty() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment.set(payment);
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
