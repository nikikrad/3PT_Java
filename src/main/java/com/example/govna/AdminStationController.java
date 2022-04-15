package com.example.govna;

import com.example.govna.exeption.MyException;
import com.example.govna.repositories.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminStationController {

    private Database database;
    @FXML
    public TextField etStation;
    @FXML
    public TextField etPrice;
    @FXML
    public Button btnEdit;

    @FXML
    void initialize() {

        btnEdit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    try {
                        String stationName = etStation.getText();
                        database.setStations(stationName);
                        int priceStation = Integer.parseInt(etPrice.getText().trim());
                        database.setPrice(priceStation);
                    }catch (Exception e){
                        System.out.println();
                    }
                    btnEdit.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    HelloController helloController = new HelloController(database);
                    loader.setLocation(getClass().getResource("hello-view.fxml"));
                    loader.setController(helloController);
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }catch (Exception ignored){

                }

            }

        });
    }
    public AdminStationController(Database database){
        this.database = database;
    }
}
