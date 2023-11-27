package com.example.tzpizza;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 controller for the main menu
 @author Tyler Amalfa, Zafar Khan
 */
public class MainMenuController implements Initializable {
    private StoreOrders storeOrders;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        storeOrders = new StoreOrders();
    }
    public void addPizza(Pizza pizza) {
        storeOrders.addPizza(pizza);
    }
    public int getCurrentOrderNumber() {
        return storeOrders.getCurrentOrderNumber();
    }
    public Order getOrder(int orderNumber) {
        return storeOrders.getOrder(orderNumber);
    }
    public ArrayList<Order> getOrders() {
        return storeOrders.getOrders();
    }
    public void placeOrder() {
        storeOrders.newOrder();
    }
    public void cancelOrder(int orderNumber) {
        storeOrders.cancelOrder(orderNumber);
    }
    public void export() {
        storeOrders.export();
    }

    /**
     opens the build your own pizza menu from the main menu
     @throws IOException
     */
    @FXML
    protected void onBuildYourOwnButtonClick() throws IOException {
        Stage buildYourOwnStage = new Stage();
        buildYourOwnStage.setTitle("Build Your Own Pizza");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buildyourown-view.fxml"));
        Scene scene = new Scene(loader.load(), 960, 720);
        BuildYourOwnController buildYourOwnController = loader.getController();
        buildYourOwnStage.setScene(scene);
        buildYourOwnStage.show();
        buildYourOwnController.setMainMenuController(this);
    }

    /**
     opens the specialty pizza menu from the main menu
     @throws IOException
     */
    @FXML
    protected void onSpecialtyButtonClick() throws IOException {
        Stage specialtyPizzaStage = new Stage();
        specialtyPizzaStage.setTitle("Specialty Pizzas");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("specialtypizza-view.fxml"));
        Scene scene = new Scene(loader.load(), 960, 720);
        SpecialtyPizzaController specialtyPizzaController = loader.getController();
        specialtyPizzaStage.setScene(scene);
        specialtyPizzaStage.show();
        specialtyPizzaController.setMainMenuController(this);
    }

    /**
     opens the current order from the main menu
     @throws IOException
     */
    @FXML
    protected void onCurrentOrderButtonClick() throws IOException {
        Stage currentOrderStage = new Stage();
        currentOrderStage.setTitle("Current Order");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("currentorder-view.fxml"));
        Scene scene = new Scene(loader.load(), 960, 720);
        CurrentOrderController currentOrderController = loader.getController();
        currentOrderStage.setScene(scene);
        currentOrderStage.show();
        currentOrderController.setMainMenuController(this);
    }

    /**
     opens all the store orders
     @throws IOException
     */
    @FXML
    protected void onAllOrdersClick() throws IOException {
        Stage storeOrdersStage = new Stage();
        storeOrdersStage.setTitle("Current Order");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("storeorders-view.fxml"));
        Scene scene = new Scene(loader.load(), 960, 720);
        StoreOrdersController storeOrderSController = loader.getController();
        storeOrdersStage.setScene(scene);
        storeOrdersStage.show();
        storeOrderSController.setMainMenuController(this);
    }
}