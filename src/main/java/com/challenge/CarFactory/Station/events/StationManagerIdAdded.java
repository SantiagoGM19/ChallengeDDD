package com.challenge.CarFactory.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Station.values.StationManagerId;

public class StationManagerIdAdded extends DomainEvent {

    private final StationManagerId stationManagerId;

    public StationManagerIdAdded(StationManagerId stationManagerId){
        super("carfactory.station.satationmanageridadded");
        this.stationManagerId = stationManagerId;
    }

    public StationManagerId getStationManagerId() {
        return stationManagerId;
    }
}
