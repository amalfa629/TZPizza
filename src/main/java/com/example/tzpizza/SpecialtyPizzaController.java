package com.example.tzpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SpecialtyPizzaController implements Initializable {
    private MainMenuController mainMenuController;
    @FXML
    private ToggleGroup sizes;
    @FXML
    private CheckBox extraSauceCheck;
    @FXML
    private CheckBox extraCheeseCheck;
    @FXML
    private ComboBox<String> typePizza;
    @FXML
    private ListView<String> toppings;
    @FXML
    private TextField priceField;
    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }
    @Override
    public void initialize(URL url, ResourceBundle resource) {
        typePizza.getItems().addAll("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
    }
    private Pizza makePizza() {
        boolean extraSauce = extraSauceCheck.isSelected();
        boolean extraCheese = extraCheeseCheck.isSelected();
        return PizzaMaker.createPizza(typePizza.getValue() + "," + ((RadioButton) sizes.getSelectedToggle()).getText().toUpperCase() + "," + String.valueOf(extraSauce) + "," + String.valueOf(extraCheese));
    }
    private void setPrice() {
        if((((RadioButton) sizes.getSelectedToggle()) != null) && (typePizza.getValue() != null)) {
            priceField.setText(String.format("%.2f", makePizza().price()));
        }
    }
    @FXML
    protected void onRadioButtonClick() {
        setPrice();
    }
    @FXML
    protected void onTypePizzaButtonClick() {
        toppings.getItems().clear();
        for(Topping t: PizzaMaker.createPizza(typePizza.getValue() + ",SMALL,true,true").getToppings()) {
            toppings.getItems().add(t.getName());
        }
        setPrice();
    }
    @FXML
    protected void onAddToOrderButtonClicked(ActionEvent event) {
        if(sizes.getSelectedToggle() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Size Issue");
            alert.setHeaderText("No Size Selected!!");
            alert.setContentText("Please choose a size of pizza pie.");
            alert.showAndWait();
        }
        else {
            if(typePizza.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Type Issue");
                alert.setHeaderText("No Type of Pizza Selected!!");
                alert.setContentText("Please choose a type for the pie.");
                alert.showAndWait();
            }
            else {
                mainMenuController.addPizza(makePizza());
                ((Stage)((Node) event.getSource()).getScene().getWindow()).close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pizza Ordered");
                alert.setHeaderText("One " + ((RadioButton)sizes.getSelectedToggle()).getText() + " " + typePizza.getValue() +" was added to Order #" + mainMenuController.getCurrentOrderNumber());
                alert.showAndWait();
            }
        }
    }
}