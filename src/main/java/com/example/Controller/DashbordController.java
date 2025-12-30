package com.example.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashbordController {
    public Button btn1;
    public Button btn4;
    public Button btn2;
    public Button btn3;

    public void btnOnACtionCustomerManagment(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/CustomerManagment.fxml"))));
        stage.show();
    }

    public void btnOnActionItemManagment(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/ItemManagment.fxml"))));
        stage.show();
    }

    public void btnOnAvtinSupplierManagment(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/SupplierManagment.fxml"))));
        stage.show();
    }

    public void btnOnActionEmployeemanagment(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/EmployeeManagment.fxml"))));
        stage.show();

    }
}
