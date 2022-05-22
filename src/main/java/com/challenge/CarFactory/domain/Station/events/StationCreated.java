package com.challenge.CarFactory.domain.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Station.values.Type;

public class StationCreated extends DomainEvent {

    private final Type type;

    public StationCreated(Type type){
        super("carfactory.station.stationcreated");
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
