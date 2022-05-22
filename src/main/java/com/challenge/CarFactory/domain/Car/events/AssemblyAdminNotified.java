package com.challenge.CarFactory.domain.Car.events;

import co.com.sofka.domain.generic.DomainEvent;

public class AssemblyAdminNotified extends DomainEvent {

    private String message;

    public AssemblyAdminNotified(String message){
        super("carfactory.station.assemblyadminnotified");
        this.message = message;
    }

    public String getMessage(){return message;}
}
