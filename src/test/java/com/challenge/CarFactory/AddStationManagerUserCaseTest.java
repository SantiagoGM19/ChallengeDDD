package com.challenge.CarFactory;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.CarFactory.domain.Station.commands.AddEmployee;
import com.challenge.CarFactory.domain.Station.commands.AddStationManager;
import com.challenge.CarFactory.domain.Station.events.EmployeeAdded;
import com.challenge.CarFactory.domain.Station.events.StationCreated;
import com.challenge.CarFactory.domain.Station.events.StationManagerAdded;
import com.challenge.CarFactory.domain.Station.values.*;
import com.challenge.CarFactory.usecase.AddEmployeeUseCase;
import com.challenge.CarFactory.usecase.AddStationManagerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddStationManagerUserCaseTest {

    private final String ROOTID = "S1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addStationManager(){
        var command = new AddStationManager(
                StationId.of(ROOTID),
                StationManagerId.of("SM1"),
                new Name("Jorge", "Walsh"),
                new Identification("9001278966"),
                new Shift("hybrid")
        );

        var useCase = new AddStationManagerUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new StationCreated(
                        new Type("external assembly")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding the employee to the station"))
                .getDomainEvents();

        var event = (StationManagerAdded)events.get(0);
        Assertions.assertEquals(command.getStationManagerId().value(), event.getStationManagerId().value());
        Assertions.assertEquals(command.getName().value().names(), event.getName().value().names());
        Assertions.assertEquals(command.getName().value().lastNames(), event.getName().value().lastNames());
        Assertions.assertEquals(command.getIdentification().value(), event.getIdentification().value());
        Assertions.assertEquals(command.getShift().value(), event.getShift().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
