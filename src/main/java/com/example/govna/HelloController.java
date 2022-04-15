package com.example.govna;

import com.example.govna.repositories.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Database database;
    @FXML
    private Button btnAdministrator;

    @FXML
    public Button btnPassenger;

    @FXML
    void initialize() {
            btnPassenger.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    btnPassenger.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    PassengerViewController passengerViewController = new PassengerViewController(database);
                    loader.setLocation(getClass().getResource("passanger_view.fxml"));
                    loader.setController(passengerViewController);
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }

            });


            btnAdministrator.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    btnAdministrator.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    AdminViewController adminViewController = new AdminViewController(database);
                    loader.setLocation(getClass().getResource("admin_view.fxml"));
                    loader.setController(adminViewController);
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }

            });
    }
    public HelloController(Database database){
        this.database = database;
    }
}