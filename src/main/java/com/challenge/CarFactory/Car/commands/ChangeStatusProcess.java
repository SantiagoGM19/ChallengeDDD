package com.challenge.CarFactory.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.Car.values.ProcessId;
import com.challenge.CarFactory.Car.values.Status;

public class ChangeStatusProcess extends Command {

    private final ProcessId entityId;
    private final Status status;

    public ChangeStatusProcess(ProcessId entityId, Status status){
        this.entityId = entityId;
        this.status = status;
    }

    public ProcessId getEntityId() {
        return entityId;
    }

    public Status getStatus() {
        return status;
    }

}

