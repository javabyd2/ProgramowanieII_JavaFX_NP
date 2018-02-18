package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditPersonController {


    public TextField firstNameField;
    public TextField lastNameField;
    public TextField streetField;
    public TextField cityField;
    public TextField postcodeField;
    public TextField countryField;

    private Main main;

    private int index;

    public void setIndex(int index){
        this.index = index;
    }

    public void setMain(Main main){
        this.main = main;
    }

    @FXML
    private void editDetails(){
        Person person = new Person(firstNameField.getText(), lastNameField.getText(), streetField.getText(), cityField.getText(),
                postcodeField.getText(), countryField.getText());
        main.getPerson().remove(index);
        main.getPerson().add(person);
    }
}
