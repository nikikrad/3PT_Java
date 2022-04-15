package com.example.govna;

import com.example.govna.repositories.Database;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;

public class AdminViewController {

    private Database database;

    @FXML
    private Button btnAddStation;

    @FXML
    private Button btnSaveStations;

    @FXML
    private Button btnGetAllStations;

    @FXML
    private Button btnBack;

    @FXML
    void initialize() {
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                btnBack.getScene().getWindow().hide();
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
            }

        });

        btnAddStation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                btnAddStation.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                AdminStationController adminStationController = new AdminStationController(database);
                loader.setLocation(getClass().getResource("admin_station.fxml"));
                loader.setController(adminStationController);
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

        btnSaveStations.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    FileOutputStream fos = new FileOutputStream("repository.txt");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(database);
                    oos.flush();
                    oos.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnGetAllStations.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileInputStream fis = null;
                try {
                    fis = new FileInputStream("repository.txt");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                ObjectInputStream ois = null;
                try {
                    ois = new ObjectInputStream(fis);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    database = (Database) ois.readObject();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public AdminViewController(Database database) {
        this.database = database;
    }
}
