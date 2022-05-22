package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.CarFactory.domain.Station.Station;
import com.challenge.CarFactory.domain.Station.commands.AddDayReportId;

public class AddDayReportIdUseCase extends UseCase<RequestCommand<AddDayReportId>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDayReportId> addDayReportIdRequestCommand) {
        var command = addDayReportIdRequestCommand.getCommand();
        var station = Station.from(command.getStationId(), retrieveEvents(command.getStationId().value()));
        station.addDayReportId(command.getDayReportId());

        emit().onResponse(new ResponseEvents(station.getUncommittedChanges()));
    }
}
