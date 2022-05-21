package com.challenge.CarFactory.Car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Car.values.AssemblyReportId;

public class AssemblyReportIdAdded extends DomainEvent {

    private final AssemblyReportId assemblyReportId;

    public AssemblyReportIdAdded(AssemblyReportId assemblyReportId){
        super("carfactory.car.assemblyreportidadded");
        this.assemblyReportId = assemblyReportId;
    }

    public AssemblyReportId getAssemblyReportId() {
        return assemblyReportId;
    }
}
