package com.challenge.CarFactory.Car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Car.values.AssemblyReportId;
import com.challenge.CarFactory.Car.values.Manufacturer;

public class CarCreated extends DomainEvent {

    private final AssemblyReportId assemblyReportId;
    private final Manufacturer manufacturer;

    public CarCreated(AssemblyReportId assemblyReportId, Manufacturer manufacturer){
        super("carfactory.car.carcreated");
        this.assemblyReportId = assemblyReportId;
        this.manufacturer = manufacturer;
    }

    public AssemblyReportId getAssemblyReportId() {
        return assemblyReportId;
    }

    public Manufacturer getManufacturer(){return manufacturer;}

}
