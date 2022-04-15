package com.example.govna;

import com.example.govna.repositories.Database;
import com.example.govna.repositories.StationsRepository;
import com.example.govna.repositories.TimeRepository;
import com.example.govna.temp_repositoryes.Date;
import com.example.govna.temp_repositoryes.NumberStation;
import com.example.govna.temp_repositoryes.PersonName;
import com.example.govna.temp_repositoryes.Time;
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
import java.util.ArrayList;
import java.util.List;

public class TicketController {

    private Database database;
    @FXML
    public Label tvStation;
    @FXML
    public Label tvDate;
    @FXML
    public Label tvTime;
    @FXML
    public Label tvPrice;
    @FXML
    public Button btnBack;

    @FXML
    public Label tvName;

    @FXML
    void initialize() {
        List<String> stationList = database.getListStations();
        String station = new String();
        int temp = database.getNumber();
        for(int i = 0; i < stationList.size(); i++){
            if (temp == (i+1)){
                station = stationList.get(i);
            }
        }
        tvStation.setText(station);
        tvDate.setText(database.getDate());
        List<String> timeList = database.getTimeList();
        String enterTime = database.getTime();

        try {


            String mmm = "";
            for (int i = 0; i < 5; i++) {
                char qwe = enterTime.charAt(i);
                String charToString = Character.toString(qwe);
                if (!charToString.equals(":")) {
                    mmm += charToString;
                }
            }
            int intTime = Integer.parseInt(mmm.trim());

            String asd = "";
            ArrayList<Integer> arrayList = new ArrayList<>();
            String getTime = "";
            for (int var = 0; var < timeList.size(); var++) {
                for (int i = 0; i < 5; i++) {
                    getTime = timeList.get(var);
                    char qwe = getTime.charAt(i);
                    String charToString = Character.toString(qwe);
                    if (!charToString.equals(":")) {
                        asd += charToString;
                    }
                }

                int yuu = Integer.parseInt(asd.trim());
                arrayList.add(yuu);
                asd = "";
            }
            ArrayList<Integer> varTime = new ArrayList<>();
            for (int i = 0; arrayList.size() > i; i++) {
                if (intTime <= arrayList.get(i)) {
                    varTime.add(i);
                }
            }


            tvTime.setText(timeList.get(varTime.get(0)).toString());
            tvName.setText(database.getPersonName());
            List<Integer> priceList = database.getPriceList();

            tvPrice.setText(priceList.get((database.getNumber() - 1)).toString());
        }catch (Exception ignored){

        }









//        tvStation.setText();

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
    }
    public TicketController(Database database){
        this.database = database;
    }
}
