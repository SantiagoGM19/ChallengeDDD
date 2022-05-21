package com.challenge.CarFactory.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.Car.values.Description;
import com.challenge.CarFactory.Car.values.ProcessId;
import com.challenge.CarFactory.Car.values.ProcessType;
import com.challenge.CarFactory.Car.values.Status;

public class AddProcess extends Command {

    private final ProcessId entityId;
    private final ProcessType processType;
    private final Status status;
    private final Description description;

    public AddProcess(ProcessId entityId, ProcessType processType, Status status, Description description) {
        this.entityId = entityId;
        this.processType = processType;
        this.status = status;
        this.description = description;
    }

    public ProcessId getEntityId() {
        return entityId;
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
