package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.CarFactory.domain.Station.Station;
import com.challenge.CarFactory.domain.Station.commands.CreateStation;

public class CreateStationUseCase extends UseCase<RequestCommand<CreateStation>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateStation> createStationRequestCommand) {
        var command = createStationRequestCommand.getCommand();
        var station = new Station(
                command.getEntityId(),
                command.getDayReportId(),
                command.getType()
        );

        emit().onResponse(new ResponseEvents(station.getUncommittedChanges()));
    }
}
