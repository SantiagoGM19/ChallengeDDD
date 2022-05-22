package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.CarFactory.domain.Station.Station;
import com.challenge.CarFactory.domain.Station.commands.AddStationManager;

public class AddStationManagerUseCase extends UseCase<RequestCommand<AddStationManager>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddStationManager> addStationManagerRequestCommand) {
        var command = addStationManagerRequestCommand.getCommand();
        var station = Station.from(command.getStationId(), retrieveEvents(command.getStationId().value()));
        station.addStationManager(command.getStationManagerId(), command.getName(), command.getIdentification(), command.getShift());

        emit().onResponse(new ResponseEvents(station.getUncommittedChanges()));
    }
}
