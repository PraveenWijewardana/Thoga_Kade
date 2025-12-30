package com.example.Controller;

import com.example.Model.Employee;
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

public class EmployeeManagmentController implements Initializable {
    public TextField textAreaNic;
    public TextField textAreaName;
    public TextField textAreaId;
    public TextField textAreaPosition;
    public TextField textAreaSalary;
    public TextField textAreaDob;
    public TextField textAreaContactNumber;
    public TextField textAreaAddress;
    public TextField textAreajoinDate;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colNic;
    public TableColumn colDob;
    public TableColumn colPosition;
    public TableColumn colSalary;
    public TableColumn colProvince;
    public TableColumn colJoinDate;
    public TableColumn colContactNumber;
    public TableView<Employee> tbl;
    public TableColumn colAdress;

    ObservableList list = FXCollections.observableArrayList(
        new Employee("E001", "Kamal Fernando", "871254789V", "1987-03-22", "Assistant Manager", 62500.0, "0778541236", "No.20 Beach Road, Galle", "2019-02-18", true),
        new Employee("E002", "Kamal Fernando", "871254789V", "1987-03-22", "Assistant Manager", 62500.0, "0778541236", "No.20 Beach Road, Galle", "2019-02-18", true),
        new Employee("E003", "Kamal Fernando", "871254789V", "1987-03-22", "Assistant Manager", 62500.0, "0778541236", "No.20 Beach Road, Galle", "2019-02-18", true),
        new Employee("E004", "Kamal Fernando", "871254789V", "1987-03-22", "Assistant Manager", 62500.0, "0778541236", "No.20 Beach Road, Galle", "2019-02-18", true),
        new Employee("E005", "Kamal Fernando", "871254789V", "1987-03-22", "Assistant Manager", 62500.0, "0778541236", "No.20 Beach Road, Galle", "2019-02-18", true)
    );

    public void btnOnActionAdd(ActionEvent actionEvent) {
        list.add(new Employee(textAreaId.getText(),
                textAreaName.getText(),
                textAreaNic.getText(),
                textAreaDob.getText(),
                textAreaPosition.getText(),
                Double.parseDouble(textAreaSalary.getText()),
                textAreaContactNumber.getText(),
                textAreaAddress.getText(),
                textAreajoinDate.getText(),
                true));
    }

    public void btnOnActionReset(ActionEvent actionEvent) {
        clear();
    }

    public void btnOnActionUpdate(ActionEvent actionEvent) {
        Employee employee = tbl.getSelectionModel().getSelectedItem();
        employee.setEmployeeId(textAreaId.getText());
        employee.setName(textAreaName.getText());
        employee.setNic(textAreaNic.getText());
        employee.setDob(textAreaDob.getText());
        employee.setPosition(textAreaPosition.getText());
        employee.setSalary(Double.parseDouble(textAreaSalary.getText()));
        employee.setContactNumber(textAreaContactNumber.getText());
        employee.setAddress(textAreaAddress.getText());
        employee.setJoinedDate(textAreajoinDate.getText());
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
        colId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colJoinDate.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colAdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tbl.setItems(list);

        tbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                textAreaId.setText(newValue.getEmployeeId());
                textAreaName.setText(newValue.getName());
                textAreaNic.setText(newValue.getNic());
                textAreaDob.setText(newValue.getDob());
                textAreaPosition.setText(newValue.getPosition());
                textAreaSalary.setText(String.valueOf(newValue.getSalary()));
                textAreaContactNumber.setText(newValue.getContactNumber());
                textAreaAddress.setText(newValue.getAddress());
                textAreajoinDate.setText(newValue.getJoinedDate());
            }
        });
    }

    private void clear(){
        textAreaId.clear();
        textAreaName.clear();
        textAreaNic.clear();
        textAreaDob.clear();
        textAreaPosition.clear();
        textAreaSalary.clear();
        textAreaContactNumber.clear();
        textAreaAddress.clear();
        textAreajoinDate.clear();
        tbl.refresh();
    }
}
