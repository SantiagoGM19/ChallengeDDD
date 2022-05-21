package com.challenge.CarFactory.Station.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.Station.values.EmployeeId;
import com.challenge.CarFactory.Station.values.Identification;
import com.challenge.CarFactory.Station.values.JobTitle;
import com.challenge.CarFactory.Station.values.Name;

public class AddEmployee extends Command {

    private final EmployeeId employeeId;
    private final Name name;
    private final Identification identification;
    private final JobTitle jobTitle;

    public AddEmployee(EmployeeId employeeId, Name name, Identification identification, JobTitle jobTitle) {
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
