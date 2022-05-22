package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Station.Station;
import com.challenge.CarFactory.domain.Station.commands.AddCar;

public class AddCarUseCase extends UseCase<RequestCommand<AddCar>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCar> addCarRequestCommand) {
        var command = addCarRequestCommand.getCommand();
        var station = Station.from(command.getStationId(), retrieveEvents(command.getStationId().value()));
        station.addCar(command.getCarId(), command.getAssemblyReportId(), command.getManufacturer());

        emit().onResponse(new ResponseEvents(station.getUncommittedChanges()));
    }
}
