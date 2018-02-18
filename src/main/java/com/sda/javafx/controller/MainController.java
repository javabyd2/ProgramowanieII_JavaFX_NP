package com.sda.javafx.controller;

import com.sda.javafx.Main;
import com.sda.javafx.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {

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

    public MainController() {
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

    public void addPerson() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("addpersonlayout.fxml"));
        AnchorPane addPersonLayout = loader.load();

        AddPersonController addPersonController = loader.getController();
        addPersonController.setMain(main);

        Stage stage = new Stage();
        Scene scene = new Scene(addPersonLayout);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void editPerson() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("editpersonlayout.fxml"));
        AnchorPane editPersonLayout = loader.load();

        EditPersonController editPersonController = loader.getController();
        editPersonController.setMain(main);
        int index = personTableView.getSelectionModel().getSelectedIndex();
        editPersonController.setIndex(index);
        if (index >= 0) {
            editPersonController.firstNameField.setText(main.getPerson().get(index).getFirstName());
            editPersonController.lastNameField.setText(main.getPerson().get(index).getLastName());
            editPersonController.streetField.setText(main.getPerson().get(index).getStreet());
            editPersonController.cityField.setText(main.getPerson().get(index).getCity());
            editPersonController.postcodeField.setText(main.getPerson().get(index).getPostCode());
            editPersonController.countryField.setText(main.getPerson().get(index).getCountry());

            Stage stage = new Stage();
            Scene scene = new Scene(editPersonLayout);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Błąd");
            alert.setHeaderText("Zaznacz pozycję do edycji");
            alert.showAndWait();
        }
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
