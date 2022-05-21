package com.challenge.CarFactory.Car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Car.values.Manufacturer;

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
