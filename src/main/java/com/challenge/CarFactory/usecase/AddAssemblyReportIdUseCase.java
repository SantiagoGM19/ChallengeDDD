package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Car.commands.AddAssemblyReportId;

public class AddAssemblyReportIdUseCase extends UseCase<RequestCommand<AddAssemblyReportId>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddAssemblyReportId> addAssemblyReportIdRequestCommand) {
        var command = addAssemblyReportIdRequestCommand.getCommand();
        var car = Car.from(command.getCarId(), retrieveEvents(command.getCarId().value()));
        car.addAssemblyReportId(command.getAssemblyReportId());

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));
    }
}
