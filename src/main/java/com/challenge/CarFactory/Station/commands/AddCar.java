package com.challenge.CarFactory.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.Car.values.AssemblyReportId;
import com.challenge.CarFactory.Car.values.CarId;
import com.challenge.CarFactory.Car.values.Manufacturer;

public class AddCar extends Command {

    private final CarId carId;
    private final AssemblyReportId assemblyReportId;
    private final Manufacturer manufacturer;

    public AddCar(CarId carId, AssemblyReportId assemblyReportId, Manufacturer manufacturer){
        this.carId =  carId;
        this.assemblyReportId = assemblyReportId;
        this.manufacturer = manufacturer;
    }

    public CarId getCarId() {
        return carId;
    }

    public AssemblyReportId getAssemblyReportId() {
        return assemblyReportId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

}
