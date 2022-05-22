package com.challenge.CarFactory.domain.Car;

import co.com.sofka.domain.generic.Entity;
import com.challenge.CarFactory.domain.Car.values.Description;
import com.challenge.CarFactory.domain.Car.values.ProcessId;
import com.challenge.CarFactory.domain.Car.values.Status;
import com.challenge.CarFactory.domain.Car.values.ProcessType;

import java.util.Objects;

public class Process extends Entity<ProcessId> {

    private ProcessType processType;
    private Status status;
    private Description description;

    public Process(ProcessId entityId, ProcessType processType, Status status, Description description) {
        super(entityId);
        this.processType = processType;
        this.status = status;
        this.description = description;
    }

    public void updateProcessType(ProcessType ProcessType){
        this.processType = Objects.requireNonNull(ProcessType, "The process type must be defined, it is null");
    }

    public void cangeStatus(Status status){
        this.status = Objects.requireNonNull(status, "The process must have a status, you are giving a null one");
    }

    public void addDescription(Description description){
        this.description = Objects.requireNonNull(description, " The process must have a description, you are giving a null one");
    }

    public ProcessType ProcessType() {
        return processType;
    }

    public Status status() {
        return status;
    }

    public Description description() {
        return description;
    }
}
