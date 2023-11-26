package com.example.tzpizza;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    @FXML
    protected void onBuildYourOwnButtonClick() throws IOException{
        Stage buildYourOwnStage = new Stage();
        buildYourOwnStage.setTitle("Build Your Own Pizza");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("buildyourown-view.fxml"));
        BuildYourOwnController buildYourOwnController = loader.getController();
        Scene scene = new Scene(loader.load(), 640, 480);
        buildYourOwnStage.setScene(scene);
        buildYourOwnStage.show();
        buildYourOwnController.setMainMenuController(this);
    }
    @FXML
    protected void onSpecialtyButtonClick() throws IOException{
        Stage specialtyPizzaStage = new Stage();
        specialtyPizzaStage.setTitle("Specialty Pizzas");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("specialtypizza-view.fxml"));
        SpecialtyPizzaController specialtyPizzaController = loader.getController();
        Scene scene = new Scene(loader.load(), 640, 480);
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