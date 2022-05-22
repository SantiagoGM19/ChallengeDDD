package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.challenge.CarFactory.domain.Station.Station;
import com.challenge.CarFactory.domain.Station.events.StationCreated;
import com.challenge.CarFactory.domain.Station.values.StationId;

public class NotifyStationAdminUseCase extends UseCase<TriggeredEvent<StationCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<StationCreated> stationCreatedTriggeredEvent) {
        var event = stationCreatedTriggeredEvent.getDomainEvent();
        var station = Station.from(StationId.of(event.aggregateRootId()), this.retrieveEvents());
        station.notifyStationAdmin("The station was created");

        emit().onResponse(new ResponseEvents(station.getUncommittedChanges()));
    }
}
