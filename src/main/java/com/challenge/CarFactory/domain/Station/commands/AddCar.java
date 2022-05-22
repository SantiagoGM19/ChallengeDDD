package com.challenge.CarFactory.domain.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Car.values.AssemblyReportId;
import com.challenge.CarFactory.domain.Car.values.CarId;
import com.challenge.CarFactory.domain.Car.values.Manufacturer;
import com.challenge.CarFactory.domain.Station.values.StationId;

public class AddCar extends Command {

    private final StationId stationId;
    private final CarId carId;
    private final AssemblyReportId assemblyReportId;
    private final Manufacturer manufacturer;

    public AddCar(StationId stationId, CarId carId, AssemblyReportId assemblyReportId, Manufacturer manufacturer){
        this.stationId = stationId;
        this.carId =  carId;
        this.assemblyReportId = assemblyReportId;
        this.manufacturer = manufacturer;
    }

    public StationId getStationId(){return stationId;}

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
