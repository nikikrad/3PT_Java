package com.example.govna.repositories;

import java.util.ArrayList;
import java.util.List;

public class StationsRepository {

    private List<String> stationsList = new ArrayList<String>();

    public List<String> getListStations(){return stationsList;}
    public void setStations(String stations){this.stationsList.add(stations);}

    public StationsRepository(){
        stationsList.add("Жлобин");
        stationsList.add("Гомель");
        stationsList.add("Борисов");
        stationsList.add("Брест");
    }
}
