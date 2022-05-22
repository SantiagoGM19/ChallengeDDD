package com.challenge.CarFactory.domain.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Station.values.*;

public class AddStationManager extends Command {

    private final StationId stationId;
    private final StationManagerId stationManagerId;
    private final Name name;
    private final Identification identification;
    private final Shift shift;

    public AddStationManager(StationId stationId, StationManagerId stationManagerId, Name name, Identification identification, Shift shift) {
        this.stationId = stationId;
        this.stationManagerId = stationManagerId;
        this.name = name;
        this.identification = identification;
        this.shift = shift;
    }

    public StationId getStationId(){return stationId;}

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
