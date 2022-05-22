package com.challenge.CarFactory.domain.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Car.values.AssemblyReportId;
import com.challenge.CarFactory.domain.Car.values.CarId;
import com.challenge.CarFactory.domain.Car.values.Manufacturer;

public class CreateCar extends Command {

    private final CarId carId;
    private final Manufacturer manufacturer;

    public CreateCar(CarId carId, Manufacturer manufacturer) {
        this.carId = carId;
        this.manufacturer = manufacturer;
    }

    public CarId getCarId() {
        return carId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }
}
