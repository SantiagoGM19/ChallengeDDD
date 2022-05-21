package com.challenge.CarFactory.Station;

import co.com.sofka.domain.generic.Entity;
import com.challenge.CarFactory.Station.values.EmployeeId;
import com.challenge.CarFactory.Station.values.Identification;
import com.challenge.CarFactory.Station.values.JobTitle;
import com.challenge.CarFactory.Station.values.Name;

import java.util.Objects;

public class Employee extends Entity<EmployeeId> {

    private Name name;
    private Identification identification;
    private JobTitle jobTitle;

    public Employee(EmployeeId entityId, Name name, Identification identification, JobTitle jobTitle) {
        super(entityId);
        this.name = name;
        this.identification = identification;
        this.jobTitle = jobTitle;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name, "The name can not be null");
    }

    public void updateIdentification(Identification identification){
        this.identification = Objects.requireNonNull(identification, "The identification can not be null");
    }

    public void updateJobTitle(JobTitle jobTitle){
        this.jobTitle = Objects.requireNonNull(jobTitle, "The job title can not be null");
    }

    public Name name() {
        return name;
    }

    public Identification identification() {
        return identification;
    }

    public JobTitle jobTitle() {
        return jobTitle;
    }
}
