package com.challenge.CarFactory.domain.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Station.values.StationId;

public class NotifyStationAdmin extends Command {

    private final StationId stationId;
    private final String message;

    public NotifyStationAdmin(StationId stationId, String message){
        this.stationId = stationId;
        this.message = message;
    }

    public StationId getStationId() {
        return stationId;
    }

    public String getMessage() {
        return message;
    }
}
