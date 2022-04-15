package com.example.govna;

import com.example.govna.repositories.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class PassengerViewController {

    private Database database;

    @FXML
    private TextField etName;

    @FXML
    private TextField etDate;

    @FXML
    private TextField etTime;

    @FXML
    private ListView lvStations;

    @FXML
    private TextField etNumberStations;

    @FXML
    private Button btnEdit;

    @FXML
    void initialize() {
        btnEdit.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent actionEvent) {


                String name = etName.getText();
                database.setPersonName(name);
                String date = etDate.getText();
                database.setDate(date);
                String time = etTime.getText();
                database.setTime(time);
                String numberStation = etNumberStations.getText();
                int buf = 0;
                try{
                    buf = Integer.parseInt(numberStation);
                }catch (Exception ignored){

                }
                database.setNumber(buf);

                database.setNumber(buf);

                var stage = (Stage) btnEdit.getScene().getWindow();
                stage.close();
                FXMLLoader loader = new FXMLLoader();
                TicketController ticket = new TicketController(database);
                loader.setLocation(getClass().getResource("ticket.fxml"));
                loader.setController(ticket);
                Scene scene = null;
                try {
                    scene = new Scene (loader.load(), 600, 400);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.setScene(scene);
                stage.show();

            }
        });

        ObservableList<String> observableStationsList = FXCollections.observableArrayList();
        List<String> tempStationList = database.getListStations();
        for(int i = 0; i < tempStationList.size(); i++){
            observableStationsList.add((i+1) + ". " + tempStationList.get(i));
        }
        lvStations.setItems(observableStationsList);
    }

    public PassengerViewController(Database database){
        this.database = database;
    }
}
