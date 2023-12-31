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
 controller for the build your own page in the GUI
 @author Tyler Amalfa, Zafar Khan
 */
public class BuildYourOwnController implements Initializable {
    private MainMenuController mainMenuController;
    @FXML
    private ToggleGroup sizes;
    @FXML
    private ToggleGroup sauces;
    @FXML
    private CheckBox extraSauceCheck;
    @FXML
    private CheckBox extraCheeseCheck;
    @FXML
    private ListView<String> availableToppings;
    @FXML
    private ListView<String> selectedToppings;
    @FXML
    private TextField priceField;

    /**
     creates a reference to the main menu controller which contains the store
     @param mainMenuController
     */
    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }

    /**
     creates the list of toppings when the page is opened
     @param url
     @param resource
     */
    @Override
    public void initialize(URL url, ResourceBundle resource) {
        for(Topping t: Topping.values()) {
            availableToppings.getItems().add(t.getName());
        }
    }

    /**
     makes a pizza with the selected toppings size and sauce as well as other specifications
     @return returns the pizza
     */
    private Pizza makePizza() {
        StringBuilder toppingsString = new StringBuilder();
        for(String t: selectedToppings.getItems()) {
            toppingsString.append(t).append(';');
        }
        boolean extraSauce = extraSauceCheck.isSelected();
        boolean extraCheese = extraCheeseCheck.isSelected();
        return PizzaMaker.createPizza("BringYourOwn" + "," + ((RadioButton) sizes.getSelectedToggle()).getText().toUpperCase() + "," + String.valueOf(extraSauce) + "," + String.valueOf(extraCheese) + "," + ((RadioButton) sauces.getSelectedToggle()).getText().toUpperCase() + "," + toppingsString);
    }

    /**
     calculates the price of the pizza
     */
    private void setPrice() {
        if((((RadioButton) sizes.getSelectedToggle()) != null) && (((RadioButton) sauces.getSelectedToggle()) != null) && (selectedToppings.getItems().size() >= 3)) {
            priceField.setText("$" + String.format("%.2f", makePizza().price()));
        }
    }

    /**
     updates the price as the pizza is changed
     */
    @FXML
    protected void onRadioButtonClick() {
        setPrice();
    }

    /**
     adds toppings to the build your own pizza with a maximum of 7 toppings
     */
    @FXML
    protected void onAddToppingButtonClick() {
        if(availableToppings.getSelectionModel().getSelectedItem() != null) {
            if (selectedToppings.getItems().size() < 7) {
                String topping = availableToppings.getSelectionModel().getSelectedItem();
                availableToppings.getItems().remove(topping);
                selectedToppings.getItems().add(topping);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Topping Issue");
                alert.setHeaderText("Too Many Toppings!!");
                alert.setContentText("Maximum of 7 toppings.");
                alert.showAndWait();
            }
            setPrice();
        }
    }

    /**
     removes a topping from the pizza
     */
    @FXML
    protected void onRemoveToppingButtonClick() {
        if(selectedToppings.getSelectionModel().getSelectedItem() != null) {
            String topping = selectedToppings.getSelectionModel().getSelectedItem();
            selectedToppings.getItems().remove(topping);
            availableToppings.getItems().add(topping);
            setPrice();
        }
    }

    /**
     adds the pizza to the current order
     @param event
     */
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
            if(sauces.getSelectedToggle() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Sauce Issue");
                alert.setHeaderText("No Sauce Selected!!");
                alert.setContentText("Please choose a sauce for the pie.");
                alert.showAndWait();
            }
            else {
                if(selectedToppings.getItems().size() < 3) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Topping Issue");
                    alert.setHeaderText("Too Few Toppings!!");
                    alert.setContentText("Minimum of 3 toppings.");
                    alert.showAndWait();
                }
                else {
                    mainMenuController.addPizza(makePizza());
                    ((Stage)((Node) event.getSource()).getScene().getWindow()).close();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Pizza Ordered");
                    alert.setHeaderText("One " + ((RadioButton)sizes.getSelectedToggle()).getText() + " Build Your Own Pie was added to Order #" + mainMenuController.getCurrentOrderNumber());
                    alert.showAndWait();
                }
            }
        }
    }
}