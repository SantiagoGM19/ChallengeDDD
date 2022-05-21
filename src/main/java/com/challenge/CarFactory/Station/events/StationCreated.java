package com.challenge.CarFactory.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Station.values.DayReportId;
import com.challenge.CarFactory.Station.values.StationManagerId;
import com.challenge.CarFactory.Station.values.Type;

public class StationCreated extends DomainEvent {

    private final StationManagerId stationManagerId;
    private final DayReportId dayReportId;
    private final Type type;

    public StationCreated(StationManagerId stationManagerId, DayReportId dayReportId, Type type){
        super("carfactory.station.stationcreated");
        this.stationManagerId = stationManagerId;
        this.dayReportId = dayReportId;
        this.type = type;
    }

    public StationManagerId getStationManagerId() {
        return stationManagerId;
    }

    public DayReportId getDayReportId() {
        return dayReportId;
    }

    public Type getType() {
        return type;
    }
}
