package com.challenge.CarFactory.domain.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Car.values.AssemblyReportId;
import com.challenge.CarFactory.domain.Car.values.CarId;

public class AddAssemblyReportId extends Command {

    private final CarId carId;
    private final AssemblyReportId assemblyReportId;

    public AddAssemblyReportId(CarId carId, AssemblyReportId assemblyReportId){
        this.carId = carId;
        this.assemblyReportId = assemblyReportId;
    }

    public CarId getCarId(){return carId;}

    public AssemblyReportId getAssemblyReportId(){
        return assemblyReportId;
    }
}
