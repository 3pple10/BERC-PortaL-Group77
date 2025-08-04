package com.example.bercportal_2311991_2420585_2420808_2420953;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ProccessSignupController
{
    @javafx.fxml.FXML
    private TextField userIDSignupTextFieldFXID;
    @javafx.fxml.FXML
    private TextField emailSignupTextFieldFXID;
    @javafx.fxml.FXML
    private TextField userPasswordSignupTextFieldFXID1;
    @javafx.fxml.FXML
    private TextField reWriteUserPasswordSignupTextFieldFXID11;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void SignUpOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void LoginPageFXMLOnAction(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("process-login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}