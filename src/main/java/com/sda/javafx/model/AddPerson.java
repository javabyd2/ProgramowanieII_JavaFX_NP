package com.sda.javafx.model;

import com.sda.javafx.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AddPerson {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField postalcodeField;
    @FXML
    private TextField countryField;

    private Main main;

    @FXML
    private void addDetails(){
        Person person = new Person(firstNameField.getText(), lastNameField.getText(), streetField.getText(), cityField.getText(),
                postalcodeField.getText(), countryField.getText());
        main.getPerson().add(person);
        System.out.println(firstNameField.getText());
    }
    public void setMain(Main main){
        this.main = main;
    }
}
