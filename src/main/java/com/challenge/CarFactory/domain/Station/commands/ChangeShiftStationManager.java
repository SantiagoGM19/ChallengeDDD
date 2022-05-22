package com.challenge.CarFactory.domain.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Station.values.Shift;
import com.challenge.CarFactory.domain.Station.values.StationId;

public class ChangeShiftStationManager extends Command {

    private final StationId stationId;
    private final Shift shift;

    public ChangeShiftStationManager(StationId stationId, Shift shift) {
        this.stationId = stationId;
        this.shift = shift;
    }

    public StationId getStationId(){return stationId;}

    public Shift getShift() {
        return shift;
    }
}
