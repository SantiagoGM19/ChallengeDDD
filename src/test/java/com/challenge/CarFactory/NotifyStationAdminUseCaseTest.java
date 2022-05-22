package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.challenge.CarFactory.domain.Station.events.StationAdminNotified;
import com.challenge.CarFactory.domain.Station.events.StationCreated;
import com.challenge.CarFactory.domain.Station.values.Type;
import com.challenge.CarFactory.usecase.NotifyStationAdminUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NotifyStationAdminUseCaseTest {

    private final String ROOTID = "S1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notifyStationAdmin(){
        var event = new StationCreated(
                new Type("external assembly")
        );

        event.setAggregateRootId(ROOTID);

        var useCase = new NotifyStationAdminUseCase();

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

        var eventResponse = (StationAdminNotified)events.get(0);
        Assertions.assertEquals("The station was created", eventResponse.getMessage());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
