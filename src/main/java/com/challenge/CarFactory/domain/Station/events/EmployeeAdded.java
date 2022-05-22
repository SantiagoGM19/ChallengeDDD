package com.challenge.CarFactory.domain.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Station.values.EmployeeId;
import com.challenge.CarFactory.domain.Station.values.Identification;
import com.challenge.CarFactory.domain.Station.values.JobTitle;
import com.challenge.CarFactory.domain.Station.values.Name;

public class EmployeeAdded extends DomainEvent {

    private final EmployeeId employeeId;
    private final Name name;
    private final Identification identification;
    private final JobTitle jobTitle;

    public EmployeeAdded(EmployeeId employeeId, Name name, Identification identification, JobTitle jobTitle) {
        super("carfactory.station.employeeadded");
        this.employeeId = employeeId;
        this.name = name;
        this.identification = identification;
        this.jobTitle = jobTitle;
    }

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
