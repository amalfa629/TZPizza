package com.example.tzpizza;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.Arrays;

public class BuildYourOwnController {
    private MainMenuController mainMenuController;
    @FXML
    protected ListView<Topping> toppings;
    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
    public void initialize() {
        toppings = new ListView<Topping>(FXCollections.observableList(Arrays.asList(Topping.values())));
    }
}