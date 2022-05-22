package com.challenge.CarFactory.domain.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Car.values.CarId;
import com.challenge.CarFactory.domain.Car.values.ProcessId;
import com.challenge.CarFactory.domain.Car.values.Status;

public class ChangeStatusProcess extends Command {

    private final CarId carId;
    private final ProcessId entityId;
    private final Status status;

    public ChangeStatusProcess(CarId carId, ProcessId entityId, Status status){
        this.carId = carId;
        this.entityId = entityId;
        this.status = status;
    }

    public CarId getCarId(){return carId;}

    public ProcessId getEntityId() {
        return entityId;
    }

    public Status getStatus() {
        return status;
    }

}

