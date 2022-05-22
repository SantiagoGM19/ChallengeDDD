package com.challenge.CarFactory.domain.Car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Car.values.AssemblyReportId;
import com.challenge.CarFactory.domain.Car.values.Manufacturer;

public class CarCreated extends DomainEvent {

    private final Manufacturer manufacturer;

    public CarCreated(Manufacturer manufacturer){
        super("carfactory.car.carcreated");
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer(){return manufacturer;}

}
