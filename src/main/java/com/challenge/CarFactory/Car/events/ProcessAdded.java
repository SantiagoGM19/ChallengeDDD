package com.challenge.CarFactory.Car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.Car.values.Description;
import com.challenge.CarFactory.Car.values.ProcessId;
import com.challenge.CarFactory.Car.values.ProcessType;
import com.challenge.CarFactory.Car.values.Status;

public class ProcessAdded extends DomainEvent {

    private final ProcessId processId;
    private final ProcessType processType;
    private final Status status;
    private final Description description;


    public ProcessAdded(ProcessId processId, ProcessType processType, Status status, Description description){
        super("carfactory.car.processadded");
        this.processId = processId;
        this.processType = processType;
        this.status = status;
        this.description = description;
    }

    public ProcessId getProcessId() {
        return processId;
    }

    public ProcessType getProcessType() {
        return processType;
    }

    public Status getStatus() {
        return status;
    }

    public Description getDescription() {
        return description;
    }

}
