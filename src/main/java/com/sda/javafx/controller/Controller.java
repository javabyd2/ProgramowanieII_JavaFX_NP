package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.AddPerson;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> firstnameColumn;
    @FXML
    private TableColumn<Person, String> lastnameColumn;

    @FXML
    private Label firstNameLabel;
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

    @FXML
    private Button editButton;

    //referencja klasy
    private Main main;

    public Controller() {
    }

    @FXML
    private void initialize() {
        firstnameColumn.setCellValueFactory(data -> data.getValue().firstNameProperty());
        lastnameColumn.setCellValueFactory(data -> data.getValue().lastNameProperty());

        personTableView.getSelectionModel().selectedItemProperty().addListener((observable, x, y) -> showPerson(y));
    }

    @FXML
    private void deletePerson() {
        int index = personTableView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            String temp = main.getPerson().get(index).getFirstName() + " " + main.getPerson().get(index).getLastName();
            personTableView.getItems().remove(index);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Usunięto");
            alert.setHeaderText("Potwierdzenie");
            alert.setContentText("Pomyślnie usunięto indeks: " + temp);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Błąd");
            alert.setHeaderText("To jest error");
            alert.setContentText("Nie można usunąć");
            alert.showAndWait();
        }
    }
    @FXML
    private void addPerson() throws IOException {
        AnchorPane addPersonLayout = FXMLLoader.load(getClass().getClassLoader().getResource("editlayout.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(addPersonLayout);
        AddPerson addPerson = new AddPerson();
        main.getPerson().add(addPerson.getPerson());
        stage.setScene(scene);
        stage.show();

    }

    public void showPerson(Person person) {
        firstNameLabel.setText(person.getFirstName());
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
