package com.example.tzpizza;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CurrentOrderController implements Initializable {
    private MainMenuController mainMenuController;
    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}