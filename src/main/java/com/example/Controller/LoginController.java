package com.example.Controller;

import com.example.Starter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField lblPassword;
    public TextField lblEmail;
    Stage stage;



    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(lblEmail.getText().isEmpty() || lblPassword.getText().isEmpty()){
            System.out.println("no");
        }else{
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashbord.fxml"))));
            stage.show();
        }
    }
}
