package com.example.bercportal_2311991_2420585_2420808_2420953;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Consumer extends UserSuperClass implements Serializable {
    private final String consumerID;
    private final long nidNo;
    private final String cardID;
    private final String billID;

    private ArrayList<String> bills;
    private ArrayList <String> cards;
    private ArrayList <String> meterReadings;
    private ArrayList <String> complaints ;
    private ArrayList <String> payments;

    public Consumer(String password, String name, String contactNo, String email, boolean isActive, LocalDate dateOfBirth, LocalDateTime lastLogin, String consumerID, long nidNo, String cardID, String billID) {
        super(password, name, contactNo, email, isActive, dateOfBirth, lastLogin);
        this.consumerID = consumerID;
        this.nidNo = nidNo;
        this.cardID = cardID;
        this.billID = billID;
    }

    public String getConsumerID() {
        return consumerID;
    }

    public long getNidNo() {
        return nidNo;
    }

    public String getCardID() {
        return cardID;
    }

    public String getBillID() {
        return billID;
    }

    public ArrayList<String> getBills() {
        return bills;
    }

    public void setBills(ArrayList<String> bills) {
        this.bills = bills;
    }

    public ArrayList<String> getCards() {
        return cards;
    }

    public void setCards(ArrayList<String> cards) {
        this.cards = cards;
    }

    public ArrayList<String> getMeterReadings() {
        return meterReadings;
    }

    public void setMeterReadings(ArrayList<String> meterReadings) {
        this.meterReadings = meterReadings;
    }

    public ArrayList<String> getComplaints() {
        return complaints;
    }

    public void setComplaints(ArrayList<String> complaints) {
        this.complaints = complaints;
    }

    public ArrayList<String> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<String> payments) {
        this.payments = payments;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public boolean login(String enteredPassword, String userID) {
        return true;
    }


    @Override
    public boolean updateProfile() {
        return true;
    }

    @Override
    public boolean signup() {
        return true;
    }

    @Override
    public boolean logout() {
        return true;
    }

    @Override
    public String userRolesType() {
        return "Consumer";
    }

    @Override
    public String getLoginId() {
        return this.consumerID;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "consumerID='" + consumerID + '\'' +
                ", nidNo=" + nidNo +
                ", cardID='" + cardID + '\'' +
                ", billID='" + billID + '\'' +
                ", bills=" + bills +
                ", cards=" + cards +
                ", meterReadings=" + meterReadings +
                ", complaints=" + complaints +
                ", payments=" + payments +
                '}';
    }
}
