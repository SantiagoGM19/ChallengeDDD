
package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.CarFactory.domain.Station.Station;
import com.challenge.CarFactory.domain.Station.commands.AddEmployee;

public class AddEmployeeUseCase extends UseCase<RequestCommand<AddEmployee>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddEmployee> addEmployeeRequestCommand) {
        var command = addEmployeeRequestCommand.getCommand();
        var station = Station.from(command.getStationId(), retrieveEvents(command.getStationId().value()));
        station.addEmployee(command.getEmployeeId(), command.getName(), command.getIdentification(), command.getJobTitle());

        emit().onResponse(new ResponseEvents(station.getUncommittedChanges()));
    }
}
