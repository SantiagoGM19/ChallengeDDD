package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Car.commands.CreateCar;

public class CreateCarUseCase extends UseCase<RequestCommand<CreateCar>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateCar> createCarRequestCommand) {
        var command = createCarRequestCommand.getCommand();
        var car = new Car(
                command.getCarId(),
                command.getManufacturer()
        );

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));
    }
}
