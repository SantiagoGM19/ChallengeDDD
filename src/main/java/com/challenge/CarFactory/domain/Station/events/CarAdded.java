package com.challenge.CarFactory.domain.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Car.values.AssemblyReportId;
import com.challenge.CarFactory.domain.Car.values.CarId;
import com.challenge.CarFactory.domain.Car.values.Manufacturer;

public class CarAdded extends DomainEvent {

    private final CarId carId;
    private final AssemblyReportId assemblyReportId;
    private final Manufacturer manufacturer;

    public CarAdded(CarId carId, AssemblyReportId assemblyReportId, Manufacturer manufacturer) {
        super("carfactory.station.caradded");
        this.carId = carId;
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
