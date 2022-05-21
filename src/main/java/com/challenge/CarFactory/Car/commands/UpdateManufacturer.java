package com.challenge.CarFactory.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.Car.values.Manufacturer;

public class UpdateManufacturer extends Command {

    private final Manufacturer manufacturer;

    public UpdateManufacturer(Manufacturer manufacturer){
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer(){
        return manufacturer;
    }
}
