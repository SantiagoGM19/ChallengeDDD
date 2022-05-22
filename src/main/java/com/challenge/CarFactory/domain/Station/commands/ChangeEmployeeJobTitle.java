package com.challenge.CarFactory.domain.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Station.values.EmployeeId;
import com.challenge.CarFactory.domain.Station.values.JobTitle;
import com.challenge.CarFactory.domain.Station.values.StationId;

public class ChangeEmployeeJobTitle extends Command {

    private final StationId stationId;
    private final EmployeeId employeeId;
    private final JobTitle jobTitle;

    public ChangeEmployeeJobTitle(StationId stationId, EmployeeId employeeId, JobTitle jobTitle) {
        this.stationId = stationId;
        this.employeeId = employeeId;
        this.jobTitle = jobTitle;
    }

    public StationId getStationId(){return stationId;}

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }
}
