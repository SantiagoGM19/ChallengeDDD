package com.challenge.CarFactory.Station.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Station.values.EmployeeId;
import com.challenge.CarFactory.Station.values.JobTitle;

public class EmployeeJobTitleChanged extends DomainEvent {

    private final EmployeeId employeeId;

    private final JobTitle jobTitle;

    public EmployeeJobTitleChanged(EmployeeId employeeId, JobTitle jobTitle) {
        super("carfactory.station.employeejobtitlechanged");
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }
}
