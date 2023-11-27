package com.example.tzpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 a controller for the current order page in the GUI
 @author Tyler Amalfa, Zafar Khan
 */
public class CurrentOrderController {
    private MainMenuController mainMenuController;
    @FXML
    private TextField orderNumber;
    @FXML
    private ListView<String> pizzaList;
    @FXML
    private TextField subtotal;
    @FXML
    private TextField NJStateTax;
    @FXML
    private TextField total;

    /**
     creates a reference to the main menu controller which contains the store
     * @param mainMenuController
     */
    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
        orderNumber.setText(Integer.toString(mainMenuController.getCurrentOrderNumber()));
        setPizzaList();
    }

    /**
     lists the item in the order and their prices
     */
    private void setPizzaList() {
        pizzaList.getItems().clear();
        Order order = mainMenuController.getOrder(mainMenuController.getCurrentOrderNumber());
        pizzaList.getItems().addAll(order.getPizzaStringList());
        subtotal.setText("$" + String.format("%.2f", order.getSubtotal()));
        NJStateTax.setText("$" + String.format("%.2f", order.getNJStateTax()));
        total.setText("$" + String.format("%.2f", order.getTotal()));
    }

    /**
     removes a pizza from the order
     */
    @FXML
    protected void onRemoveButtonClicked() {
        if(pizzaList.getSelectionModel().getSelectedItem() != null) {
            int index = pizzaList.getItems().indexOf(pizzaList.getSelectionModel().getSelectedItem());
            mainMenuController.getOrder(mainMenuController.getCurrentOrderNumber()).removePizza(mainMenuController.getOrder(mainMenuController.getCurrentOrderNumber()).getPizzaList().get(index));
            setPizzaList();
        }
    }

    /**
     adds the order to the store orders
     @param event
     */
    @FXML
    protected void onPlaceOrderButtonClicked(ActionEvent event) {
        int orderNum = mainMenuController.getCurrentOrderNumber();
        if(!mainMenuController.getOrder(orderNum).getPizzaList().isEmpty()) {
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Placed");
            alert.setHeaderText("Order #" + orderNum);
            alert.setContentText("Total: $" + String.format("%.2f", mainMenuController.getOrder(orderNum).getTotal()));
            alert.showAndWait();
            mainMenuController.placeOrder();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Order Placed");
            alert.setHeaderText("Order #" + orderNum);
            alert.setContentText("Order is empty!");
            alert.showAndWait();
        }
    }
}