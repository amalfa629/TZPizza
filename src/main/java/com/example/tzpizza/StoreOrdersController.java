package com.example.tzpizza;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class StoreOrdersController {
    private MainMenuController mainMenuController;
    @FXML
    private ComboBox<Integer> orderNumber;
    @FXML
    private ListView<String> pizzaList;
    @FXML
    private TextField total;
    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
        displayOrder(1);
    }
    @FXML
    protected void onOrderNumberButtonClicked() {

    }
    @FXML
    protected void onCancelButtonClicked() {
        mainMenuController.cancelOrder(orderNumber.getValue());
        displayOrder(orderNumber.getValue())
    }
    @FXML
    protected void onExportButtonClicked() {
        mainMenuController.export();
    }
}