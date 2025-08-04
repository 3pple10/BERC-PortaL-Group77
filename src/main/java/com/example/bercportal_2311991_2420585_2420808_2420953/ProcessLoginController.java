package com.example.bercportal_2311991_2420585_2420808_2420953;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class ProcessLoginController
{
    @javafx.fxml.FXML
    private TextField userPasswordLoginTextFieldFXID;
    @javafx.fxml.FXML
    private TextField userIDLoginTextFieldFXID;



    //has a relation
    private Consumer currentUser;



    @javafx.fxml.FXML
    private ComboBox<String> cb_userType_fxid;

    @javafx.fxml.FXML
    public void initialize() {
        cb_userType_fxid.getItems().addAll("Consumer", "Tariff Approval Coordinator", "BERC Commissioner","Guest user", "Consumer Support Assistant");
        cb_userType_fxid.setValue("Consumer");
    }



    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Consumer findTheUser(String userId) throws IOException , ClassNotFoundException{
        File file = new File("users.bin");
        if(!file.exists()) {
            return null;}
        try
                (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)){
            while (true){
                try{
                    Consumer user = (Consumer) ois.readObject();
                    if (user.getConsumerID().equals(userId)){
                        return user;
                    }
                    }catch (EOFException e){
                    break;
                }
            }
        }
        return null;
    }

    private void dashBoardSceneChange (ActionEvent event, String userType ) throws IOException{

        //String dashboardFxml="";
        if (userType.equals("Consumer")){
            //dashboardFxml = "consumer-dashboard-01.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("consumer-dashboard-01.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }
        else if (userType.equals("Tariff Approval Coordinator")){
            //dashboardFxml = "TariffApCo-dashboard-01.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TariffApCo-dashboard-01.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }


        /*else if (userType.equals("Tariff Approval Coordinator")){
            dashboardFxml = "TariffApCo-dashboard-01.fxml";
        }


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(dashboardFxml));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

         */
    }

    @javafx.fxml.FXML
    public void SignUpPageFXMLOnAction(Event event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("proccess-signup.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }



    @javafx.fxml.FXML
    public void LoginOnAction(ActionEvent actionEvent) {
        String userId = userIDLoginTextFieldFXID.getText();
        String password = userPasswordLoginTextFieldFXID.getText();
        String userType = cb_userType_fxid.getValue();
        if (userId.isEmpty() || password.isEmpty()) {
            showAlert("Login Error! ", "Please enter both user ID and password");
            return;
        }
        if (userType.equals("Consumer")) {
            try {
                int id = Integer.parseInt(userId);
                if (id < 1_000_000) {
                    showAlert("Error", "Consumer ID must be 1000000 or higher");
                    return;
                }
            } catch (NumberFormatException e) {
                showAlert("Error", "Consumer ID must be numeric");
                return;
            }
        }
        try {
            Consumer consumer = AuthenticatorClass.authenticateConsumer(userId, password);
            if (consumer != null && consumer.userRolesType().equals(userType)) {
                dashBoardSceneChange(actionEvent, userType);
            } else {
                showAlert("Login Failed", "Invalid credentials");
            }
        } catch (Exception e) {
            showAlert("Error", "Login failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}