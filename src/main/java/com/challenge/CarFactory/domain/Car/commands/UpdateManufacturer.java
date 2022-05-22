package com.challenge.CarFactory.domain.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Car.values.CarId;
import com.challenge.CarFactory.domain.Car.values.Manufacturer;

public class UpdateManufacturer extends Command {

    private final CarId carId;
    private final Manufacturer manufacturer;

    public UpdateManufacturer(CarId carId, Manufacturer manufacturer){
        this.carId = carId;
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer(){
        return manufacturer;
    }
}
