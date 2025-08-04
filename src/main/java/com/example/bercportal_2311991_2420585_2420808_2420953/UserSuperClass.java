package com.example.bercportal_2311991_2420585_2420808_2420953;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class UserSuperClass {
    protected String password;
    private String name;
    private String contactNo;
    private String email;
    private boolean isActive;
    private LocalDate dateOfBirth;
    private LocalDateTime lastLogin;

    public UserSuperClass(String password, String name, String contactNo, String email, boolean isActive, LocalDate dateOfBirth, LocalDateTime lastLogin) {
        this.password = password;
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
        this.isActive = isActive;
        this.dateOfBirth = dateOfBirth;
        this.lastLogin = lastLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "UserSuperClass{" +
                "name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                ", dateOfBirth=" + dateOfBirth +
                ", lastLogin=" + lastLogin +
                '}';
    }


    public abstract boolean updateProfile();
    public abstract boolean login(String enteredPassword);
    public abstract String userRolesType();
    public abstract boolean logout();
    public abstract boolean signup();





    //changepassswordMethod
    public final boolean changePassword(String oldPassword, String newPassword, String confirmPassword){
        if(!newPassword.equals(confirmPassword)){
            return false;
        }
        if (this.password.equals(oldPassword)){
            return false;
        }
        this.password=newPassword;
        return true;

    }
}
