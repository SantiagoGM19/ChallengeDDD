package com.challenge.CarFactory.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.challenge.CarFactory.domain.Car.Car;
import com.challenge.CarFactory.domain.Car.events.CarCreated;
import com.challenge.CarFactory.domain.Car.values.CarId;
import com.challenge.CarFactory.domain.Station.Station;
import com.challenge.CarFactory.domain.Station.values.StationId;

public class NotifyAssemblyAdminUseCase extends UseCase<TriggeredEvent<CarCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CarCreated> carCreatedTriggeredEvent) {
        var event = carCreatedTriggeredEvent.getDomainEvent();
        var car = Car.from(CarId.of(event.aggregateRootId()), this.retrieveEvents());
        car.notifyAssemblyAdmin("The car was created");

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));
    }
}
