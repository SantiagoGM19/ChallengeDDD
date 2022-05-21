package com.challenge.CarFactory.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.Car.values.AssemblyReportId;

public class AddAssemblyReportId extends Command {

    private final AssemblyReportId assemblyReportId;

    public AddAssemblyReportId(AssemblyReportId assemblyReportId){
        this.assemblyReportId = assemblyReportId;
    }

    public AssemblyReportId getAssemblyReportId(){
        return assemblyReportId;
    }
}
