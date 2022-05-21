package com.challenge.CarFactory.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Station.values.Shift;
import com.challenge.CarFactory.Station.values.StationManagerId;

public class ShiftStationManagerChanged extends DomainEvent {

    private final StationManagerId stationManagerId;
    private final Shift shift;

    public ShiftStationManagerChanged(StationManagerId stationManagerId, Shift shift) {
        super("carfactory.station.shiftstationmanagerchanged");
        this.stationManagerId = stationManagerId;
        this.shift = shift;
    }

    public StationManagerId getStationManagerId() {
        return stationManagerId;
    }

    public Shift getShift() {
        return shift;
    }
}
