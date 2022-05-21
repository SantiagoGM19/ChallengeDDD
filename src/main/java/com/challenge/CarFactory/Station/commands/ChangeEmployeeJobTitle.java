package com.challenge.CarFactory.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.Station.values.EmployeeId;
import com.challenge.CarFactory.Station.values.JobTitle;

public class ChangeEmployeeJobTitle extends Command {

    private final EmployeeId employeeId;
    private final JobTitle jobTitle;

    public ChangeEmployeeJobTitle(EmployeeId employeeId, JobTitle jobTitle) {
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
