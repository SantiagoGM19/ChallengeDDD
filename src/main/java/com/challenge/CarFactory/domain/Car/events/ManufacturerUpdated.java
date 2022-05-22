package com.challenge.CarFactory.domain.Car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Car.values.Manufacturer;

public class ManufacturerUpdated extends DomainEvent {

    private final Manufacturer manufacturer;

    public ManufacturerUpdated(Manufacturer manufacturer){
        super("carfactory.car.manufacturerupdated");
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer(){
        return manufacturer;
    }
}
