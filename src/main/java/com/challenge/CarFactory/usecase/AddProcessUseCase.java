package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Car.commands.AddPiece;
import com.challenge.CarFactory.domain.Car.commands.AddProcess;

public class AddProcessUseCase extends UseCase<RequestCommand<AddProcess>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddProcess> addProcessRequestCommand) {
        var command = addProcessRequestCommand.getCommand();
        var car = Car.from(command.getCarId(), retrieveEvents(command.getCarId().value()));
        car.addProcess(command.getEntityId(), command.getProcessType(), command.getStatus(), command.getDescription());

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));
    }
}
