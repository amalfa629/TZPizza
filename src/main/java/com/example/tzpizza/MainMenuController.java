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
import java.util.ResourceBundle;

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
    @FXML
    protected void onSpecialtyButtonClick() throws IOException{
        Stage specialtyPizzaStage = new Stage();
        specialtyPizzaStage.setTitle("Specialty Pizzas");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("specialtypizza-view.fxml"));
        Scene scene = new Scene(loader.load(), 960, 720);
        SpecialtyPizzaController specialtyPizzaController = loader.getController();
        specialtyPizzaStage.setScene(scene);
        specialtyPizzaStage.show();
        specialtyPizzaController.setMainMenuController(this);
    }
    @FXML
    protected void onCurrentOrderButtonClick() {
    }
    @FXML
    protected void onAllOrdersClick() {
    }
}