package com.challenge.CarFactory.domain.Car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.CarFactory.domain.Car.values.ProcessId;
import com.challenge.CarFactory.domain.Car.values.Status;

public class StatusProcessChanged extends DomainEvent {

    private final ProcessId processId;
    private final Status status;

    public StatusProcessChanged(ProcessId processId, Status status){
        super("carfactory.car.statusprocesschanged");
        this.processId = processId;
        this.status = status;
    }

    public ProcessId getProcessId(){
        return processId;
    }

    public Status getStatus(){return status;}
}
