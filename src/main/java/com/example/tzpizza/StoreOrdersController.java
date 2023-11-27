package com.example.tzpizza;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

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
        displayOrders();
    }
    public void displayOrders() {
        orderNumber.getItems().clear();
        pizzaList.getItems().clear();
        total.clear();
        if(mainMenuController.getOrders().size() <= 1) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Orders Placed");
            alert.setHeaderText("Please place an order!");
            alert.showAndWait();
        }
        else {
            ArrayList<Integer> orderNums = new ArrayList<Integer>();
            for (Order o : mainMenuController.getOrders()) {
                int currentNumber = o.getOrderNumber();
                if (mainMenuController.getCurrentOrderNumber() != currentNumber) orderNums.add(currentNumber);
            }
            orderNumber.setItems(FXCollections.observableArrayList(orderNums));
        }
    }
    public void displayOrder(int orderNum) {
        pizzaList.getItems().clear();
        Order order = mainMenuController.getOrder(orderNum);
        for (String pizza: order.getPizzaStringList()) {
            pizzaList.getItems().add(pizza);
        }
        total.setText("$" + String.format("%.2f", order.getTotal()));
    }
    @FXML
    protected void onOrderNumberButtonClicked() {
        if(orderNumber.getValue() != null) displayOrder(orderNumber.getValue());
    }
    @FXML
    protected void onCancelButtonClicked() {
        if(orderNumber.getValue() != null) {
            mainMenuController.cancelOrder(orderNumber.getValue());
            displayOrders();
        }
    }
    @FXML
    protected void onExportButtonClicked() {
        mainMenuController.export();
    }
}