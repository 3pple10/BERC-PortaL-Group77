package com.example.bercportal_2311991_2420585_2420808_2420953;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProccessSignupController {
    @FXML private ComboBox<String> cb_userType_fxid;
    @FXML private TextField emailSignupTextFieldFXID;

    private static AtomicInteger lastConsumerId = new AtomicInteger(1_000_000);
    @FXML
    private TextField userPasswordSignupTextFieldFXID1;
    @FXML
    private TextField reWriteUserPasswordSignupTextFieldFXID11;
    @FXML
    private TextField id_SignupTextFieldFXID1;
    @FXML
    private Text label_id_errors_fxid;

    @FXML
    public void initialize() {
        cb_userType_fxid.getItems().addAll("Consumer", "Tariff Approval Coordinator",
                "BERC Commissioner", "Guest user", "Consumer Support Assistant");
        cb_userType_fxid.setValue("Consumer");
    }

    @FXML
    public void SignUpOnAction(ActionEvent actionEvent) throws IOException {
        String userID = id_SignupTextFieldFXID1.getText();
        String userType = cb_userType_fxid.getValue();
        String email = emailSignupTextFieldFXID.getText();
        String password = userPasswordSignupTextFieldFXID1.getText();
        String confirmPassword = reWriteUserPasswordSignupTextFieldFXID11.getText();

        boolean check02 = true;

        if (cb_userType_fxid.getValue().equals("Consumer")) {


            try {
                if (userType== null ||email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                    label_id_errors_fxid.setText("something is empty! ");

                    return;
                }

                if (!password.equals(confirmPassword)){
                    label_id_errors_fxid.setText("passwords should be matched! ");

                    return;
                }



            }catch (Exception e){
            }

            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            try {
                Consumer consumer01 = new Consumer(
                        userPasswordSignupTextFieldFXID1.getText(),

                        " N/A",
                        " N/A",
                        emailSignupTextFieldFXID.getText(),
                        true,
                        null,
                        null,
                        id_SignupTextFieldFXID1.getId(),
                        0,
                        "N/A",
                        "N/A"
                );



                File userFile = new File("users.bin");
                boolean appendx = userFile.exists() && userFile.length() > 0;
                fos = new FileOutputStream("users.bin", appendx);
                oos = appendx? new AppendableObjectOutputStream(fos): new ObjectOutputStream(fos);

                oos.writeObject(consumer01);

                check02 = true;

                reWriteUserPasswordSignupTextFieldFXID11.clear();

            } catch (Exception e) {
            }


        }
        if (check02){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("process-login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void LoginPageFXMLOnAction(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("process-login.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}