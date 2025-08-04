package com.example.bercportal_2311991_2420585_2420808_2420953;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.Scene;

import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProcessLoginController {
    @FXML private TextField userIDLoginTextFieldFXID;
    @FXML private ComboBox<String> cb_userType_fxid;
    @FXML
    private TextField userPasswordLoginTextFieldFXID;

    @FXML
    public void initialize() {
        cb_userType_fxid.getItems().addAll(
                "Consumer", "Tariff Approval Coordinator",
                "BERC Commissioner", "Guest user", "Consumer Support Assistant"
        );
    }

    @FXML
    public void SignUpPageFXMLOnAction(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("proccess-signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void LoginOnAction(ActionEvent actionEvent) throws IOException {



        String paswordLogin = userPasswordLoginTextFieldFXID.getText();
        String userIDLogin = userIDLoginTextFieldFXID.getText();
        String userTypeLogin = cb_userType_fxid.getValue();

        boolean check01 = true;
        boolean check02 = false;


        try{
            if ( userTypeLogin == null || userIDLogin.isEmpty() || paswordLogin.isEmpty() ){
                check01 = false;
                //
                return;
            }
            //

        }catch (Exception e){
        }

        if ( userTypeLogin.equals("Consumer") && check01){
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try{
                fis = new FileInputStream("users.bin");
                ois = new ObjectInputStream(fis);
                try {
                    while (true){
                        Consumer c2 = (Consumer) ois.readObject();
                        if (c2.getConsumerID().equals(userIDLogin) && c2.getPassword().equals(paswordLogin)){
                            check02 = true;
                            break;
                        }
                    }
                }catch (EOFException e){
                }
            }catch (Exception e){
            }
        }

        if (check02) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("consumer-dashboard-01.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
    }
}