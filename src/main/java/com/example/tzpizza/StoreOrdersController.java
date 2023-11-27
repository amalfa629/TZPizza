package com.example.tzpizza;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    public void displayOrder(int orderNum) {
        Order order = mainMenuController.getOrder(orderNum);
        orderNumber = new ComboBox<Integer>();
        pizzaList.getItems().clear();
        for(Order o: mainMenuController.getOrders()) {
            int currentNumber = o.getOrderNumber();
            if(mainMenuController.getCurrentOrderNumber() != currentNumber) orderNumber.getItems().add(currentNumber);
            System.out.println(currentNumber);
        }
        if(mainMenuController.getCurrentOrderNumber() == orderNum) orderNum--;
        if(orderNum <= 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Orders Placed");
            alert.setHeaderText("Please place an order!");
            alert.showAndWait();
        }
        else {
            orderNumber.getSelectionModel().select(orderNumber.getItems().indexOf(orderNum));
            for (String pizza : order.getPizzaStringList()) {
                pizzaList.getItems().add(pizza);
            }
            total.setText("$" + String.format("%.2f", order.getTotal()));
        }
    }
    @FXML
    protected void onOrderNumberButtonClicked() {
        displayOrder(orderNumber.getValue());
    }
    @FXML
    protected void onCancelButtonClicked() {
        mainMenuController.cancelOrder(orderNumber.getValue());
        displayOrder(orderNumber.getValue() - 1);
    }
    @FXML
    protected void onExportButtonClicked() {
        mainMenuController.export();
    }
}