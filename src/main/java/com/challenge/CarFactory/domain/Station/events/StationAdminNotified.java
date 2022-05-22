package com.challenge.CarFactory.domain.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Car.values.Description;

public class StationAdminNotified extends DomainEvent {

    private final String message;

    public StationAdminNotified(String message){
        super("carfactory.station.stationadminnotified");
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
