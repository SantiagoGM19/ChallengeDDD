package com.challenge.CarFactory.domain.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Car.values.*;

public class AddProcess extends Command {

    private final CarId carId;
    private final ProcessId entityId;
    private final ProcessType processType;
    private final Status status;
    private final Description description;

    public AddProcess(CarId carId, ProcessId entityId, ProcessType processType, Status status, Description description) {
        this.carId = carId;
        this.entityId = entityId;
        this.processType = processType;
        this.status = status;
        this.description = description;
    }

    public CarId getCarId(){return carId;}

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
