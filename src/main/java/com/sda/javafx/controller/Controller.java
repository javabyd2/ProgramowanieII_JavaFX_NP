package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class Controller {

    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> firstnameColumn;
    @FXML
    private TableColumn<Person, String> lastnameColumn;

    @FXML
    private Label firstNsmeLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label postalcodeLabel;
    @FXML
    private Label countryLabel;
    //referencja klasy
    private Main main;

    public Controller() {
    }

    @FXML
    private void initialize() {
        firstnameColumn.setCellValueFactory(data -> data.getValue().firstNameProperty());
        lastnameColumn.setCellValueFactory(data -> data.getValue().lastNameProperty());

        personTableView.getSelectionModel().selectedItemProperty().addListener((observable, x, y)-> showPeron(y));
    }

    public void showPeron(Person person){
        firstNsmeLabel.setText(person.getFirstName());
        lastNameLabel.setText(person.getLastName());
        streetLabel.setText(person.getStreet());
        cityLabel.setText(person.getCity());
        postalcodeLabel.setText(person.getPostCode());
        countryLabel.setText(person.getCountry());
    }
    public void setMain(Main main) {
        this.main = main;
        personTableView.setItems(main.getPerson());

    }
}
