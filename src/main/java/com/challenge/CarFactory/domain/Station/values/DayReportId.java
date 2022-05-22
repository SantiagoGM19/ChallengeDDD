package com.challenge.CarFactory.domain.Station.values;

import co.com.sofka.domain.generic.Identity;

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
