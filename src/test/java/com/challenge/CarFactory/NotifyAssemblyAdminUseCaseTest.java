package com.challenge.CarFactory;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.challenge.CarFactory.domain.Car.events.AssemblyAdminNotified;
import com.challenge.CarFactory.domain.Car.events.CarCreated;
import com.challenge.CarFactory.domain.Car.values.Manufacturer;
import com.challenge.CarFactory.domain.Station.events.StationAdminNotified;
import com.challenge.CarFactory.domain.Station.events.StationCreated;
import com.challenge.CarFactory.domain.Station.values.Type;
import com.challenge.CarFactory.usecase.NotifyAssemblyAdminUseCase;
import com.challenge.CarFactory.usecase.NotifyStationAdminUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NotifyAssemblyAdminUseCaseTest {

    private final String ROOTID = "S1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyAssemblyAdmin(){
        var event = new CarCreated(
                new Manufacturer("Mazda")
        );

        event.setAggregateRootId(ROOTID);

        var useCase = new NotifyAssemblyAdminUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                event
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var eventResponse = (AssemblyAdminNotified)events.get(0);
        Assertions.assertEquals("The car was created", eventResponse.getMessage());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
