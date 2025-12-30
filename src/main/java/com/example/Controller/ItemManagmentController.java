package com.example.Controller;

import com.example.Model.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemManagmentController implements Initializable {
    public TextField textAreaCode;
    public TextField textAreaPrice;
    public TextArea textAreaDsc;
    public TextField textAreaQty;
    public TableColumn colCode;
    public TableColumn colQty;
    public TableColumn colDsc;
    public TableColumn colCategory;
    public TableColumn colPrice;
    public TableView<Item> tbl;
    public TextField textAreaCategory;

    ObservableList list = FXCollections.observableArrayList(
            new Item("A001","red","apple",10,120.00),
            new Item("A001","red","apple",10,120.00),
            new Item("A001","red","apple",10,120.00),
            new Item("A001","red","apple",10,120.00),
            new Item("A001","red","apple",10,120.00)
    );

    public void btnOnActionAdd(ActionEvent actionEvent) {
        list.add( new Item(textAreaCode.getText(),
                textAreaDsc.getText(),
                textAreaCategory.getText(),
                Integer.parseInt(textAreaQty.getText()),
                Double.parseDouble(textAreaPrice.getText())));
    }

    public void btnOnActionReset(ActionEvent actionEvent) {
        clear();
    }

    public void btnOnActionUpdate(ActionEvent actionEvent) {
        Item item = tbl.getSelectionModel().getSelectedItem();
        item.setItemCode(textAreaCode.getText());
        item.setDsc(textAreaDsc.getText());
        item.setCategory(textAreaCategory.getText());
        item.setQtyOnHand(Integer.parseInt(textAreaQty.getText()));
        item.setUnitPrice(Double.parseDouble(textAreaPrice.getText()));
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
        colCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDsc.setCellValueFactory(new PropertyValueFactory<>("dsc"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tbl.setItems(list);

        tbl.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                textAreaCode.setText(newValue.getItemCode());
                textAreaDsc.setText(newValue.getDsc());
                textAreaCategory.setText(newValue.getCategory());
                textAreaQty.setText(String.valueOf(newValue.getQtyOnHand()));
                textAreaPrice.setText(String.valueOf(newValue.getUnitPrice()));
            }
        });
    }

    private void clear(){
        textAreaCode.clear();
        textAreaDsc.clear();
        textAreaCategory.clear();
        textAreaQty.clear();
        textAreaPrice.clear();
        tbl.refresh();
    }
}
