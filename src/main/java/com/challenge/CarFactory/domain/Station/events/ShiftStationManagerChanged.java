package com.challenge.CarFactory.domain.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Station.values.Shift;

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
