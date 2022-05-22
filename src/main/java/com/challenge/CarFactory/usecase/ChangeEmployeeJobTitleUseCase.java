package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.CarFactory.domain.Station.Station;
import com.challenge.CarFactory.domain.Station.commands.ChangeEmployeeJobTitle;

public class ChangeEmployeeJobTitleUseCase extends UseCase<RequestCommand<ChangeEmployeeJobTitle>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeEmployeeJobTitle> changeEmployeeJobTitleRequestCommand) {
        var command = changeEmployeeJobTitleRequestCommand.getCommand();
        var station = Station.from(command.getStationId(), retrieveEvents(command.getStationId().value()));
        station.changeEmployeeJobTitle(command.getEmployeeId(), command.getJobTitle());

        emit().onResponse(new ResponseEvents(station.getUncommittedChanges()));
    }
}
