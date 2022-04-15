package com.example.govna.repositories;

import java.util.ArrayList;
import java.util.List;

public class TimeRepository {

    private List<String> timeList = new ArrayList<>();

    public List<String> getTimeList(){return timeList;}
    public void setTimeList(String time){this.timeList.add(time);}

    public TimeRepository(){
        timeList.add("01:21");
        timeList.add("02:30");
        timeList.add("03:14");
        timeList.add("07:34");
        timeList.add("10:23");
        timeList.add("14:33");
        timeList.add("16:03");
        timeList.add("19:40");
        timeList.add("23:17");
    }
}
