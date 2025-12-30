package com.example.Controller;

import com.example.Model.Customer;
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

public class CustomerManagmentController implements Initializable {
    public TableColumn colId;
    public TableColumn colTitle;
    public TableColumn colName;
    public TableColumn colSallery;
    public TableColumn colCity;
    public TableColumn colDob;
    public TableColumn colPostalCode;
    public TableColumn colProvince;
    public TableColumn colAddress;
    public TextField textAreaId;
    public TextField textAreaTitle;
    public TextField textAreaName;
    public TextField textAreaSallery;
    public TextField textAreaAddress;
    public TextField textAreaDob;
    public TextField textAreaPostalCode;
    public TextField textAreaCity;
    public TextField textAreaProvince;
    public TableView<Customer> tbl;
    ObservableList list = FXCollections.observableArrayList(
            new Customer("A001","Mr.","Nimal","2025-10-21",25000.00,"no 20","Moratuwa","Western",10400),
            new Customer("A001","Mr.","Nimal","2025-10-21",25000.00,"no 20","Moratuwa","Western",10400),
            new Customer("A001","Mr.","Nimal","2025-10-21",25000.00,"no 20","Moratuwa","Western",10400),
            new Customer("A001","Mr.","Nimal","2025-10-21",25000.00,"no 20","Moratuwa","Western",10400),
            new Customer("A001","Mr.","Nimal","2025-10-21",25000.00,"no 20","Moratuwa","Western",10400)
    );

    public void btnOnActionAdd(ActionEvent actionEvent) {
        list.add(new Customer(textAreaId.getText(),textAreaTitle.getText(),textAreaName.getText(),textAreaDob.getText(),Double.parseDouble(textAreaSallery.getText()),textAreaAddress.getText(),textAreaCity.getText(),textAreaProvince.getText(),Integer.parseInt(textAreaPostalCode.getText())));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colId.setCellValueFactory(new PropertyValueFactory<>("cusId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colSallery.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        tbl.setItems(list);

        tbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            textAreaId.setText(newValue.getCusId());
            textAreaName.setText(newValue.getName());
            textAreaTitle.setText(newValue.getTitle());
            textAreaDob.setText(newValue.getDob());
            textAreaSallery.setText(String.valueOf(newValue.getSalary()));
            textAreaAddress.setText(newValue.getAddress());
            textAreaCity.setText(newValue.getCity());
            textAreaProvince.setText(newValue.getProvince());
            textAreaPostalCode.setText(String.valueOf(newValue.getPostalCode()));
        });
    }

    public void btnOnActionReset(ActionEvent actionEvent) {
        clear();
    }

    public void btnOnActionUpdate(ActionEvent actionEvent) {
        Customer customer= tbl.getSelectionModel().getSelectedItem();
        customer.setCusId(textAreaId.getText());
        customer.setName(textAreaName.getText());
        customer.setTitle(textAreaTitle.getText());
        customer.setDob(textAreaDob.getText());
        customer.setSalary(Double.parseDouble(textAreaSallery.getText()));
        customer.setAddress(textAreaAddress.getText());
        customer.setCity(textAreaCity.getText());
        customer.setProvince(textAreaProvince.getText());
        customer.setPostalCode(Integer.parseInt(textAreaPostalCode.getText()));
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

    private void clear(){
        textAreaId.clear();
        textAreaName.clear();
        textAreaTitle.clear();
        textAreaDob.clear();
        textAreaSallery.clear();
        textAreaAddress.clear();
        textAreaCity.clear();
        textAreaProvince.clear();
        textAreaPostalCode.clear();
        tbl.refresh();
    }
}
