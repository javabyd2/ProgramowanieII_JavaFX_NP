package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AddPersonController {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField postcodeField;
    @FXML
    private TextField countryField;

    private Main main;

    public void setMain(Main main){
        this.main = main;
    }

    @FXML
    private void addDetails(){
        main.getPerson().add(new Person(firstNameField.getText(), lastNameField.getText(), streetField.getText(), cityField.getText(),
                postcodeField.getText(), countryField.getText()));
    }

}
