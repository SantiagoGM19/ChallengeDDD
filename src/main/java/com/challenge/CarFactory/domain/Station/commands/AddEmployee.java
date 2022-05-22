package com.challenge.CarFactory.domain.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Station.values.*;

public class AddEmployee extends Command {

    private final StationId stationId;
    private final EmployeeId employeeId;
    private final Name name;
    private final Identification identification;
    private final JobTitle jobTitle;

    public AddEmployee(StationId stationId, EmployeeId employeeId, Name name, Identification identification, JobTitle jobTitle) {
        this.stationId = stationId;
        this.employeeId = employeeId;
        this.name = name;
        this.identification = identification;
        this.jobTitle = jobTitle;
    }

    public StationId getStationId(){return stationId;}

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public Name getName() {
        return name;
    }

    public Identification getIdentification() {
        return identification;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }
}
