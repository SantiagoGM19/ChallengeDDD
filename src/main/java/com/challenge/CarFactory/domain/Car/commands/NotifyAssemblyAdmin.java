package com.challenge.CarFactory.domain.Car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Car.values.CarId;

public class NotifyAssemblyAdmin extends Command {

    private final CarId carId;
    private final String message;

    public NotifyAssemblyAdmin(CarId carId, String message){
        this.carId = carId;
        this.message = message;
    }

    public CarId getCarId() {
        return carId;
    }

    public String getMessage() {
        return message;
    }
}
