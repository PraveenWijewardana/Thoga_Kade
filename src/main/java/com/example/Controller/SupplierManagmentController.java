package com.example.Controller;

import com.example.Model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SupplierManagmentController implements  Initializable{
    public TextField textAreaId;
    public TextField textAreaCompanyName;
    public TextField textAreaName;
    public TextField textAreaEmail;
    public TextField textAreaAddress;
    public TextField textAreaPhone;
    public TextField textAreaPostalCode;
    public TextField textAreaCity;
    public TextField textAreaProvince;
    public TableColumn colId;
    public TableColumn colCompanyName;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colPhone;
    public TableColumn colAddress;
    public TableColumn colCity;
    public TableColumn colProvince;
    public TableColumn colPostalCode;
    public TableView<Supplier> tbl;

    ObservableList list = FXCollections.observableArrayList(
            new Supplier("S002", "Perera Distributors", "Sunrise Foods Ltd", "No.12 Galle Road", "Colombo", "Western", 00300, "0778456123", "sunrisefoods@gmail.com"),
            new Supplier("S003", "Silva Traders", "Ceylon Spices Co.", "No.88 Temple Road", "Kandy", "Central", 20000, "0759632145", "ceylonspices@gmail.com")
            );

    public void btnOnActionAdd(ActionEvent actionEvent) {
        list.add(new Supplier(textAreaId.getText(),
                textAreaName.getText(),
                textAreaCompanyName.getText(),
                textAreaAddress.getText(),
                textAreaCity.getText(),
                textAreaProvince.getText(),
                Integer.parseInt(textAreaPostalCode.getText()),
                textAreaPhone.getText(),
                textAreaEmail.getText())
        );
    }

    public void btnOnActionReset(ActionEvent actionEvent) {
        clear();
    }

    public void btnOnActionUpdate(ActionEvent actionEvent) {
        Supplier supplier = tbl.getSelectionModel().getSelectedItem();
        supplier.setSupplierId(textAreaId.getText());
        supplier.setName(textAreaName.getText());
        supplier.setCompanyName(textAreaCompanyName.getText());
        supplier.setAddress(textAreaAddress.getText());
        supplier.setCity(textAreaCity.getText());
        supplier.setProvince(textAreaProvince.getText());
        supplier.setPostalCode(Integer.parseInt(textAreaPostalCode.getText()));
        supplier.setPhone(textAreaPhone.getText());
        supplier.setEmail(textAreaEmail.getText());
        clear();
    }

    public void dtnOnActionDelete(ActionEvent actionEvent) {
        list.remove(tbl.getSelectionModel().getSelectedItem());
    }

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/Dashbord.fxml"))));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        tbl.setItems(list);

        tbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                textAreaId.setText(newValue.getSupplierId());
                textAreaName.setText(newValue.getName());
                textAreaCompanyName.setText(newValue.getCompanyName());
                textAreaAddress.setText(newValue.getAddress());
                textAreaCity.setText(newValue.getCity());
                textAreaProvince.setText(newValue.getProvince());
                textAreaPostalCode.setText(String.valueOf(newValue.getPostalCode()));
                textAreaPhone.setText(newValue.getPhone());
                textAreaEmail.setText(newValue.getEmail());
            }
        });
    }

    private void clear(){
        textAreaId.clear();
        textAreaCompanyName.clear();
        textAreaName.clear();
        textAreaEmail.clear();
        textAreaAddress.clear();
        textAreaPhone.clear();
        textAreaPostalCode.clear();
        textAreaCity.clear();
        textAreaProvince.clear();
        tbl.refresh();
    }
}
