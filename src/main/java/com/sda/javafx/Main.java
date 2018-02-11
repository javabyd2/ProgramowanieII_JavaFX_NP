package com.sda.javafx;

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
        personObservableList.add(new Person("Agata", "Kowalczyk"));
        personObservableList.add(new Person("Adam", "Kowalski"));
        personObservableList.add(new Person("Aleksander", "Nowak"));
        personObservableList.add(new Person("Anita", "Kowal"));
        personObservableList.add(new Person("Agata", "Kowalczyk"));
        personObservableList.add(new Person("Agata", "Kowalczyk"));
        personObservableList.add(new Person("Agata", "Kowalczyk"));
        personObservableList.add(new Person("Agata", "Kowalczyk"));
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
        AnchorPane person = FXMLLoader.load(getClass().getClassLoader().getResource("personalOverview.fxml"));
        rootLayout.setCenter(person);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
