package com.challenge.CarFactory.domain.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Station.StationManager;
import com.challenge.CarFactory.domain.Station.values.DayReportId;
import com.challenge.CarFactory.domain.Station.values.Type;

public class StationCreated extends DomainEvent {

    private final DayReportId dayReportId;
    private final Type type;

    public StationCreated(DayReportId dayReportId, Type type){
        super("carfactory.station.stationcreated");
        this.dayReportId = dayReportId;
        this.type = type;
    }


    public DayReportId getDayReportId() {
        return dayReportId;
    }

    public Type getType() {
        return type;
    }
}
