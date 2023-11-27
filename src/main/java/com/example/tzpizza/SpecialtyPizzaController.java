package com.example.tzpizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 a controller for the SpecialtyPizza page in the GUI
 @author Tyler Amalfa, Zafar Khan
 */
public class SpecialtyPizzaController implements Initializable {
    private MainMenuController mainMenuController;
    @FXML
    private ImageView pizzaImage;
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

    /**
     creates a reference to the main menu controller which contains the store
     @param mainMenuController
     */
    public void setMainMenuController(MainMenuController mainMenuController) {
        this.mainMenuController = mainMenuController;
    }

    /**
     run when the controller is initialized, fills listview with pizza types
     @param url
     @param resource
     */
    @Override
    public void initialize(URL url, ResourceBundle resource) {
        typePizza.getItems().addAll("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
    }

    /**
     makes a pizza
     @return returns the pizza after it is made
     */
    private Pizza makePizza() {
        boolean extraSauce = extraSauceCheck.isSelected();
        boolean extraCheese = extraCheeseCheck.isSelected();
        return PizzaMaker.createPizza(typePizza.getValue() + "," + ((RadioButton) sizes.getSelectedToggle()).getText().toUpperCase() + "," + String.valueOf(extraSauce) + "," + String.valueOf(extraCheese));
    }

    /**
     sets the price of the pizza based on the type of pizza
     */
    private void setPrice() {
        if((((RadioButton) sizes.getSelectedToggle()) != null) && (typePizza.getValue() != null)) {
            priceField.setText("$" + String.format("%.2f", makePizza().price()));
        }
    }

    /**
     refreshes price when pizza changes
     */
    @FXML
    protected void onRadioButtonClick() {
        setPrice();
    }

    /**
     changes selections based on pizza type
     */
    @FXML
    protected void onTypePizzaButtonClick() {
        String pizza = typePizza.getValue();
        toppings.getItems().clear();
        for(Topping t: PizzaMaker.createPizza(pizza + ",SMALL,true,true").getToppings()) {
            toppings.getItems().add(t.getName());
        }
        pizzaImage.setImage(new Image((new File("src/main/resources/com/example/tzpizza/" + pizza + ".png")).toURI().toString()));
        setPrice();
    }

    /**
     adds the current pizza to the current order
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