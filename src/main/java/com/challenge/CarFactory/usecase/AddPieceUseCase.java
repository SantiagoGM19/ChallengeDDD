package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Car.commands.AddPiece;

public class AddPieceUseCase extends UseCase<RequestCommand<AddPiece>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPiece> addPieceRequestCommand) {
        var command = addPieceRequestCommand.getCommand();
        var car = Car.from(command.getCarId(), retrieveEvents(command.getCarId().value()));
        car.addPiece(command.getEntityId(), command.getPieceType());

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));
    }
}
