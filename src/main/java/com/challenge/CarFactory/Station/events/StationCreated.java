package com.challenge.CarFactory.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Station.StationManager;
import com.challenge.CarFactory.Station.values.DayReportId;
import com.challenge.CarFactory.Station.values.StationManagerId;
import com.challenge.CarFactory.Station.values.Type;

public class StationCreated extends DomainEvent {

    private final StationManager stationManager;
    private final DayReportId dayReportId;
    private final Type type;

    public StationCreated(StationManager stationManager, DayReportId dayReportId, Type type){
        super("carfactory.station.stationcreated");
        this.stationManager = stationManager;
        this.dayReportId = dayReportId;
        this.type = type;
    }

    public StationManager getStationManager() {
        return stationManager;
    }

    public DayReportId getDayReportId() {
        return dayReportId;
    }

    public Type getType() {
        return type;
    }
}
