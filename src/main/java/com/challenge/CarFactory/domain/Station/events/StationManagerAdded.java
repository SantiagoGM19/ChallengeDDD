package com.challenge.CarFactory.domain.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Station.values.Identification;
import com.challenge.CarFactory.domain.Station.values.Name;
import com.challenge.CarFactory.domain.Station.values.Shift;
import com.challenge.CarFactory.domain.Station.values.StationManagerId;

public class StationManagerAdded extends DomainEvent {

    private final StationManagerId stationManagerId;
    private final Name name;
    private final Identification identification;
    private final Shift shift;

    public StationManagerAdded(StationManagerId stationManagerId, Name name, Identification identification, Shift shift){
        super("carfactory.station.satationmanageridadded");
        this.stationManagerId = stationManagerId;
        this.name = name;
        this.identification = identification;
        this.shift = shift;
    }

    public StationManagerId getStationManagerId() {
        return stationManagerId;
    }

    public Name getName() {
        return name;
    }

    public Identification getIdentification() {
        return identification;
    }

    public Shift getShift() {
        return shift;
    }
}
