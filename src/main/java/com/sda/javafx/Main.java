package com.sda.javafx;

import com.sda.javafx.controller.MainController;
import com.sda.javafx.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personObservableList = FXCollections.observableArrayList();

    public Main(){
        personObservableList.add(new Person("Agata", "Kowalczyk", "Piękna", "Warszawa", "00-999", "Polska"));
        personObservableList.add(new Person("Adam", "Kowalski", "Wąska", "Vancouver", "2000", "Kanada"));
        personObservableList.add(new Person("Aleksander", "Nowak", "Wiejska", "Gdańsk", "36-332", "Polska"));
        personObservableList.add(new Person("Anita", "Kowal", "Shibuya", "Tokio", "34-232", "Japonia" ));
        personObservableList.add(new Person("Agnieszka", "Lipska", "Kosmmiczna", "Niewiadomo", "11-111", "Gdzieś"));
        personObservableList.add(new Person("Zbigniew", "Nowak", "abc", "Aac", "3242", "ABC"));
        personObservableList.add(new Person("Zygfryd", "Dobry", "Ulica", "Miasto", "00-000", "Kraj"));
        personObservableList.add(new Person("Zofia", "Niema", "Szeroka", "Toruń", "87-100", "Polska"));
    }

    public ObservableList<Person> getPerson() {
        return personObservableList;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        initRootLayout();
        showPersonLayout();
    }
    public void initRootLayout()throws IOException{
        rootLayout = FXMLLoader.load(getClass().getClassLoader().getResource("rootLayout.fxml"));
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void showPersonLayout() throws IOException{
        FXMLLoader loader = new FXMLLoader((getClass().getClassLoader().getResource("personalOverview.fxml")));

        AnchorPane person = loader.load();
        rootLayout.setCenter(person);
        MainController controller = loader.getController();
        controller.setMain(this);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
