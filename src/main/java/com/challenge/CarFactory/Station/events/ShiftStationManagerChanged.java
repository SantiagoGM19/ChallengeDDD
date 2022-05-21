package com.challenge.CarFactory.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Station.values.Shift;
import com.challenge.CarFactory.Station.values.StationManagerId;

public class ShiftStationManagerChanged extends DomainEvent {

    private final Shift shift;

    public ShiftStationManagerChanged(Shift shift) {
        super("carfactory.station.shiftstationmanagerchanged");
        this.shift = shift;
    }

    public Shift getShift() {
        return shift;
    }
}
