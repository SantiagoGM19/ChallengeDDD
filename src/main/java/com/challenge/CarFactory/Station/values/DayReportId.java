package com.challenge.CarFactory.Station.values;

import co.com.sofka.domain.generic.Identity;
import com.challenge.CarFactory.Car.values.CarId;

public class DayReportId extends Identity {

    public DayReportId(){

    }

    private DayReportId(String id){
        super(id);
    }

    public static DayReportId of(String id){
        return new DayReportId(id);
    }
}
