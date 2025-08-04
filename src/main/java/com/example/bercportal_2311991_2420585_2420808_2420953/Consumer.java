package com.example.bercportal_2311991_2420585_2420808_2420953;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Consumer extends UserSuperClass implements Serializable {
    private final String consumerID;
    private final long nidNo;
    private final String cardID;
    private final String billID;

    private ArrayList <Bill> bills;
    private ArrayList <Card> cards;
    private ArrayList <MeterReading> meterReadings;
    private ArrayList <Complaint> complaints ;
    private ArrayList <Payment> payments;

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
    public String getPassword() {
        return super.password;
    }



    private String validateConsumerID(String consumerID){
        if (consumerID == null || consumerID.length()==7){
            throw new IllegalArgumentException("Consumer iD must be exactly 7 digits ");
        }return consumerID;
    }

    private static int counter = 1_000_000;
    public static synchronized String generateUniqueConsumerID() {
        return Integer.toString(counter++);
    }


    @Override
    public boolean updateProfile() {
        return true;
    }

    @Override
    public boolean login(String enteredPassword) {
        if (this.password.equals(enteredPassword)){
           this.setLastLogin(LocalDateTime.now());
           this.setActive(true);
           return true;
        }
        return false;
    }

    @Override
    public String userRolesType() {
        return "Consumer";
    }

    @Override
    public boolean logout() {
        this.setActive(false);
        return true;
    }

    @Override
    public boolean signup() {
        return true;
    }
}