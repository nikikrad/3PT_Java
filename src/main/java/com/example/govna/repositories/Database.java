package com.example.govna.repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {
    private String time = new String();

    public String getTime(){return time;}

    public void setTime(String time){this.time = time;}


    private String date = new String();

    public String getDate(){return date;}
    public void setDate(String date){this.date = date;}


    private String name = new String();

    public String getPersonName(){return name;}
    public void setPersonName(String name){this.name = name;}


    private List<String> stationsList = new ArrayList<String>();

    public List<String> getListStations(){return stationsList;}
    public void setStations(String stations){this.stationsList.add(stations);}


    private List<String> timeList = new ArrayList<>();

    public List<String> getTimeList(){return timeList;}
    public void setTimeList(String time){this.timeList.add(time);}


    private int number;

    public int getNumber(){return number;}

    public void setNumber(int number){this.number = number;}


    private List<Integer> priceList = new ArrayList<>();

    public List<Integer> getPriceList(){return priceList;}
    public void setPrice(Integer price){this.priceList.add(price);}

    public Database(){
        stationsList.add("Жлобин");
        stationsList.add("Гомель");
        stationsList.add("Борисов");
        stationsList.add("Брест");

        timeList.add("01:21");
        timeList.add("02:30");
        timeList.add("03:14");
        timeList.add("07:34");
        timeList.add("10:23");
        timeList.add("14:33");
        timeList.add("16:03");
        timeList.add("19:40");
        timeList.add("23:17");

        priceList.add(5);
        priceList.add(8);
        priceList.add(10);
        priceList.add(13);
    }
}
